package com.ion.tictactoe.controller;

import com.ion.tictactoe.enums.StatusRound;
import com.ion.tictactoe.enums.TipoPartida;
import com.ion.tictactoe.exceptions.GameIsOverException;
import com.ion.tictactoe.model.Round;
import com.ion.tictactoe.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class RoundController {

    @Autowired
    RoundRepository repository;

    public Round save(Round round) throws GameIsOverException {
        if(round.getId() == null){
            round.initBoard();
            round.setCodigo();

            if(round.getTipoPartida() == TipoPartida.SOLO){
                round.setPlayer2("Bot Math");
            }

        }else{
            Round savedRound = repository.getById(round.getId());
            if(savedRound.getStatusRound().equals(StatusRound.FI)){
                throw new GameIsOverException();
            }
        }

        if (!round.isGameOver() && round.getTipoPartida() == TipoPartida.SOLO) {
            round.botPlay();
        }

        if(round.isGameOver()){
            Logger.getLogger("Winner").info("O vencedor foi: " + round.getWinner());
            round.setStatusRound(StatusRound.FI);
        }

        return repository.save(round);
    }

}
