package com.team2.smarttowns.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName User
 * @Description User model. User as viewmodel
 * @Author CHENKE SUN
 *
 * @version 1.0
 *
 **/
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
    private List<Checkpoint> checkpoints=new ArrayList<>();
}
