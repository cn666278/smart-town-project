package com.team2.smarttowns.service;

import com.team2.smarttowns.dao.CheckpointRepository;
import com.team2.smarttowns.dao.TrailRepository;
import com.team2.smarttowns.dao.TrailRepositoryImpl;
import com.team2.smarttowns.dao.UserRepository;
import com.team2.smarttowns.entity.CheckpointEntity;
import com.team2.smarttowns.entity.UserEntity;
import com.team2.smarttowns.model.Checkpoint;
import com.team2.smarttowns.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserService
 * @Description User Service. Use to get data from dao and transfer entity to model
 *
 * @version 1.0
 *
 **/
@Service
public class UserService {

    TrailRepository trailRepository;
    UserRepository userRepository;

    CheckpointRepository checkpointRepository;

    @Autowired
    public UserService(TrailRepositoryImpl trailRepository, UserRepository userRepository, CheckpointRepository checkpointRepository) {
        this.trailRepository = trailRepository;
        this.userRepository = userRepository;
        this.checkpointRepository = checkpointRepository;
    }

    /**
     * get user trails by the checkpoints user visited
     *
     * @param id user id
     */
    public List<Integer> getTrailsByUserId(int id) {
        return trailRepository.getTrailsByUserId(id);
    }

    public List<Integer> getCompletedTrailsByUserId(int id) {

        return trailRepository.getCompletedTrailsByUserId(id);
    }

    /**
     * get user by user id
     *
     * @param id userId
     * @return User
     */

    public User getUserById(int id) {
        UserEntity userEntity = userRepository.getUserById(id);
        User user = userEntityToModel(userEntity);
        user.setCheckpoints(getUserCheckpointsByUserId(id));
        return user;
    }

    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userRepository.getAllUsers();
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            User user1 = userEntityToModel(userEntity);
            user1.setCheckpoints(getUserCheckpointsByUserId(user1.getId()));
            users.add(user1);
        }
        return users;
    }

    public List<Checkpoint> getUserCheckpointsByUserId(int id) {
        List<CheckpointEntity> checkpointEntities = trailRepository.getCheckpointsByUserId(id);
        List<Checkpoint> checkpoints = new ArrayList<>();
        for (CheckpointEntity checkpointEntity : checkpointEntities) {
            checkpoints.add(tranferCheckpointEntityToModel(checkpointEntity));
        }
        return checkpoints;
    }


    private User userEntityToModel(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setPassword(userEntity.getPassword());
        user.setProfileImg(userEntity.getProfileImg());
        user.setAccount(userEntity.getAccount());
        user.setEmail(userEntity.getEmail());
        user.setBadge(userEntity.getBadge());

        return user;

    }

    private Checkpoint tranferCheckpointEntityToModel(CheckpointEntity checkpointEntity) {
        Checkpoint checkpoint = new Checkpoint();
        checkpoint.setId(checkpointEntity.getId());
        checkpoint.setLatitude(checkpointEntity.getLatitude());
        checkpoint.setLongitude(checkpointEntity.getLongitude());
        checkpoint.setName(checkpointEntity.getName());
        checkpoint.setImage(checkpointEntity.getImage());
        checkpoint.setDescription(checkpointEntity.getDescription());
        return checkpoint;
    }

    public void updateUser(User user) {
        UserEntity userEntity = userToEntity(user);
        userRepository.updateUser(userEntity);

    }
    public UserEntity userToEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setPassword(user.getPassword());
        userEntity.setProfileImg(user.getProfileImg());
        userEntity.setAccount(user.getAccount());
        userEntity.setEmail(user.getEmail());
        userEntity.setBadge(user.getBadge());
        return userEntity;
    }
//    public List<Checkpoint> getCheckpointsByUserId(int id) {
//        List<CheckpointEntity> checkpointEntities = trailRepository.getCheckpointsByUserId(id);
//        List<Checkpoint> checkpoints = new ArrayList<>();
//
//    }

    /**
     * add record to user table and users_roles table
     * @param user
     */
    public void addUser(UserEntity user) {
        int id = userRepository.addUser(user);

        // role_id = 1 => admin;
        // role_id = 2 => user;
        userRepository.assignRole4User(id,2);
    }

}