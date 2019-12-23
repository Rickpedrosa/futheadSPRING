package com.example.futheadapi.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "players")
public class Player {
    @Id private int id;
    private String player_name;
    private String player_photo;
    private String player_nationality;
    private int player_potential;
    private String player_club;
    private int player_price;

    public Player(){}

    public Player(int id, String player_name, String player_photo,
                  String player_nationality,
                  int player_potential, String player_club, int player_price) {
        this.id = id;
        this.player_name = player_name;
        this.player_photo = player_photo;
        this.player_nationality = player_nationality;
        this.player_potential = player_potential;
        this.player_club = player_club;
        this.player_price = player_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_photo() {
        return player_photo;
    }

    public void setPlayer_photo(String player_photo) {
        this.player_photo = player_photo;
    }

    public String getPlayer_nationality() {
        return player_nationality;
    }

    public void setPlayer_nationality(String player_nationality) {
        this.player_nationality = player_nationality;
    }

    public int getPlayer_potential() {
        return player_potential;
    }

    public void setPlayer_potential(int player_potential) {
        this.player_potential = player_potential;
    }

    public String getPlayer_club() {
        return player_club;
    }

    public void setPlayer_club(String player_club) {
        this.player_club = player_club;
    }

    public int getPlayer_price() {
        return player_price;
    }

    public void setPlayer_price(int player_price) {
        this.player_price = player_price;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", player_name='" + player_name + '\'' +
                ", player_photo='" + player_photo + '\'' +
                ", player_nationality='" + player_nationality + '\'' +
                ", player_potential=" + player_potential +
                ", player_club='" + player_club + '\'' +
                ", player_price=" + player_price +
                '}';
    }
}
