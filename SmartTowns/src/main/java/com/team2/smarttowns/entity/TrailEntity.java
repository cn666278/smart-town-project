package com.team2.smarttowns.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrailEntity {

    private int id;
    private String name;
    private String image;
    private String details;

}
