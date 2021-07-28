package com.j2esus.sepomex.repositories;

import java.util.List;
import java.util.stream.Collectors;

import com.j2esus.sepomex.model.Suburb;
import com.j2esus.sepomex.util.Constants;
import com.j2esus.sepomex.util.Datasource;
import com.j2esus.sepomex.util.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SuburbRepository {
  private final Datasource datasource;

  @Autowired
  public SuburbRepository(Datasource datasource){
    this.datasource = datasource;
  }
  
  public List<Suburb> findByZipCode(String zipCode){
    return datasource.getSuburbs().stream()
      .filter(item -> item.getZipCode().equals(zipCode))
      .collect(Collectors.toList());
  }

  public List<Suburb> findByStateAndTown(String state, String town){
    return datasource.getSuburbs().stream()
      .filter(item ->
        Utilities.equalsIgnoreDiacritics(item.getState(), state.trim()) &&
        Utilities.equalsIgnoreDiacritics(item.getTown(), town.trim()))
      .collect(Collectors.toList());
  }

  public List<Suburb> findByName(String name){
    if(name.length() >= Constants.MINIMUM_CHARACTER_FOR_EXECUTE_QUERY)
      return datasource.getSuburbs().stream()
        .filter(item -> item.getName().toUpperCase()
          .contains(name.trim().toUpperCase()))
        .collect(Collectors.toList());
    return List.of();
  }
}
