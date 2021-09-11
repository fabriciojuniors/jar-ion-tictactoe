package com.ion.tictactoe.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusRound {

    AO("Aguardando oponente"),
    EA("Em andamento"),
    FI("Finalizada");

    private String descricao;

    StatusRound(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
