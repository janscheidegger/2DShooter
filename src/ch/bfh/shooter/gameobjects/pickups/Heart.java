package ch.bfh.shooter.gameobjects.pickups;

import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.assets.Sound;
import ch.bfh.shooter.gameobjects.Hero;
import ch.bfh.shooter.helper.ShooterConstants;

/**
 * Created by jan on 05/12/14.
 */
public class Heart extends Pickup {

    private int life;

    public Heart(int x, int y) {
        this.x = x;
        this.y = y;
        this.height = ShooterConstants.PICKUP_HEIGHT;
        this.width = ShooterConstants.PICKUP_WIDTH;
        this.sprite = AssetManager.heartSprite;
        this.life = 50;
    }

    @Override
    public void getPower(Hero hero) {
        Sound.play(Sound.heart);
        hero.setHealth(hero.getHealth()+life);
        if(hero.getHealth()> ShooterConstants.HERO_MAXHEALTH) hero.setHealth(ShooterConstants.HERO_MAXHEALTH);
    }
}
