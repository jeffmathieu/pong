package com.java.pong.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaddleTest {

    @Test
    void initTest() {
        Paddle paddle = new Paddle(50, 50);
        assertEquals(50, paddle.getxCoord());
        assertEquals(50, paddle.getyCoord());
        assertEquals(0, paddle.getSpeed());
    }

    @Test
    void changeDirectionAndMoveTest() {
        Paddle paddle = new Paddle(50, 50);
        paddle.setDirection(5);
        paddle.move();
        assertEquals(50, paddle.getxCoord());
        assertEquals(55, paddle.getyCoord());
        assertEquals(5, paddle.getDy());
    }

    @Test
    void exceptionsInMovingTest() {
        Paddle paddle = new Paddle(50, 50);

        paddle.setDirection(-60);
        paddle.move();

        assertEquals(50, paddle.getxCoord());
        assertEquals(0, paddle.getyCoord());
        assertEquals(-60, paddle.getDy());

        paddle.setDirection(1000);
        paddle.move();

        assertEquals(50, paddle.getxCoord());
        assertEquals(520, paddle.getyCoord());
    }

}