package com.team2.smarttowns;

import com.team2.smarttowns.dao.CheckpointRepository;
import com.team2.smarttowns.dao.CheckpointRepositoryImpl;
import com.team2.smarttowns.entity.CheckpointEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
class SmartTownsApplicationTests {
    @Autowired
    private CheckpointRepository checkpointRepository;

    /**
     * Test to retrieve all checkpoints
     */
    @Test
    void getAllCheckpoints() {
        List<CheckpointEntity> list = checkpointRepository.getAllCheckpoints();
        for (CheckpointEntity checkpointEntity : list) {
            System.out.println(checkpointEntity);
        }
    }

    /**
     * Test to add a new checkpoint
     */
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

    /**
     * Test to update an existing checkpoint
     */
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

    /**
     * Test to delete a checkpoint
     */
    @Test
    void deleteCheckpoint() {
        checkpointRepository.deleteCheckpoint(1);
        getAllCheckpoints();
    }

    /**
     * Test to get checkpoints associated with a specific user
     */
    @Test
    void getCheckpointsByUserId() {
        checkpointRepository.addUserCheckpoint(1, 1);
        checkpointRepository.addUserCheckpoint(2, 1);
        List<Integer> list = checkpointRepository.getByUserId(1);
        list.forEach(System.out::println);
    }

    /**
     * Test for password encoding
     */
    @Test
    void testPasswordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "user1";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }

}
