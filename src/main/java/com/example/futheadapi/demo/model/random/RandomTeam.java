package com.example.futheadapi.demo.model.random;

import com.example.futheadapi.demo.model.player.PlayerWithPos;
import com.example.futheadapi.demo.model.team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomTeam {
    private Team team;
    private List<PlayerWithPos> players = new ArrayList<>();

    public RandomTeam() {
    }

    public RandomTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<PlayerWithPos> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerWithPos> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return team.getClub() + " \n " + players.stream().flatMap(playerWithPos -> Stream.of(playerWithPos.toString()))
                .collect(Collectors.joining("\n"));
    }
}
