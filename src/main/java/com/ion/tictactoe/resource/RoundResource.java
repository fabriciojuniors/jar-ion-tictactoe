package com.ion.tictactoe.resource;

import com.ion.tictactoe.controller.RoundController;
import com.ion.tictactoe.exceptions.GameIsOverException;
import com.ion.tictactoe.model.Round;
import com.ion.tictactoe.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "round")
public class RoundResource {

    @Autowired
    RoundRepository repository;

    @Autowired
    RoundController controller;

    @PostMapping
    public ResponseEntity<Round> save(@RequestBody Round round) throws GameIsOverException {
        try{
            return ResponseEntity.ok().body(controller.save(round));
        }catch (GameIsOverException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Round>> list(){
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Round> obterId(@PathVariable int id){
        return ResponseEntity.ok().body(repository.findById((long) id).get());
    }

}
