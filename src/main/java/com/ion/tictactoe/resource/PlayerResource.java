package com.ion.tictactoe.resource;

import com.ion.tictactoe.model.Player;
import com.ion.tictactoe.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "player")
public class PlayerResource {

    @Autowired
    PlayerRepository repository;


    @PostMapping
    public ResponseEntity<Player> save(@Valid @RequestBody Player player){
        Player p = repository.save(player);
        return ResponseEntity.ok().body(p);
    }

    @GetMapping
    public ResponseEntity<List<Player>> list(){
        return ResponseEntity.ok().body(repository.findAll());
    }

}
