package com.example.futheadapi.demo.utils;

import com.example.futheadapi.demo.model.player.PlayerWithPos;
import com.example.futheadapi.demo.model.player.PlayerWithPosSQLBridge;
import com.example.futheadapi.demo.model.random.RandomTeamSQLBridge;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PlayerProvider<T> {
    private final Class<T> typeParameterClass;
    private final List<T> source;
    private List<PlayerWithPos> players;
    private Set<PlayerWithPos> unique_players;
    private List<PlayerWithPosSQLBridge> modifiedSourcePlayer = new ArrayList<>();
    private List<RandomTeamSQLBridge> modifiedSourceRandom = new ArrayList<>();

    public PlayerProvider(Class<T> typeParameterClass, List<T> source) {
        this.typeParameterClass = typeParameterClass;
        this.source = source;
        this.unique_players = new LinkedHashSet<>();
        doCastToSource();
    }

    public List<PlayerWithPos> getPlayers() {
        players = new ArrayList<>(getNonLipidedPlayers());
        if (isValidClass(PlayerWithPosSQLBridge.class.getSimpleName())) {
            modifiedSourcePlayer.forEach(this::addPlayerPositions);
        } else if (isValidClass(RandomTeamSQLBridge.class.getSimpleName())) {
            modifiedSourceRandom.forEach(this::addPlayerPositions);
        }
        return players;
    }

    private Set<PlayerWithPos> getNonLipidedPlayers() {
        if (isValidClass(PlayerWithPosSQLBridge.class.getSimpleName())) {
            modifiedSourcePlayer.forEach(this::buildPlayer);
        } else if (isValidClass(RandomTeamSQLBridge.class.getSimpleName())) {
            modifiedSourceRandom.forEach(this::buildPlayer);
        }
        return unique_players;
    }

    private void addPlayerToSet(int id, String player_name, String player_photo, String player_nationality,
                                int player_potential, String player_club, int player_price) {
        unique_players.add(new PlayerWithPos(
                id,
                player_name,
                player_photo,
                player_nationality,
                player_potential,
                player_club,
                player_price
        ));
    }

    private boolean isValidClass(String className) {
        return typeParameterClass.getSimpleName().equals(className);
    }

    @SuppressWarnings("unchecked")
    private void doCastToSource() {
        if (isValidClass(PlayerWithPosSQLBridge.class.getSimpleName())) {
            modifiedSourcePlayer = (List<PlayerWithPosSQLBridge>) source;
        } else if (isValidClass(RandomTeamSQLBridge.class.getSimpleName())) {
            modifiedSourceRandom = (List<RandomTeamSQLBridge>) source;
        }
    }


    private void addPlayerPositions(PlayerWithPosSQLBridge it) {
        players.forEach(p -> {
            if (it.getId() == p.getId()) {
                p.getPlayer_pos().add(it.getPlayer_pos());
            }
        });
    }

    private void addPlayerPositions(RandomTeamSQLBridge it) {
        players.forEach(p -> {
            if (it.getId() == p.getId()) {
                p.getPlayer_pos().add(it.getPlayer_pos());
            }
        });
    }

    private void buildPlayer(PlayerWithPosSQLBridge it) {
        addPlayerToSet(
                it.getId(),
                it.getPlayer_name(),
                it.getPlayer_photo(),
                it.getPlayer_nationality(),
                it.getPlayer_potential(),
                it.getPlayer_club(),
                it.getPlayer_price());
    }

    private void buildPlayer(RandomTeamSQLBridge it) {
        addPlayerToSet(
                it.getId(),
                it.getPlayer_name(),
                it.getPlayer_photo(),
                it.getPlayer_nationality(),
                it.getPlayer_potential(),
                it.getPlayer_club(),
                it.getPlayer_price());
    }
}
