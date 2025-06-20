package com.java.pong.ui;

import javax.swing.*;

public class GameWindow extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public GameWindow() {
        setTitle("Pong");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        GamePanel panel = new GamePanel();
        add(panel);
        setVisible(true);

        panel.startGame();
    }

}
