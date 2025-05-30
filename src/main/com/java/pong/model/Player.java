package com.java.pong.model;

public class Player {

    private int score;

    public Player() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void addPoint() {
        this.score += 1;
    }
}
