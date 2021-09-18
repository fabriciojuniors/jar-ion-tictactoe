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
        Round savedRound = null;
        if(round.getId() == null){
            round.initBoard();
            round.setCodigo();
            round.setNext();

            if(round.getTipoPartida() == TipoPartida.SOLO){
                round.setPlayer2("Bot Math");
            }

        }else{
            savedRound = repository.findById(round.getId()).get();
            if(savedRound.getStatusRound().equals(StatusRound.FI)){
                throw new GameIsOverException();
            }
        }
        Logger.getLogger("NEXT").info("O próximo é: " + round.getNext());
        Logger.getLogger("PLAYER1").info(round.getPlayer1());
        Logger.getLogger("PLAYER2").info(round.getPlayer2());

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
