package com.example.futheadapi.demo.repository;

import com.example.futheadapi.demo.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    Player findById(int id);
}
