package com.example.futheadapi.demo.service;

import com.example.futheadapi.demo.model.player.Player;
import com.example.futheadapi.demo.model.player.PlayerWithPos;
import com.example.futheadapi.demo.model.player.PlayerWithPosSQLBridge;
import com.example.futheadapi.demo.repository.player.PlayerRepository;
import com.example.futheadapi.demo.repository.player.PlayerRepositoryContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class PlayerService implements PlayerRepositoryContract {
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Player findById(int id) {
        return playerRepository.findById(id);
    }

    @Override
    public List<PlayerWithPos> findPlayerWithPositions(String club) {
        List<PlayerWithPosSQLBridge> source = playerRepository.findPlayerWithPositions(club);
        Set<PlayerWithPos> players_names = new LinkedHashSet<>();
        source.forEach(it -> players_names.add(new PlayerWithPos(
                it.getId(),
                it.getPlayer_name(),
                it.getPlayer_photo(),
                it.getPlayer_nationality(),
                it.getPlayer_potential(),
                it.getPlayer_club(),
                it.getPlayer_price(),
                new ArrayList<>()
        )));
        List<PlayerWithPos> players = new ArrayList<>(players_names);
        source.forEach(it -> players.forEach(p -> {
            if (it.getId() == p.getId()) {
                p.getPlayer_pos().add(it.getPlayer_pos());
            }
        }));
        return players;
    }
}

