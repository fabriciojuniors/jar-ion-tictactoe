package com.ion.tictactoe.model;

import com.ion.tictactoe.enums.StatusRound;
import com.ion.tictactoe.enums.TipoPartida;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "round")
public class Round implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "player1", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private String player1;

    @Column(name = "player2", nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private String player2;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusRound statusRound;

    @Column(name = "winner", nullable = true)
    private String winner;

    @Column()
    private String[][] board = new String[3][3];

    @Column
    @Enumerated(EnumType.STRING)
    private TipoPartida tipoPartida;

    public Round(Long id, String player1, String player2, StatusRound statusRound, String winner, TipoPartida tipoPartida) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.statusRound = statusRound;
        this.winner = winner;
        this.board = this.initBoard();
        this.tipoPartida = tipoPartida;
    }

    public Round(){}

    public TipoPartida getTipoPartida() {
        return tipoPartida;
    }

    public void setTipoPartida(TipoPartida tipoPartida) {
        this.tipoPartida = tipoPartida;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public StatusRound getStatusRound() {
        return statusRound;
    }

    public void setStatusRound(StatusRound statusRound) {
        this.statusRound = statusRound;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    private String[][] initBoard(){
        String[][] board = new String[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = "-";
            }
        }
        return board;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Round round = (Round) o;

        return id.equals(round.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Round{" +
                "id=" + id +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", statusRound=" + statusRound +
                ", winner=" + winner +
                ", board=" + Arrays.toString(board) +
                '}';
    }
}

