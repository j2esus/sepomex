package com.j2esus.sepomex.controllers;

import java.util.Set;
import com.j2esus.sepomex.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sepomex/api")
public class StateController {
    private final StateRepository stateRepository;

    @Autowired
    public StateController(StateRepository stateRepository){
        this.stateRepository = stateRepository;
    }

    @GetMapping("/estados")
    public ResponseEntity<Set<String>> states(){
        return ResponseEntity.ok(stateRepository.getAllStates());
    }
}
