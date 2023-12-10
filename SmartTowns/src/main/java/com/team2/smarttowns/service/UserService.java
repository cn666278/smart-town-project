package com.team2.smarttowns.service;

import com.team2.smarttowns.dao.TrailRepositoryImpl;

import java.util.List;

@Service
public class UserService {

    TrailRepository trailRepository;

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
        TrailRepositoryImpl trailRepository = new TrailRepositoryImpl();
        return trailRepository.getTrailsByUserId(id);
    }

    public List<Integer> getCompletedTrailsByUserId(int id) {
        TrailRepositoryImpl trailRepository = new TrailRepositoryImpl();
        return trailRepository.getCompletedTrailsByUserId(id);
    }


}