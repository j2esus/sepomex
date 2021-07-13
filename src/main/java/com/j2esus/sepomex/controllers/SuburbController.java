package com.j2esus.sepomex.controllers;

import java.util.List;
import com.j2esus.sepomex.model.Suburb;
import com.j2esus.sepomex.repositories.SuburbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sepomex/v1/")
public class SuburbController {
  private final SuburbRepository suburbRepository;

  @Autowired
  public SuburbController(SuburbRepository suburbRepository){
    this.suburbRepository = suburbRepository;
  }

  @GetMapping("colonias/codigo-postal/{zipCode}")
  public ResponseEntity<List<Suburb>> suburbs(@PathVariable String zipCode){
    return ResponseEntity.ok(suburbRepository.findByZipCode(zipCode));
  }

  @GetMapping("colonias")
  public ResponseEntity<List<Suburb>> suburbs(
    @RequestParam(value = "estado") String state,
    @RequestParam(value = "municipio") String town){
    return ResponseEntity.ok(suburbRepository.findByStateAndTown(state, town));
  }
}
