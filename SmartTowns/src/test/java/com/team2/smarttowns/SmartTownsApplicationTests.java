package com.team2.smarttowns;

import com.team2.smarttowns.dao.CheckpointRepository;
import com.team2.smarttowns.dao.TrailRepository;
import com.team2.smarttowns.dao.UserRepository;
import com.team2.smarttowns.entity.CheckpointEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class SmartTownsApplicationTests {

    private TrailRepository trailRepository;
    private CheckpointRepository checkpointRepository;
    private UserRepository userRepository;

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
//    @Test
//    void addCheckpoint() {
//        checkpointRepository.addCheckpoint(new CheckpointEntity(0,
//                "Cardiff Bay",
//                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Cardiff_Bay_121020_2469_%2850599762103%29_-_Flickr_-_Richard_Szwejkowski.jpg/1920px-Cardiff_Bay_121020_2469_%2850599762103%29_-_Flickr_-_Richard_Szwejkowski.jpg",
//                "Cardiff Bay (Welsh: Bae Caerdydd; colloquially \"The Bay\") is an area and freshwater lake[1][2] in Cardiff, Wales. The site of a former tidal bay and estuary, it is the river mouth of the River Taff and Ely.",
//                "https://www.cardiffbay.co.uk/",
//                "51.4539° N",
//                "3.1694° W",
//                "Cardiff CF10 3EU"));
//        getAllCheckpoints();
//    }

    /**
     * Test to update an existing checkpoint
     */
//    @Test
//    void updateCheckpoint() {
//        checkpointRepository.updateCheckpoint(new CheckpointEntity(1,
//                "Cardiff Bay",
//                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Cardiff_Bay_121020_2469_%2850599762103%29_-_Flickr_-_Richard_Szwejkowski.jpg/1920px-Cardiff_Bay_121020_2469_%2850599762103%29_-_Flickr_-_Richard_Szwejkowski.jpg",
//                "Cardiff Bay (Welsh: Bae Caerdydd; colloquially \"The Bay\") is an area and freshwater lake[1][2] in Cardiff, Wales. The site of a former tidal bay and estuary, it is the river mouth of the River Taff and Ely.",
//                "https://www.cardiffbay.co.uk/",
//                "51.4539° N",
//                "3.1694° W",
//                "Cardiff CF10 3EU"));
//        getAllCheckpoints();
//    }

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

//    @Test
//    void testUpdateUser() {
//        //'user1',
//        //        '$2a$10$o5LRNO84QaTX62LzsF2AbuJL8qiU/CLpVMB7l4LKIAP8hxx0IfITu',
//        //        'https://cn.i.cdn.ti-platform.com/cnapac/content/701/showpage/we-bare-bears/sa/showicon.png',
//        //        123,
//        //        'user@cardiff.ac.uk',
//        //        'dragon hero'
//
//        User user = userservice.getUserById(1);
//        user.setName("user1");
//        user.setEmail("1111111@qq.com");
//        userservice.updateUser(user);
//    }
    /**
     * Test for TrailService
     *
     */

    @Test
    void testTrailService() {
        // TrailService = new TrailService();
        // List<Trail> trails = trailService.getTrailsByUserId(1);
        // for (Trail trail : trails) {
        //     System.out.println(trail);
        // }
    }


    @Test
    void testTrailRepository() {
        // List<Integer> list = trailRepository.getTrailsByUserId(1);
        // list.forEach(System.out::println);
    }

    @Test
    void testTrailRepository2() {
        // List<Integer> list = trailRepository.getCompletedTrailsByUserId(1);
        // list.forEach(System.out::println);
    }

    @Test
    void testTrailRepository3() {
        // List<CheckpointEntity> list = trailRepository.getCheckpointsByUserId(1);
        // list.forEach(System.out::println);
    }


    /**
     * Test for CheckpointService
     */

    @Test
    void testCheckpointService() {
        // CheckpointService checkpointService = new CheckpointService();
        // List<Checkpoint> checkpoints = checkpointService.getCheckpointsByTrailId(1);
        // for (Checkpoint checkpoint : checkpoints) {
        //     System.out.println(checkpoint);
        // }
    }

    /**
     * Test for CheckpointRepository
     */

    @Test
    void testCheckpointRepository() {
        // List<CheckpointEntity> list = checkpointRepository.getCheckpointsByTrailId(1);
        // list.forEach(System.out::println);
    }

    @Test
    void testCheckpointRepository2() {
        // List<Integer> list = checkpointRepository.getByUserId(1);
        // list.forEach(System.out::println);
    }

    @Autowired
    public SmartTownsApplicationTests(CheckpointRepository checkpointRepository, TrailRepository trailRepository, UserRepository userRepository) {
        this.checkpointRepository = checkpointRepository;
        this.trailRepository=trailRepository;
        this.userRepository = userRepository;
    }

    @Test
    void testGetUserInfoByName(){
        System.out.println(userRepository.getUserInfoByName("admin1"));
    }
//  @Test
//
//    void testUpdateUser() {
//     *
//        //'user1',
//     */
//        //        '$2a$10$o5LRNO84QaTX62LzsF2AbuJL8qiU/CLpVMB7l4LKIAP8hxx0IfITu',
//
//        //        'https://cn.i.cdn.ti-platform.com/cnapac/content/701/showpage/we-bare-bears/sa/showicon.png',
//    @Test
//        //        123,
//    void testTrailService() {
//        //        'user@cardiff.ac.uk',
//        // TrailService = new TrailService();
//        //        'dragon hero'
//        // List<Trail> trails = trailService.getTrailsByUserId(1);
//
//        // for (Trail trail : trails) {
//        User user = userservice.getUserById(1);
//        //     System.out.println(trail);
//        user.setName("user1");
//        // }
//        user.setEmail("1111111@qq.com");
//    }
//        userservice.updateUser(user);
//
//    }
}
