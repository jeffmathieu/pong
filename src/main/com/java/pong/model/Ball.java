package com.java.pong.model;

import com.java.pong.ui.GameWindow;

import java.awt.*;
import java.util.Random;

public class Ball {

    private final int initxCoord;
    private final int inityCoord;

    private int xCoord;
    private int yCoord;

    private final int width = 20;

    private int dx;
    private int dy;

    public Ball(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
        this.initxCoord = x;
        this.inityCoord = y;

        this.dx = randomX();
        this.dy = randomY();
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public int move() {
        xCoord += dx;
        yCoord += dy;

        if (yCoord < 0 || yCoord > GameWindow.HEIGHT - 30 - width) {
            setDirection(dy *= -1);
        }

        if (xCoord < 10) {
            return 2;
        }
        if (xCoord > GameWindow.WIDTH - 10) {
            return 1;
        }

        return 0;
    }

    public void reset(int playerWon) {
        if (playerWon == 1) dx = -2;
        else if (playerWon == 2) dx = 2;

        dy = randomY();

        xCoord = initxCoord;
        yCoord = inityCoord;
    }

    public void draw(Graphics g) {
        g.fillRect(xCoord, yCoord, width, width);
    }

    public void setDirection(int dy) {
        this.dy = dy;
    }

    private int randomX() {
        Random rand = new Random();

        int direction = rand.nextInt(3);
        return switch (direction) {
            case 1 -> -2;
            case 2 -> 2;
            default -> rand.nextInt(4);
        };
    }

    private int randomY() {
        Random rand = new Random();
        int baseSpeed = 2;
        return rand.nextInt(5) + baseSpeed;
    }
}
