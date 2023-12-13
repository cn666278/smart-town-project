package com.team2.smarttowns.dao;

import com.team2.smarttowns.entity.TownEntity;

import java.util.List;

public interface TownRepository {
    List<TownEntity> getAllTowns();

    TownEntity getTownById(int id);
}
