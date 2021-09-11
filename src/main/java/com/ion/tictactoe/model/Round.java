package com.ion.tictactoe.model;

import com.ion.tictactoe.enums.StatusRound;
import com.ion.tictactoe.enums.TipoPartida;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

@Entity
@Table(name = "round")
public class Round implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "player1", nullable = false)
    private String player1;

    @Column(name = "player2", nullable = true)
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

    @Column
    private int codigo;

    public Round(Long id, String player1, String player2, StatusRound statusRound, String winner, TipoPartida tipoPartida) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.statusRound = statusRound;
        this.winner = winner;
        this.tipoPartida = tipoPartida;
        this.setCodigo();
    }

    public Round(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        int random = new Random().nextInt(99999);
        this.codigo = random;
    }

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

    public boolean setWinner() {
        for(int i = 0; i < 3; i++){
            if(!this.board[i][0].equals("-") &&this.board[i][0].equals(this.board[i][1]) && this.board[i][0].equals(this.board[i][2])){
                this.winner = this.board[i][0].equals("x") ? this.player1 : this.player2;
                return true;
            }
        }

        if(this.board[0][0].equals(this.board[1][1]) && this.board[0][0].equals(this.board[2][2])){
            if(!this.board[0][0].equals("-")){
                this.winner = this.board[0][0].equals("x") ? this.player1 : this.player2;
                return true;
            }
        }

        if(this.board[0][2].equals(this.board[1][1]) && this.board[0][2].equals(this.board[2][0])){
            if(!this.board[0][2].equals("-")){
                this.winner = this.board[0][0].equals("x") ? this.player1 : this.player2;
                return true;
            }
        }

        if(this.board[0][0].equals(this.board[1][0]) && this.board[0][0].equals(this.board[2][0])){
            if(!this.board[0][0].equals("-")){
                this.winner = this.board[0][0].equals("x") ? this.player1 : this.player2;
                return true;
            }
        }

        if(this.board[0][1].equals(this.board[1][1]) && this.board[0][1].equals(this.board[2][1])){
            if(!this.board[0][1].equals("-")){
                this.winner = this.board[0][1].equals("x") ? this.player1 : this.player2;
                return true;
            }
        }

        if(this.board[0][2].equals(this.board[1][2]) && this.board[0][2].equals(this.board[2][2])){
            if(!this.board[0][2].equals("-")){
                this.winner = this.board[0][2].equals("x") ? this.player1 : this.player2;
                return true;
            }
        }

        return false;
    }

    public void botPlay(){
        Integer linha = new Random().nextInt(3);
        Integer coluna = new Random().nextInt(3);
        Logger.getLogger("BotPlay").info("Linha: " + linha + "\tColuna: " + coluna);

        if(this.board[linha][coluna].equals("-")){
            this.board[linha][coluna] = "o";
            return;
        }
        this.botPlay();
    }

    public void initBoard(){
        String[][] board = new String[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = "-";
            }
        }
        this.board = board;
    }

    public boolean isGameOver(){
        if(this.setWinner()){
            return true;
        }

        int emBrancos = 0;

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j].equals("-")) {
                    emBrancos++;
                }
            }
        }

        return emBrancos == 0;
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

