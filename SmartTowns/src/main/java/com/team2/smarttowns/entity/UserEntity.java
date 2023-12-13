package com.team2.smarttowns.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private int id;
    @NotEmpty(message = "The name cannot be empty")
    private String name;
    @Length(min = 5, message = "length should not be less than 5")
    private String password;
    private boolean enabled;
    private String profileImg;
    private String account;
    @Email(message = "format of email address is not correct")
    private String email;
    private String badge;

}