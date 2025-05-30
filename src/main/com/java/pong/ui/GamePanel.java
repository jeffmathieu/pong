package com.java.pong.ui;

import com.java.pong.model.Ball;
import com.java.pong.model.Paddle;
import com.java.pong.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private final Player player1;
    private final Player player2;

    private final Paddle leftPaddle;
    private final Paddle rightPaddle;
    private final Ball ball;
    private final Timer timer;

    private boolean playerWon;

    public GamePanel() {
        setBackground(Color.pink);
        setFocusable(true);
        addKeyListener(this);

        this.player1 = new Player();
        this.player2 = new Player();

        this.leftPaddle = new Paddle(50, GameWindow.HEIGHT/2-80);
        this.rightPaddle = new Paddle(GameWindow.WIDTH - 50, GameWindow.HEIGHT/2-80);
        this.ball = new Ball(GameWindow.WIDTH/2, GameWindow.HEIGHT/2);

        this.timer = new Timer(1000/60, this);

        this.playerWon = false;
    }

    public void startGame() {
        timer.start();
    }
    public void pauseGame() {
        timer.stop();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);

        String scoreText = player1.getScore() + " : " + player2.getScore();
        Font font = new Font("Ariel" , Font.BOLD, 100);
        g.setFont(font);
        int textWidth = g.getFontMetrics().stringWidth(scoreText);
        g.drawString(scoreText, (getWidth() - textWidth) / 2, GameWindow.HEIGHT / 5);

        leftPaddle.draw(g);
        rightPaddle.draw(g);
        ball.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        leftPaddle.move();
        rightPaddle.move();
        ball.move();


        if (ball.getyCoord() + ball.getWidth() >= leftPaddle.getyCoord() &&
                ball.getyCoord() <= leftPaddle.getyCoord() + leftPaddle.getHeight() &&
                ball.getxCoord() <= leftPaddle.getxCoord() + leftPaddle.getWidth() &&
                ball.getxCoord() > leftPaddle.getxCoord() + (leftPaddle.getWidth() / 2)) {
            ball.setDirectionX(Math.abs(ball.getDx()));
        }

        if (ball.getxCoord() + ball.getWidth() >= rightPaddle.getxCoord() &&
                ball.getyCoord() + ball.getWidth() >= rightPaddle.getyCoord() &&
                ball.getyCoord() <= rightPaddle.getyCoord() + rightPaddle.getHeight() &&
                ball.getxCoord() < rightPaddle.getxCoord() + (rightPaddle.getWidth() / 2)){
            ball.setDirectionX(-Math.abs(ball.getDx()));
        }

        if (ball.getyCoord() < 0 || ball.getyCoord() > GameWindow.HEIGHT - 30 - ball.getWidth()) {
            ball.setDirectionY(ball.getDy() * -1);
        }

        if (ball.getxCoord() < ball.getWidth()) {
            playerWon = player2.addPoint();
            ball.reset();
        }
        if (ball.getxCoord() > GameWindow.WIDTH - ball.getWidth()) {
            playerWon = player1.addPoint();
            ball.reset();
        }

        if (playerWon) {
            pauseGame();
        }


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
            case KeyEvent.VK_R -> {
                if (playerWon) {
                    player1.resetScore();
                    player2.resetScore();
                    //ball.reset();
                    playerWon = false;
                    timer.restart();
                }
            }
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
