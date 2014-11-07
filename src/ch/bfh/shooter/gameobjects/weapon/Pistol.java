package ch.bfh.shooter.gameobjects.weapon;

import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.helper.ShooterConstants;

import java.util.ArrayList;

/**
 * Created by jan on 07/11/14.
 */
public class Pistol extends  Weapon {

    public Pistol() {

        this.munition = ShooterConstants.INITIAL_PISTOL_MUNITION;
        this.damage = ShooterConstants.PISTOL_DAMAGE;
        this.munitionSprite = AssetManager.shotSprite;
    }


    private Shot shot(int x, int y, int rotation) {
        if(munition > 0) {
            return new Shot(x, y, rotation, damage , munitionSprite);
        }
        return null;
    }

    @Override
    public void attack(int x, int y, ArrayList<Shot> shots, int rotation) {
        Shot shot = shot(x, y, rotation);
        if (shot != null) {
            shots.add(shot);
        }
    }
}
