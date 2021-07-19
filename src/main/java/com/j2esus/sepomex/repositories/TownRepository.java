package com.j2esus.sepomex.repositories;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.j2esus.sepomex.model.Town;
import com.j2esus.sepomex.model.Suburb;
import com.j2esus.sepomex.util.Datasource;
import com.j2esus.sepomex.util.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TownRepository {
  private Set<Town> towns = null;
  private final Datasource datasource;

  @Autowired
  public TownRepository(Datasource datasource){
    this.datasource = datasource;
    loadAllTownsFromDatasource();
  }

  private void loadAllTownsFromDatasource(){
    if(towns == null){
      towns = new TreeSet<>(
        datasource.getSuburbs().stream()
          .map(this::suburbToTown)
          .collect(Collectors.toSet())
      );
    }
  }

  private Town suburbToTown(Suburb suburb){
    return new Town(suburb.getTown(), suburb.getState());
  }

  public Set<Town> findByState(String state){
    return towns.stream().filter(item -> 
        Utilities.equalsIgnoreDiacritics(item.getState(), state.trim()))
      .collect(Collectors.toSet());
  }
}
