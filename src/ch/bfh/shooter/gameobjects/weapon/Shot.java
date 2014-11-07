package ch.bfh.shooter.gameobjects.weapon;

import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.gameobjects.MovableGameObject;
import ch.bfh.shooter.helper.ShooterConstants;

import java.awt.image.BufferedImage;

/**
 * Created by Jan on 02.11.2014.
 */
public class Shot extends MovableGameObject {

    private int damage;

    public Shot(int x, int y, int rotation, int damage, BufferedImage sprite) {
        this.damage = damage;
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.sprite = sprite;
        this.width = ShooterConstants.SHOT_WIDTH;
        this.height = ShooterConstants.SHOT_HEIGHT;

    }

    @Override
    public void update() {
        if(rotation == 90) {
            this.x++;
        }if(rotation == 180) {
            this.y++;
        }if(rotation == 270) {
            this.x--;
        }if(rotation == 0) {
            this.y--;
        }

    }

    public int getDamage() {
        return damage;
    }
}
