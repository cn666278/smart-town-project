package com.team2.smarttowns.records;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrailToCheckpoint {
    private int id;
    private int trail_id;
    private int checkpoint_id;
}
