package com.ion.tictactoe.repository;

import com.ion.tictactoe.model.Round;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoundRepository extends JpaRepository<Round, Long> {
}
