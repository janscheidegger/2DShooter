package ch.bfh.shooter;

import ch.bfh.shooter.GameState.GameStateManager;
import ch.bfh.shooter.helper.ShooterConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Created by Jan on 28.10.2014.
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {
    private Thread thread;
    private boolean running;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;

    private BufferedImage image;
    private Graphics2D g;

    private GameStateManager gsm;

    public GamePanel() {
        super();
        setPreferredSize(new Dimension(ShooterConstants.WIDTH ,
                ShooterConstants.HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    private void init() {
        image = new BufferedImage(ShooterConstants.WIDTH, ShooterConstants.HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        running = true;

        gsm = new GameStateManager();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        init();

        long start;
        long elapsed;
        long wait;

        while (running) {

            start = System.nanoTime();

            update();
            draw();
            drawToScreen();

            elapsed = System.nanoTime() - start;
            wait = targetTime - (elapsed / 1000000);
            if(wait < 0) wait = 0;
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    private void update() {
        gsm.update();
    }

    private void draw() {
        gsm.draw(g);
    }

    private void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, ShooterConstants.WIDTH,
                ShooterConstants.HEIGHT, null);
        g2.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        gsm.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gsm.keyReleased(e.getKeyCode());
    }


}
