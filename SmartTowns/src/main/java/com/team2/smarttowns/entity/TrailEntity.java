package com.team2.smarttowns.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName TrailEntity
 * @Description Trail Entity stored in database
 * @Author CHENKE SUN
 *
 * @version 1.0
 *
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrailEntity {

    private int id;
    private String name;
    private String image;
    private String details;

}
