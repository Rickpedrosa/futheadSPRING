package com.example.futheadapi.demo.repository.player;

import com.example.futheadapi.demo.model.player.Player;
import com.example.futheadapi.demo.model.player.PlayerWithPosSQLBridge;
import com.example.futheadapi.demo.queries.PlayerQueries;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    Player findById(int id);

    @Query(value = PlayerQueries.FROM_CLUB
            , nativeQuery = true)
    List<PlayerWithPosSQLBridge> findPlayerWithPositions(String club);
}
