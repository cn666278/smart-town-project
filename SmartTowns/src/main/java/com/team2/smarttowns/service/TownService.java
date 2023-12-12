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

        // Alternative method(Lambda method):
        // townEntities.forEach(townEntity -> towns.add(new Town(townEntity.getId(), townEntity.getName(), townEntity.getImage(), townEntity.getDetail())));

        for (TownEntity townEntity : townEntities) {  // For each townEntity in townEntities
            Town town = new Town(); // Create a new Town object
            townEntityToModel(townEntity, town); // Convert the townEntity to a town model
            towns.add(town); // Add the town to the towns list
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
