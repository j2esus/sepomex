package com.j2esus.sepomex.controllers;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sepomex/api/")
public class StateController {

    @GetMapping("/estados")
    public ResponseEntity<List<String>> states(){
        List<String> states = Arrays.asList(
            "Aguascalientes",
            "Morelos",
            "Guerrero",
            "Yucatán");
        return ResponseEntity.ok(states);
    }
}
