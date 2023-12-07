package com.team2.smarttowns;

import com.team2.smarttowns.dao.CheckpointRepository;
import com.team2.smarttowns.dao.CheckpointRepositoryImpl;
import com.team2.smarttowns.entity.CheckpointEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootTest
class SmartTownsApplicationTests {
    @Autowired
    private CheckpointRepository checkpointRepository;

    @Test
    void getAllCheckpoints() {
        List<CheckpointEntity> list = checkpointRepository.getAllCheckpoints();
        for (CheckpointEntity checkpointEntity : list) {
            System.out.println(checkpointEntity);
        }
    }

    @Test
    void addCheckpoint() {
        checkpointRepository.addCheckpoint(new CheckpointEntity(0,
                "Cardiff Bay",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Cardiff_Bay_121020_2469_%2850599762103%29_-_Flickr_-_Richard_Szwejkowski.jpg/1920px-Cardiff_Bay_121020_2469_%2850599762103%29_-_Flickr_-_Richard_Szwejkowski.jpg",
                "Cardiff Bay (Welsh: Bae Caerdydd; colloquially \"The Bay\") is an area and freshwater lake[1][2] in Cardiff, Wales. The site of a former tidal bay and estuary, it is the river mouth of the River Taff and Ely.",
                "https://www.cardiffbay.co.uk/",
                "51.4539° N",
                "3.1694° W",
                "Cardiff CF10 3EU"));
        getAllCheckpoints();
    }

    @Test
    void updateCheckpoint() {
        checkpointRepository.updateCheckpoint(new CheckpointEntity(1,
                "Cardiff Bay",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Cardiff_Bay_121020_2469_%2850599762103%29_-_Flickr_-_Richard_Szwejkowski.jpg/1920px-Cardiff_Bay_121020_2469_%2850599762103%29_-_Flickr_-_Richard_Szwejkowski.jpg",
                "Cardiff Bay (Welsh: Bae Caerdydd; colloquially \"The Bay\") is an area and freshwater lake[1][2] in Cardiff, Wales. The site of a former tidal bay and estuary, it is the river mouth of the River Taff and Ely.",
                "https://www.cardiffbay.co.uk/",
                "51.4539° N",
                "3.1694° W",
                "Cardiff CF10 3EU"));
        getAllCheckpoints();
    }

    @Test
    void deleteCheckpoint() {
        checkpointRepository.deleteCheckpoint(1);
        getAllCheckpoints();
    }
}
