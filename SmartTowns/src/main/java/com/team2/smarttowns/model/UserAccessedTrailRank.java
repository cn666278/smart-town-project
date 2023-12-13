package com.team2.smarttowns.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccessedTrailRank {
    private int id;
    private String name;
    private int count;

    public void toString(UserAccessedTrailRank userAccessedTrailRank) {
        System.out.println("id: " + userAccessedTrailRank.getId() + " name: " + userAccessedTrailRank.getName() + " count: " + userAccessedTrailRank.getCount());
    }

}
