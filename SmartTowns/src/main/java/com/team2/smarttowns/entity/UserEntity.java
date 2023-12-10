package com.team2.smarttowns.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity{

    private int id;
    private String name;
    private String password;
    private String profileImg;
    private String account;
    private String email;
    private String badge;

}