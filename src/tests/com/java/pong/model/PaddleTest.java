package com.java.pong.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaddleTest {

    @Test
    void initTest() {
        Paddle paddle = new Paddle(50, 50);
        assertEquals(50, paddle.getxCoord());
        assertEquals(50, paddle.getyCoord());
    }

}