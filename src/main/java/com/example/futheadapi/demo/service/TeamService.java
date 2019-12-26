package com.example.futheadapi.demo.service;

import com.example.futheadapi.demo.model.player.PlayerWithPos;
import com.example.futheadapi.demo.model.random.RandomTeam;
import com.example.futheadapi.demo.model.random.RandomTeamSQLBridge;
import com.example.futheadapi.demo.model.team.Team;
import com.example.futheadapi.demo.repository.team.TeamRepository;
import com.example.futheadapi.demo.repository.team.TeamRepositoryImpl;
import com.example.futheadapi.demo.utils.PlayerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class TeamService implements TeamRepositoryImpl {
    @Autowired
    TeamRepository teamRepository;

    @Override
    public List<RandomTeam> getRandomTeams(int random) {
        List<RandomTeamSQLBridge> source = teamRepository.getRandomTeams(random);
        Set<Team> clubs = new LinkedHashSet<>();
        List<RandomTeam> teams = new ArrayList<>();
        source.forEach(it -> clubs.add(new Team(
                it.getClub(),
                it.getClub_logo(),
                it.getAverage(),
                it.getAverage_team(),
                it.getQuality()
        )));
        List<PlayerWithPos> players = new PlayerProvider<>(
                RandomTeamSQLBridge.class,
                source)
                .getPlayers();

        clubs.forEach(club -> {
            RandomTeam current = new RandomTeam(club);
            teams.add(current);
            players.forEach(player -> {
                if (club.getClub().equals(player.getPlayer_club())) {
                    current.getPlayers().add(player);
                }
            });
        });
        return teams;
    }
}
