package com.java.pong.ui;

import com.java.pong.model.Ball;
import com.java.pong.model.Paddle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private final Paddle leftPaddle;
    private final Paddle rightPaddle;
    private final Ball ball;
    private final Timer timer;


    public GamePanel() {
        setBackground(Color.pink);
        setFocusable(true);
        addKeyListener(this);

        this.leftPaddle = new Paddle(50, GameWindow.HEIGHT/2-80);
        this.rightPaddle = new Paddle(GameWindow.WIDTH - 50, GameWindow.HEIGHT/2-80);
        this.ball = new Ball(GameWindow.WIDTH/2, GameWindow.HEIGHT/2);

        this.timer = new Timer(1000/60, this);


    }

    public void startGame() {
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        leftPaddle.draw(g);
        rightPaddle.draw(g);
        ball.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        leftPaddle.move();
        rightPaddle.move();

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Z -> leftPaddle.setDirection(-leftPaddle.getSpeed());
            case KeyEvent.VK_S -> leftPaddle.setDirection(leftPaddle.getSpeed());
            case KeyEvent.VK_UP -> rightPaddle.setDirection(-rightPaddle.getSpeed());
            case KeyEvent.VK_DOWN -> rightPaddle.setDirection(rightPaddle.getSpeed());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Z, KeyEvent.VK_S -> leftPaddle.setDirection(0);
            case KeyEvent.VK_UP, KeyEvent.VK_DOWN -> rightPaddle.setDirection(0);
        }
    }
}
