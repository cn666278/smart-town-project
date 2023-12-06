package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.TrailEntity;
import com.team2.smarttowns.users.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    User getUserByAccount(String account);

}
