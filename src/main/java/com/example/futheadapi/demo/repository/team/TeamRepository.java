package com.example.futheadapi.demo.repository.team;

import com.example.futheadapi.demo.model.random.RandomTeamSQLBridge;
import com.example.futheadapi.demo.model.team.Team;
import com.example.futheadapi.demo.queries.TeamQueries;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, String> {
    @Query(value = TeamQueries.BY_RANDOM, nativeQuery = true)
    List<RandomTeamSQLBridge> getRandomTeams(int random);
}
