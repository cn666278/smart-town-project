package com.team2.smarttowns.service;

import com.team2.smarttowns.dao.CheckpointRepository;
import com.team2.smarttowns.dao.UserRepository;
import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.model.Checkpoint;
import com.team2.smarttowns.model.User;
import com.team2.smarttowns.model.UserAccessedCheckpointRank;
import com.team2.smarttowns.model.UserAccessedTrailRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;



/**
 * Get user info and checkpoints user have accessed.
 */
@Service
public class RankService {
    private final CheckpointRepository checkpointRepository;

    UserService UserService;
    private final UserRepository userRepository;
    @Autowired
    public RankService(CheckpointRepository checkpointRepository, UserService UserService, UserRepository userRepository) {
        this.checkpointRepository = checkpointRepository;
        this.UserService=UserService;
        this.userRepository = userRepository;
    }

    public List<Checkpoint> getAllUserCheckpoints() {
        List<Checkpoint> checkpoints = new ArrayList<>();

        // Requires checkpoints visited by all users
        List<CheckpointEntity> checkpointEntities = checkpointRepository.getAllCheckpoints();

        for (CheckpointEntity checkpointEntity : checkpointEntities) {
            checkpoints.add(checkpointEntityToModel(checkpointEntity));
        }

        return checkpoints;
    }

    public List<Checkpoint> checkpointUserAccessed(int userID) {
        List<Checkpoint> checkpoints = new ArrayList<>();

        // A checkpoint that the user has visited is required
        List<CheckpointEntity> checkpointEntities = checkpointRepository.getUserAccessedCheckpointsByUserId(userID);

        for (CheckpointEntity checkpointEntity : checkpointEntities) {
            checkpoints.add(checkpointEntityToModel(checkpointEntity));
        }

        return checkpoints;
    }




    public Checkpoint checkpointEntityToModel(CheckpointEntity checkpointEntity)
    {
        Checkpoint checkpoint=new Checkpoint();
        checkpoint.setId(checkpointEntity.getId());
        checkpoint.setName(checkpointEntity.getName());
        checkpoint.setImage(checkpointEntity.getImage());
        checkpoint.setLatitude(checkpointEntity.getLatitude());
        checkpoint.setLongitude(checkpointEntity.getLongitude());
        checkpoint.setAddress(checkpointEntity.getAddress());
        checkpoint.setDetail(checkpointEntity.getDetails());
        return (checkpoint);
    }

    public static void sortUsersByCheckpointCountDescending(List<User> users) {
        // Use Comparator.comparingInt to create a descending comparator that compares the size of List<Checkpoint>
        Comparator<User> descendingOrderComparator = Comparator.comparingInt(user -> user.getCheckpoints().size());

        // Sort the List using the Collections.sort method
        users.sort(descendingOrderComparator);
    }


    public List<UserAccessedCheckpointRank> getRankListSorted() {
        List<User> users = getAllUsers();
        List<UserAccessedCheckpointRank> userAccessedCheckpointRanks = new ArrayList<>();

        // Converts the User UserAccessedCheckpointRank and join the list
        for (User user : users) {
            UserAccessedCheckpointRank userAccessedCheckpointRank = new UserAccessedCheckpointRank();
            userAccessedCheckpointRank.setId(user.getId());
            userAccessedCheckpointRank.setName(user.getName());
            userAccessedCheckpointRank.setCount(user.getCheckpoints().size());
            userAccessedCheckpointRanks.add(userAccessedCheckpointRank);
        }

        // Sort by Comparator (from largest to smallest by count field)
        userAccessedCheckpointRanks.sort(Comparator.comparingInt(UserAccessedCheckpointRank::getCount).reversed());

        return userAccessedCheckpointRanks;
    }

    public List<UserAccessedTrailRank> getTrailRankListSorted() {
        List<User> users = getAllUsers();
        List<UserAccessedTrailRank> userAccessedTrailRanks = new ArrayList<>();

        // Converts the User UserAccessedCheckpointRank and join the list
        for (User user : users) {
            UserAccessedTrailRank userAccessedTrailRank = new UserAccessedTrailRank();
            userAccessedTrailRank.setId(user.getId());
            userAccessedTrailRank.setName(user.getName());
            userAccessedTrailRank.setCount(user.getCheckpoints().size());
            userAccessedTrailRanks.add(userAccessedTrailRank);
        }

        // Sort by Comparator (from largest to smallest by count field)
        userAccessedTrailRanks.sort(Comparator.comparingInt(UserAccessedTrailRank::getCount).reversed());

        return userAccessedTrailRanks;
    }


    List<User> getAllUsers()
    {
        return UserService.getAllUsers();
    }

    public UserAccessedCheckpointRank getUserInfoByName(String name) {
        return userRepository.getUserInfoByName(name);
    }
}