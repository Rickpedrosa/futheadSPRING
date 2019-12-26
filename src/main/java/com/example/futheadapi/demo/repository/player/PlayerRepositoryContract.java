package com.example.futheadapi.demo.repository.player;

import com.example.futheadapi.demo.model.player.Player;
import com.example.futheadapi.demo.model.player.PlayerWithPos;

import java.util.List;

public interface PlayerRepositoryContract {
    Player findById(int id);

    List<PlayerWithPos> findPlayerWithPositions(String club);
}
