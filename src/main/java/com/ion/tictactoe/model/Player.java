package com.ion.tictactoe.model;

import com.ion.tictactoe.services.validation.PlayerSave;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "player")
@PlayerSave
public class Player implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "wins", nullable = false)
    private int wins;

    public Player(Long id, String nickname, int wins) {
        this.id = id;
        this.nickname = nickname;
        this.wins = wins;
    }

    public Player(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
        this.wins = 0;
    }

    public Player(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return this.nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return id == player.id;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
