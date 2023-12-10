package com.team2.smarttowns.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckpointEntity {
    private int id;
    private String name;
    private String image;
    private String description;
    private String contact;
    private String latitude;
    private String longitude;
    private String address;

}