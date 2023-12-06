package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trails {
    private int id;
    private String name;
    private int image;
    private String details;
    private String checkpoints_id;
}
