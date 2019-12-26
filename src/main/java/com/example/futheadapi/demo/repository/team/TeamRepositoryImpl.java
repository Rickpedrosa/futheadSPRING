package com.example.futheadapi.demo.repository.team;

import com.example.futheadapi.demo.model.random.RandomTeam;

import java.util.List;

public interface TeamRepositoryImpl {
    List<RandomTeam> getRandomTeams(int random);
}
