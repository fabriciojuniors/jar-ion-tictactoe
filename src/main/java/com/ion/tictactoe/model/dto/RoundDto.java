package com.ion.tictactoe.model.dto;

public class RoundDto {

    private Integer id;
    private int player1;
    private Integer player2;
    private String status;
    private Integer winner;

    public RoundDto(Integer id, int player1, Integer player2, String status, Integer winner) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.status = status;
        this.winner = winner;
    }
}
