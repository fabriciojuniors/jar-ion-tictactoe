package com.ion.tictactoe.repository;

import com.ion.tictactoe.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findAllByNickname(String nickname);
}
