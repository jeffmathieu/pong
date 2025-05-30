package com.java.pong.model;

import com.java.pong.ui.GameWindow;

import java.awt.*;

public class Paddle {

    private final int xCoord;
    private int yCoord;

    private final int width = 20;
    private final int height = 80;

    private int dy = 0;
    private final int speed = 5;

    public Paddle(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public int getDy() {
        return dy;
    }

    public int getSpeed() {
        return speed;
    }

    public void move() {
        yCoord += dy;
        if (yCoord < 0) yCoord = 0;
        if (yCoord + height > GameWindow.HEIGHT) yCoord = GameWindow.HEIGHT - height;
    }

    public void draw(Graphics g) {
        g.fillRect(xCoord, yCoord, width, height);
    }

    public void setDirection(int dy) {
        this.dy = dy;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
