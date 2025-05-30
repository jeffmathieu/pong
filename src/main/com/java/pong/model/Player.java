package com.java.pong.model;

public class Player {

    private int score;

    public Player() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public boolean addPoint() {
        this.score += 1;

        return score >= 10;
    }

    public void resetScore() {
        score = 0;
    }
}
