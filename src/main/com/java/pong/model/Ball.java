package com.java.pong.model;

import com.java.pong.ui.GameWindow;

import java.awt.*;

public class Ball {

    private int xCoord;
    private int yCoord;

    private final int width = 10;
    private final int height = 10;

    private int dx = 0;
    private int dy = 0;
    private final int speed = 5;

    public Ball(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void move() {
        xCoord += dx;
        yCoord += dy;

        if (yCoord < 0) {
            //TODO bounce
        }

        if (yCoord > GameWindow.HEIGHT) {
            //TODO bounce
        }

        if (xCoord < 10) {
            //TODO: point
        }
        if (xCoord > GameWindow.WIDTH - 10) {
            //TODO: point
        }

    }

    public void draw(Graphics g) {
        g.fillRect(xCoord, yCoord, width, height);
    }

    public void setDirection(int dy) {
        this.dy = dy;
    }
}
