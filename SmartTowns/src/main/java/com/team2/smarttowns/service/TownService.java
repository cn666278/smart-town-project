package com.team2.smarttowns.service;

import com.team2.smarttowns.dao.TownRepository;
import com.team2.smarttowns.entity.TownEntity;
import com.team2.smarttowns.model.Town;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TownService {

    TownRepository townRepository;

    public List<Town> getAllTowns() {
        List<Town> towns = new ArrayList<>();
        //get data from dao. Then transfer entity to model
        List<TownEntity> townEntities = townRepository.getAllTowns();

        for (TownEntity townEntity : townEntities) {
            Town town = new Town();
            townEntityToModel(townEntity, town);
            towns.add(town);
        }

        return towns;

    }

    private void townEntityToModel(TownEntity townEntity, Town town) {
        town.setId(townEntity.getId());
        town.setName(townEntity.getName());
        town.setImage(townEntity.getImage());
        town.setDetail(townEntity.getDetail());
    }

    public TownEntity getTownById(int id) {
        return townRepository.getTownById(id);
    }

    @Autowired
    public void setTownRepository(TownRepository townRepository) {
        this.townRepository = townRepository;
    }
}
