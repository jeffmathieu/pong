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
    private int speedBoost;

    public Ball(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
        this.initxCoord = x;
        this.inityCoord = y;

        this.dx = randomX();
        this.dy = randomY();
        this.speedBoost = 0;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void move() {
        xCoord += (dx * speedBoost);
        yCoord += dy;
    }

    public void reset() {
        dx = dx * -1;

        dy = randomY();

        xCoord = initxCoord;
        yCoord = inityCoord;

        speedBoost = 1;
    }

    public void draw(Graphics g) {
        g.fillRect(xCoord, yCoord, width, width);
    }

    public void setDirectionY(int dy) {
        this.dy = dy;
    }

    public void setDirectionX(int dx) {
        this.dx = dx;
    }

    private int randomX() {
        Random rand = new Random();

        int direction = rand.nextInt(3);
        return switch (direction) {
            case 1 -> -3;
            case 2 -> 3;
            default -> rand.nextInt(4);
        };
    }

    private int randomY() {
        Random rand = new Random();
        int baseSpeed = 1;
        return rand.nextInt(3) + baseSpeed;
    }

    public int getWidth() {
        return width;
    }

    public void increaseSpeedBoost() {
        speedBoost += 1;
    }
}
