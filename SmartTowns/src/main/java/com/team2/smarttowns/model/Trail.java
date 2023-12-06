package com.team2.smarttowns.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trail {

    private int id;
    private String name;
    private String image;
    private String details;
    private List<Checkpoint> checkpoints;

}
