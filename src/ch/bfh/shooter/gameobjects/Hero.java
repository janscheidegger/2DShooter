package ch.bfh.shooter.gameobjects;

import ch.bfh.shooter.Sprites.Hud;
import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.assets.Sound;
import ch.bfh.shooter.helper.ShooterConstants;

import java.util.ArrayList;

/**
 * Created by jan on 31/10/14.
 */
public class Hero extends MovableGameObject{


    public Hero(Map map, Hud hud) {
        this.health = ShooterConstants.HERO_MAXHEALTH;
        this.map = map;
        this.x = 50;
        this.y = 50;
        this.width = ShooterConstants.HERO_WIDTH;
        this.height = ShooterConstants.HERO_HEIGHT;
        this.sprite = AssetManager.heroSprite;
    }


    @Override
    public void update() {
        int tempX = x;
        int tempY = y;
        if (this.up) y --;
        if(!bottomLeft && !bottomRight && this.down) y ++;
        if(!topLeft && ! bottomLeft && this.left) x --;
        if(!topRight && !bottomRight && this.right) x++;
        checkCollision();
        if(topLeft || topRight && this.up) y = tempY;
        if((bottomLeft || bottomRight) && this.down) y = tempY;
        if((topLeft ||  bottomLeft) && this.left) x = tempX;
        if((topRight || bottomRight) && this.right) x = tempX;
    }

    private void checkCollision() {
        topLeft = map.getTileType(x/ShooterConstants.TILE_SIZE, y/ShooterConstants.TILE_SIZE) == Map.BLOCK;
        topRight = map.getTileType((x+ShooterConstants.HERO_WIDTH)/ShooterConstants.TILE_SIZE, y/ShooterConstants.TILE_SIZE) ==Map.BLOCK;
        bottomLeft = map.getTileType(x/ShooterConstants.TILE_SIZE, (y+ShooterConstants.HERO_HEIGHT)/ShooterConstants.TILE_SIZE)==Map.BLOCK;
        bottomRight = map.getTileType((x+ShooterConstants.HERO_WIDTH)/ShooterConstants.TILE_SIZE, (y+ShooterConstants.HERO_HEIGHT)/ShooterConstants.TILE_SIZE) ==Map.BLOCK;

    }

    public void shoot(ArrayList<Shot> shots) {
        Sound.play(Sound.shoot);
        Shot shot = new Shot(this.x + width/2, this.y + height/2, rotation);
        shots.add(shot);
    }




}
