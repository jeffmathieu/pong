package com.java.pong.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    void initTest() {
        Ball ball = new Ball(100, 100);
        assertEquals(100, ball.getxCoord());
        assertEquals(100, ball.getyCoord());
    }

}