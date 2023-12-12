package com.team2.smarttowns.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private DataSource dataSource;

    public static final String[] ENDPOINTS_WHITELIST = {"/checkpoint/**", "/about", "/home",
            "/towns", "/trails", "/trailsmap","/static/**","/css/**","/img/**","/js/**"};
    public static final String[] USER_ENDPOINTS_WHITELIST = {"/myaccount"};


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request
                        .requestMatchers(ENDPOINTS_WHITELIST).permitAll()
                        .requestMatchers(USER_ENDPOINTS_WHITELIST).hasRole("USER")
                        .anyRequest().hasRole("ADMIN"))
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form
                        .loginPage("/login").permitAll()
                        .defaultSuccessUrl("/myaccount",true));
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {
        JdbcDaoImpl jdbcUserDetails = new JdbcDaoImpl();
        jdbcUserDetails.setDataSource(dataSource);
        jdbcUserDetails.setUsersByUsernameQuery("select username, password, enabled from users where username=?");
        jdbcUserDetails.setAuthoritiesByUsernameQuery("select username, authority from user_authorities where username=?");
        return jdbcUserDetails;
    }

    @Autowired
    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
