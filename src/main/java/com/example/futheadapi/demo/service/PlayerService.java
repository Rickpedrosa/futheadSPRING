package com.example.futheadapi.demo.service;

import com.example.futheadapi.demo.model.player.Player;
import com.example.futheadapi.demo.model.player.PlayerWithPos;
import com.example.futheadapi.demo.model.player.PlayerWithPosSQLBridge;
import com.example.futheadapi.demo.repository.player.PlayerRepository;
import com.example.futheadapi.demo.repository.player.PlayerRepositoryImpl;
import com.example.futheadapi.demo.utils.PlayerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class PlayerService implements PlayerRepositoryImpl {
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Player findById(int id) {
        return playerRepository.findById(id);
    }

    @Override
    public List<PlayerWithPos> findPlayerWithPositions(String club) {
        return new PlayerProvider<>(PlayerWithPosSQLBridge.class,
                playerRepository.findPlayerWithPositions(club))
                .getPlayers();
    }
}

