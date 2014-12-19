package ch.bfh.shooter.GameState;

import java.awt.*;

/**
 * Created by Jan on 28.10.2014.
 */
public abstract class State {

    protected GameStateManager gsm;

    public abstract void init();
    public abstract void update();
    public abstract void draw(Graphics2D g);
    public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);
    public abstract void exit();

}
