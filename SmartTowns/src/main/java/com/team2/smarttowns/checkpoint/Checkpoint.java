package com.team2.smarttowns.checkpoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Checkpoint {
    private int id;
    private String name;
    private String img;
    private String description;
    private String contact;
}