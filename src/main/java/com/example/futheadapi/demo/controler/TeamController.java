package com.example.futheadapi.demo.controler;

import com.example.futheadapi.demo.model.random.RandomTeam;
import com.example.futheadapi.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@RestController
@RequestMapping(value = "/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    @ResponseBody
    public List<RandomTeam> getRandomTeams(@RequestParam("random") int random) {
        random = random > 10 ? 4 : random;
        return teamService.getRandomTeams(random);
    }
}
