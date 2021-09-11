package com.ion.tictactoe.enums;

public enum TipoPartida {
    SOLO("Solo"),
    DUO("Duo");

    private String descricao;

    TipoPartida(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
