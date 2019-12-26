package com.example.futheadapi.demo.queries;

public class TeamQueries {
    public static final String BY_RANDOM = "SELECT t.*, p.*, pos.pos AS player_pos " +
            "FROM (SELECT * FROM teams WHERE quality BETWEEN 3 AND 4 ORDER BY RAND() LIMIT :random) t " +
            "INNER JOIN players p ON p.player_club = t.club " +
            "INNER JOIN playerpositions pos ON p.id = pos.player_id " +
            "ORDER BY t.club, p.player_potential DESC, p.player_name";
}
