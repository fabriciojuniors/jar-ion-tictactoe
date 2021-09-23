package com.ion.tictactoe.repository;

import com.ion.tictactoe.model.Round;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoundRepository extends PagingAndSortingRepository<Round, Long> {
}
