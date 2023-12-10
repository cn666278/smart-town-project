package com.team2.smarttowns.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Checkpoint {

    private int id;
    private String latitude;
    private String name;
    private String longitude;
    private String image;
    private String detail;
    private String address;
    private String description;

}
