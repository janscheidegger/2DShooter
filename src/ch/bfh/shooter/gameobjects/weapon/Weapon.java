package ch.bfh.shooter.gameobjects.weapon;

import ch.bfh.shooter.gameobjects.MovableGameObject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by jan on 07/11/14.
 */
public abstract class Weapon {

    protected int cooldown;
    protected int munition;
    protected int damage;
    protected BufferedImage weaponImage;
    protected BufferedImage munitionSprite;
    protected MovableGameObject owner;

    public Weapon(MovableGameObject owner) {
        this.owner = owner;
    }

    public abstract void attack(int x, int y, ArrayList<Shot> shots, int rotation, MovableGameObject owner);
    public int getMunition() {
        return munition;
    }


    public BufferedImage getWeaponImage() {
        return weaponImage;
    }

    public int getDamage() {
        return damage;
    }

    public BufferedImage getMunitionSprite() {
        return munitionSprite;
    }

    public void lowerCooldown() {
        if(cooldown > 0) {
            cooldown--;
        }
    }

    public int getCooldown() {
        return cooldown;
    }
}
