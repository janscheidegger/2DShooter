package ch.bfh.shooter;

import ch.bfh.shooter.helper.ShooterConstants;

import javax.swing.*;

/**
 * Created by Jan on 28.10.2014.
 */
public class Game {
    public static void main(String[] args) {
        JFrame window = new JFrame(ShooterConstants.TITLE);
        window.setContentPane(new GamePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }
}
