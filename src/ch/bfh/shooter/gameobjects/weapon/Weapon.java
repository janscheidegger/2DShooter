package ch.bfh.shooter.gameobjects.weapon;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by jan on 07/11/14.
 */
public abstract class Weapon {

    protected int munition;
    protected int damage;
    protected BufferedImage munitionSprite;

    public abstract void attack(int x, int y, ArrayList<Shot> shots, int rotation);
}
