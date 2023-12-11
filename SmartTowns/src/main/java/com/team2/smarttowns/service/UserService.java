package com.team2.smarttowns.service;

import com.team2.smarttowns.dao.TrailRepository;
import com.team2.smarttowns.dao.TrailRepositoryImpl;
import com.team2.smarttowns.dao.UserRepository;
import com.team2.smarttowns.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    TrailRepository trailRepository;
    UserRepository userRepository;

    @Autowired
    public UserService(TrailRepositoryImpl trailRepository) {
        this.trailRepository=trailRepository;
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
     * @param id userId
     * @return User
     */
    public UserEntity getUserById(int id) {
        return userRepository.getUserById(id);
    }

}