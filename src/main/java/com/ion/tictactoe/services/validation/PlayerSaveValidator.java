package com.ion.tictactoe.services.validation;

import com.ion.tictactoe.exceptions.FieldMessages;
import com.ion.tictactoe.model.Player;
import com.ion.tictactoe.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PlayerSaveValidator implements ConstraintValidator<PlayerSave, Player> {

    @Autowired
    PlayerRepository repository;

    @Override
    public void initialize(PlayerSave constraintAnnotation) {
    }

    @Override
    public boolean isValid(Player player, ConstraintValidatorContext context) {
        Logger.getLogger("PlayerValidator").info("Caiu no validation");
        List<FieldMessages> erros = new ArrayList<>();

        if(player.getId() > 0){
            List<Player> players = repository.findAllByNickname(player.getNickname());
            if(players.size() > 0){
                erros.add(new FieldMessages("nickname", "O nickname informado já está em uso"));
            }
        }

        if(player.getWins() < 0){
            erros.add(new FieldMessages("wins", "Número de vitórias deve ser maior ou igual a zero."));
        }

        for(FieldMessages e : erros){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
        }

        return erros.isEmpty();

    }
}
