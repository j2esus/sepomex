package com.j2esus.sepomex.repositories;

import java.util.TreeSet;
import java.util.Set;
import java.util.stream.Collectors;
import com.j2esus.sepomex.util.Datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StateRepository {
  private Set<String> states = null;
  private final Datasource datasource;

  @Autowired
  public StateRepository(Datasource datasource){
    this.datasource = datasource;
  }

  public Set<String> getAllStates(){
    if(states == null)
      loadAllStates();
    return states;
  }

  private void loadAllStates(){
    states = new TreeSet<>(
      datasource.getSuburbs()
      .stream()
      .map(item -> item.getState())
      .collect(Collectors.toSet())
    );
  }
}
