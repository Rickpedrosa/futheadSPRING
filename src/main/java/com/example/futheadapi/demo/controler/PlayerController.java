package com.example.futheadapi.demo.controler;

import com.example.futheadapi.demo.model.player.Player;
import com.example.futheadapi.demo.model.player.PlayerWithPos;
import com.example.futheadapi.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@RestController
@RequestMapping(value = "/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public Player getPlayerById(@PathVariable("id") int id) {
        return playerService.findById(id);
    }

    @GetMapping
    @ResponseBody
    public List<PlayerWithPos> getPlayersFromClub(@RequestParam("club") String club) {
        return playerService.findPlayerWithPositions(club);
    }
}
