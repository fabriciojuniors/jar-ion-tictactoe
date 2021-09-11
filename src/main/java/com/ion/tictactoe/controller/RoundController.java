package com.ion.tictactoe.controller;

import com.ion.tictactoe.model.Round;
import com.ion.tictactoe.model.dto.RoundDto;
import com.ion.tictactoe.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundController {

    @Autowired
    RoundRepository repository;

    public RoundDto save(RoundDto round){
        return round;
    }

}
