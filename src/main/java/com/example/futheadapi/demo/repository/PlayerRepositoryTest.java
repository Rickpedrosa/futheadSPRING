package com.example.futheadapi.demo.repository;

import com.example.futheadapi.demo.model.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerRepositoryTest {
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void testPlayerById() {
        /*Test data retrieval*/
        Player userA = playerRepository.findById(158023);
        assertNotNull(userA);
        assertEquals("L. Messi", userA.getPlayer_name());
        System.out.println(userA.toString());
    }

}
