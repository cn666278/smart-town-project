package com.team2.smarttowns.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Checkpoint
 * @Description Checkpoint model. User as viewmodel
 * @Author CHENKE SUN
 *
 * @version 1.0
 *
 **/
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
