package com.example.futheadapi.demo;

import com.example.futheadapi.demo.model.player.PlayerWithPos;
import com.example.futheadapi.demo.model.random.RandomTeam;
import com.example.futheadapi.demo.model.random.RandomTeamSQLBridge;
import com.example.futheadapi.demo.model.team.Team;
import com.example.futheadapi.demo.repository.team.TeamRepository;
import com.example.futheadapi.demo.utils.PlayerProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamRepositoryTest {
    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void testGetRandomTeams() {
        int random = 4;
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

       teams.forEach(it -> System.out.println(it.toString()));
    }
}
