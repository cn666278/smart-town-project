package com.team2.smarttowns.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private String password;
    private String profileImg;
    private String account;
    private String email;
    private String badge;

}
