package ch.bfh.shooter.gameobjects;

import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.helper.ShooterConstants;

/**
 * Created by Jan on 02.11.2014.
 */
public class Shot extends MovableGameObject {
    public Shot(int x, int y, int rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.sprite = AssetManager.shotSprite;
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


}
