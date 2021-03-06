package ch.bfh.shooter.gameobjects.weapon;

import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.assets.Sound;
import ch.bfh.shooter.gameobjects.MovableGameObject;
import ch.bfh.shooter.helper.ShooterConstants;

import java.util.ArrayList;

/**
 * Created by jan on 07/11/14.
 */
public class Rifle extends  Weapon {

    public Rifle(MovableGameObject owner) {
        super(owner);
        this.capacity = ShooterConstants.RIFLE_CAPACITY;
        this.munition = ShooterConstants.INITIAL_RIFLE_MUNITION;
        this.damage = ShooterConstants.PISTOL_DAMAGE;
        this.munitionSprite = AssetManager.shotSprite;
        this.weaponImage = AssetManager.rifleImage;

        this.munitionInGun = this.capacity;
    }


    private Shot shoot(int x, int y, int rotation) {
        if(munitionInGun > 0) {
            munitionInGun--;
            Sound.play(Sound.shoot);
            return new Shot(x, y, rotation, damage , munitionSprite, owner);
        }
        Sound.play(Sound.emptygun);
        return null;
    }

    @Override
    public void attack(int x, int y, ArrayList<Shot> shots, int rotation, MovableGameObject owner) {
        if(cooldown == 0) {
            Shot shot = shoot(x, y, rotation);
            if (shot != null) {
                shots.add(shot);
            }
            this.cooldown = ShooterConstants.RIFLE_COOLDOWN;
        }
    }
}
