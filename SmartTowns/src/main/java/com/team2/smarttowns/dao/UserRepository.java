package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.UserEntity;

import java.util.List;

public interface UserRepository {
    List<UserEntity> getAllUsers();

    UserEntity getUserByAccount(String account);

    UserEntity getUserById(int id);


    int addUser(UserEntity user);

    void assignRole4User(int userId, int roleId);

    int getIdByName(String name);

    int getCheckpointAmountByUserId(int userId);
}
