package com.j2esus.sepomex.controllers;

import java.util.List;

import com.j2esus.sepomex.model.Suburb;
import com.j2esus.sepomex.repositories.SuburbRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sepomex/api")
public class SuburbController {
  private final SuburbRepository suburbRepository;

  @Autowired
  public SuburbController(SuburbRepository suburbRepository){
    this.suburbRepository = suburbRepository;
  }

  @GetMapping("/colonias/codigoPostal/{zipCode}")
  public ResponseEntity<List<Suburb>> suburbs(@PathVariable String zipCode){
    return ResponseEntity.ok(suburbRepository.findByZipCode(zipCode));
  }

  @GetMapping("/colonias/estado/nombre/{state}/municipio/nombre/{town}")
  public ResponseEntity<List<Suburb>> suburbs(@PathVariable String state,
    @PathVariable String town){
    return ResponseEntity.ok(suburbRepository.findByStateAndTown(state, town));
  }
  
}
