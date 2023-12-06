package com.team2.smarttowns.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckpointEntity {

    private int id;
    private String latitude;
    private String longitude;
    private String name;
    private String image;
    private String detail;
    private String address;

}
