package ch.bfh.shooter.gameobjects;

import ch.bfh.shooter.Sprites.Hud;
import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.assets.Sound;
import ch.bfh.shooter.gameobjects.weapon.Pistol;
import ch.bfh.shooter.gameobjects.weapon.Shot;
import ch.bfh.shooter.gameobjects.weapon.Weapon;
import ch.bfh.shooter.helper.ShooterConstants;

import java.util.ArrayList;

/**
 * Created by jan on 31/10/14.
 */
public class Hero extends MovableGameObject{

    private Weapon weapon;
    private Hud hud;

    public Hero(Map map, Hud hud) {
        this.hud = hud;
        this.health = ShooterConstants.HERO_MAXHEALTH;
        this.map = map;
        this.x = 50;
        this.y = 50;
        this.width = ShooterConstants.HERO_WIDTH;
        this.height = ShooterConstants.HERO_HEIGHT;
        this.sprite = AssetManager.heroSprite;
        setWeapon(new Pistol());

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

    public void attack(ArrayList<Shot> shots) {
        Sound.play(Sound.shoot);
        weapon.attack(x + (ShooterConstants.HERO_WIDTH/2), y+(ShooterConstants.HERO_HEIGHT/2), shots, rotation);

        hud.setCurrentMunitionCount(weapon.getMunition());
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        hud.setWeaponImage(weapon.getWeaponImage());
        hud.setCurrentMunitionCount(weapon.getMunition());
    }




}
