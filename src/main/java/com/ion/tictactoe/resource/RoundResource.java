package com.ion.tictactoe.resource;

import com.ion.tictactoe.model.Round;
import com.ion.tictactoe.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "round")
public class RoundResource {

    @Autowired
    RoundRepository repository;

    @PostMapping
    public ResponseEntity<Round> save(@RequestBody Round round){
        Logger.getLogger("TESTE").info(round.toString());
        return ResponseEntity.ok().body(repository.save(round));
    }

    @GetMapping
    public ResponseEntity<List<Round>> list(){
        return ResponseEntity.ok().body(repository.findAll());
    }

}
