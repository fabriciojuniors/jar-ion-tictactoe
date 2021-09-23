package com.ion.tictactoe.resource;

import com.ion.tictactoe.controller.RoundController;
import com.ion.tictactoe.exceptions.GameIsOverException;
import com.ion.tictactoe.model.Round;
import com.ion.tictactoe.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public ResponseEntity<Page<Round>> list(@PathParam("page") int page, @PathParam("size") int size){
        Pageable pagina = PageRequest.of(page, size);
        return ResponseEntity.ok().body(repository.findAll(pagina));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Round> obterId(@PathVariable int id){
        return ResponseEntity.ok().body(repository.findById((long) id).get());
    }


}
