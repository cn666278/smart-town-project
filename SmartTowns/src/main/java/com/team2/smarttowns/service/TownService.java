package com.team2.smarttowns.service;

import com.team2.smarttowns.dao.TownRepository;
import com.team2.smarttowns.entity.TownEntity;

import java.util.List;

public class TownService {

    TownRepository townRepository;

    public List<TownEntity> getAllTowns() {
        return townRepository.getAllTowns();
    }

    public TownEntity getTownById(int id) {
        return townRepository.getTownById(id);
    }

}
