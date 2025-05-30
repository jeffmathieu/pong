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

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void move() {
        xCoord += dx;
        yCoord += dy;
    }

    public void reset() {
        dx = dx * -1;

        dy = randomY();

        xCoord = initxCoord;
        yCoord = inityCoord;
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
            case 1 -> -2;
            case 2 -> 2;
            default -> rand.nextInt(4);
        };
    }

    private int randomY() {
        Random rand = new Random();
        int baseSpeed = 2;
        return rand.nextInt(3) + baseSpeed;
    }

    public int getWidth() {
        return width;
    }
}
