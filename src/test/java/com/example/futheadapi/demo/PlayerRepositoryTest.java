package com.example.futheadapi.demo;

import com.example.futheadapi.demo.model.player.PlayerWithPos;
import com.example.futheadapi.demo.model.player.PlayerWithPosSQLBridge;
import com.example.futheadapi.demo.repository.player.PlayerRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerRepositoryTest {
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void testPlayerById() {
        /*Test data retrieval*/
        List<PlayerWithPosSQLBridge> source = playerRepository.findPlayerWithPositions("FC Barcelona");
        assertNotNull(source);
        Set<PlayerWithPos> players_names = new LinkedHashSet<>();
//        source.forEach(it -> players_names.add(new PlayerWithPos(
//                it.getId(),
//                it.getPlayer_name(),
//                it.getPlayer_photo(),
//                it.getPlayer_nationality(),
//                it.getPlayer_potential(),
//                it.getPlayer_club(),
//                it.getPlayer_price(),
//                new ArrayList<>()
//        )));
        List<PlayerWithPos> players = new ArrayList<>(players_names);
        source.forEach(it -> players.forEach(p -> {
            if (it.getId() == p.getId()) {
                p.getPlayer_pos().add(it.getPlayer_pos());
            }
        }));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        System.out.println(gson.toJson(players_names));
        players.forEach(it -> System.out.println(it.toString()));
    }

}
