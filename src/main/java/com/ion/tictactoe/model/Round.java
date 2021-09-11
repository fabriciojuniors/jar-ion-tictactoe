package com.ion.tictactoe.model;

import com.ion.tictactoe.enums.StatusRound;

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

    @JoinColumn(name = "player_1", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Player player1;

    @JoinColumn(name = "player_2", referencedColumnName = "id", nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Player player2;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusRound statusRound;

    @JoinColumn(name = "winner", referencedColumnName = "id", nullable = true)
    private Player winner;

    @Column()
    private String[][] board = new String[3][3];

    public Round(Long id, Player player1, Player player2, StatusRound statusRound, Player winner) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.statusRound = statusRound;
        this.winner = winner;
        this.board = this.initBoard();
    }

    public Round(){}

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

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public StatusRound getStatusRound() {
        return statusRound;
    }

    public void setStatusRound(StatusRound statusRound) {
        this.statusRound = statusRound;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
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

