package com.example.futheadapi.demo.queries;

public class PlayerQueries {
    public static final String FROM_CLUB = "SELECT p.*, pos.pos AS player_pos " +
            "FROM players p INNER JOIN playerpositions pos ON pos.player_id = p.id " +
            "INNER JOIN teams t ON t.club = p.player_club " +
            "WHERE p.player_club LIKE :club " +
            "ORDER BY p.player_potential DESC";
}
