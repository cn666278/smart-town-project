package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.UserEntity;
import com.team2.smarttowns.model.User;

import java.util.List;

public interface UserRepository {
    List<UserEntity> getAllUsers();

    User getUserByAccount(String account);

}
