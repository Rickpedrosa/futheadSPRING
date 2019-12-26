package com.example.futheadapi.demo.model.player;

import java.util.List;

public class PlayerWithPos extends Player {
    private List<String> player_pos;

    public PlayerWithPos(int id, String player_name, String player_photo, String player_nationality, int player_potential, String player_club, int player_price, List<String> player_pos) {
        super(id, player_name, player_photo, player_nationality, player_potential, player_club, player_price);
        this.player_pos = player_pos;
    }

    public List<String> getPlayer_pos() {
        return player_pos;
    }

    @Override
    public String toString() {
        return super.toString() + player_pos.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
