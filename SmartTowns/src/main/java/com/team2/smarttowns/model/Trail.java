package com.team2.smarttowns.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Trail
 * @Description Trail model. User as viewmodel
 * @Author CHENKE SUN
 *
 * @version 1.0
 *
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trail {

    private int id;
    private String name;
    private String image;
    private String details;
    private List<Checkpoint> checkpoints=new ArrayList<>();

}
