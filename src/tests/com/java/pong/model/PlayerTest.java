package com.java.pong.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void initTest() {
        Player player = new Player();
        assertEquals(0, player.getScore());
    }

    @Test
    void getPointsTest() {
        Player player = new Player();
        player.addPoint();
        assertEquals(1, player.getScore());
    }

}