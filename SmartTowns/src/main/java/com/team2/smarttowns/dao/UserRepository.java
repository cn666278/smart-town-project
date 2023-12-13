package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.UserEntity;
import com.team2.smarttowns.model.UserAccessedCheckpointRank;

import java.util.List;

public interface UserRepository {
    List<UserEntity> getAllUsers();

    UserEntity getUserByAccount(String account);

    UserEntity getUserById(int id);

    void updateUser(UserEntity userEntity);

    int addUser(UserEntity user);

    void assignRole4User(int userId, int roleId);
    UserAccessedCheckpointRank getUserInfoByName(String name);

}
