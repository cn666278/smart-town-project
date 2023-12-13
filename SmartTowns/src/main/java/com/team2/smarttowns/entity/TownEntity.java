package com.team2.smarttowns.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TownEntity {

    private int id;
    private String name;
    private String detail;
    private String image;

}
