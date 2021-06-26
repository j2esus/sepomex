package com.j2esus.sepomex.repositories;

import java.util.List;
import java.util.stream.Collectors;

import com.j2esus.sepomex.model.Suburb;
import com.j2esus.sepomex.util.Datasource;

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
}
