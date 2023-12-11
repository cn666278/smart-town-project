package com.team2.smarttowns.service;

import com.team2.smarttowns.dao.CheckpointRepository;
import com.team2.smarttowns.dao.CheckpointRepositoryImpl;
import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.model.Checkpoint;
import com.team2.smarttowns.model.User;
import com.team2.smarttowns.model.UserAccessedCheckpointRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;



/**
 * Get user info and checkpoints user have accessed.
 */
@Service
public class RankService {
    private final CheckpointRepository checkpointRepository;

    UserService UserService;
    @Autowired
    public RankService(CheckpointRepository checkpointRepository, UserService UserService) {
        this.checkpointRepository = checkpointRepository;
        this.UserService=UserService;
    }

    public List<Checkpoint> getAllUserCheckpoints() {
        List<Checkpoint> checkpoints = new ArrayList<>();

        // 需要所有用户访问过的检查点
        List<CheckpointEntity> checkpointEntities = checkpointRepository.getAllCheckpoints();

        for (CheckpointEntity checkpointEntity : checkpointEntities) {
            checkpoints.add(checkpointEntityToModel(checkpointEntity));
        }

        return checkpoints;
    }

    public List<Checkpoint> checkpointUserAccessed(int userID) {
        List<Checkpoint> checkpoints = new ArrayList<>();

        // 需要用户访问过的检查点
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
        checkpoint.setDetail(checkpointEntity.getDetail());
        return (checkpoint);
    }

    public static void sortUsersByCheckpointCountDescending(List<User> users) {
        // 使用Comparator.comparingInt创建一个降序比较器，比较List<Checkpoint>的大小
        Comparator<User> descendingOrderComparator = Comparator.comparingInt(user -> user.getCheckpoints().size());

        // 使用Collections.sort方法对List进行排序
        users.sort(descendingOrderComparator);
    }

    /**
     * get a sorted list in descending order  of data, each data contains user's name and the number of checkpoints he/she has accessed
     *
     */
    List<User> getRankList() {
        List<User> users = getAllUsers();
        sortUsersByCheckpointCountDescending(users);
        return users;
    }


    public List<UserAccessedCheckpointRank> getRankListSorted() {
        List<User> users = getRankList();
        List<UserAccessedCheckpointRank> userAccessedCheckpointRanks = new ArrayList<>();
        for (User user : users) {
            UserAccessedCheckpointRank userAccessedCheckpointRank = new UserAccessedCheckpointRank();
            userAccessedCheckpointRank.setId(user.getId());
            userAccessedCheckpointRank.setName(user.getName());
            userAccessedCheckpointRank.setCount(user.getCheckpoints().size());
            userAccessedCheckpointRanks.add(userAccessedCheckpointRank);
        }
        return userAccessedCheckpointRanks;
    }


    List<User> getAllUsers()
    {
        return UserService.getAllUsers();
    }
}