package com.j2esus.sepomex.controllers;

import java.util.Set;
import com.j2esus.sepomex.model.Town;
import com.j2esus.sepomex.repositories.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sepomex/v1/")
public class TownController {
  private final TownRepository townRepository;

  @Autowired
  public TownController(TownRepository townRepository){
    this.townRepository = townRepository;
  }

  @GetMapping("municipios")
  public ResponseEntity<Set<Town>> towns(
      @RequestParam(value = "estado") String state){
    return ResponseEntity.ok(townRepository.findByState(state));
  }
}
