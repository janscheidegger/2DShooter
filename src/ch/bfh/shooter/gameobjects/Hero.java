package ch.bfh.shooter.gameobjects;

import ch.bfh.shooter.helper.ShooterConstants;

import java.awt.*;

/**
 * Created by jan on 31/10/14.
 */
public class Hero extends MovableGameObject{
    public Hero() {

        this.width = ShooterConstants.HERO_WIDTH;
        this.height = ShooterConstants.HERO_HEIGHT;
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics2D g) {

    }
}
