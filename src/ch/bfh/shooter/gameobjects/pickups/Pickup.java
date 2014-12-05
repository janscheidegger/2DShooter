package ch.bfh.shooter.gameobjects.pickups;

import ch.bfh.shooter.gameobjects.GameObject;
import ch.bfh.shooter.gameobjects.Hero;

import java.awt.*;

/**
 * Created by jan on 05/12/14.
 */
public abstract class Pickup extends GameObject {
    @Override
    public void update() {

    }

    public abstract void getPower(Hero hero);

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(sprite, (int)x, (int)y, null, null);
    }
}
