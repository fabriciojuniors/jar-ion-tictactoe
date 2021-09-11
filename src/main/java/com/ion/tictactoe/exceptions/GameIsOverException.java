package com.ion.tictactoe.exceptions;

public class GameIsOverException extends RuntimeException{
    public GameIsOverException(){
        super("A partida desejada já foi finalizada.");
    }
}
