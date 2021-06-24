package com.j2esus.sepomex.repositories;

import java.util.TreeSet;
import java.util.Set;
import java.util.stream.Collectors;
import com.j2esus.sepomex.util.Datasource;
import org.springframework.stereotype.Repository;

@Repository
public class StateRepository {
  private Set<String> states = null;

  public Set<String> getAllStates(){
    if(states == null)
      loadAllStates();
    return states;
  }

  private void loadAllStates(){
    states = new TreeSet<>(
      Datasource.getSuburbs()
      .stream()
      .map(item -> item.getState())
      .collect(Collectors.toSet())
    );
  }
}
