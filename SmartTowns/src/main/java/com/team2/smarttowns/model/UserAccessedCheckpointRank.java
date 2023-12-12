package com.team2.smarttowns.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccessedCheckpointRank {
    private int id;
    private String name;
    private int count;

    public void toString(UserAccessedCheckpointRank userAccessedCheckpointRank) {
        System.out.println("id: " + userAccessedCheckpointRank.getId() + " name: " + userAccessedCheckpointRank.getName() + " count: " + userAccessedCheckpointRank.getCount());
    }
}
