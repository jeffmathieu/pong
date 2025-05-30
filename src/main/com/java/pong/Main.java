package com.java.pong;

import com.java.pong.ui.GameWindow;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(GameWindow::new);
    }

}
