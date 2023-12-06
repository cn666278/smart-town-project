package com.team2.smarttowns.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity

    private int id;
    private String name;
    private String password;
    private String profile_img;
    private String account;
    private String email;
    private String badget;

}