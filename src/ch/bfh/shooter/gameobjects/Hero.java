package ch.bfh.shooter.gameobjects;

import ch.bfh.shooter.Sprites.Hud;
import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.assets.Sound;
import ch.bfh.shooter.gameobjects.pickups.Pickup;
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
    private float speed;

    public Hero(Map map, Hud hud) {
        this.hud = hud;
        this.health = ShooterConstants.HERO_MAXHEALTH;
        this.map = map;
        this.x = ShooterConstants.WIDTH/2;
        this.y = ShooterConstants.HEIGHT/2;
        this.width = ShooterConstants.HERO_WIDTH;
        this.height = ShooterConstants.HERO_HEIGHT;
        this.sprite = AssetManager.heroSprite;
        hud.setHeroHealth(health);
        this.speed = ShooterConstants.INITIAL_HERO_SPEED;

        setWeapon(new Pistol(this));

    }


    @Override
    public void update() {
        float tempX = x;
        float tempY = y;
        if (this.up) y -= this.speed;
        if(!bottomLeft && !bottomRight && this.down) y += this.speed;
        if(!topLeft && ! bottomLeft && this.left) x -=this.speed;
        if(!topRight && !bottomRight && this.right) x+=this.speed;
        checkCollision();
        if(topLeft || topRight && this.up) y = tempY;
        if((bottomLeft || bottomRight) && this.down) y = tempY;
        if((topLeft ||  bottomLeft) && this.left) x = tempX;
        if((topRight || bottomRight) && this.right) x = tempX;
        weapon.lowerCooldown();
    }

    private void checkCollision() {
        topLeft = map.getTileType((int)x/ShooterConstants.TILE_SIZE, (int)y/ShooterConstants.TILE_SIZE) == Map.BLOCK;
        topRight = map.getTileType(((int)x+ShooterConstants.HERO_WIDTH)/ShooterConstants.TILE_SIZE, (int)y/ShooterConstants.TILE_SIZE) ==Map.BLOCK;
        bottomLeft = map.getTileType((int)x/ShooterConstants.TILE_SIZE, ((int)y+ShooterConstants.HERO_HEIGHT)/ShooterConstants.TILE_SIZE)==Map.BLOCK;
        bottomRight = map.getTileType(((int)x+ShooterConstants.HERO_WIDTH)/ShooterConstants.TILE_SIZE, ((int)y+ShooterConstants.HERO_HEIGHT)/ShooterConstants.TILE_SIZE) ==Map.BLOCK;

    }

    public void attack(ArrayList<Shot> shots) {
        Sound.play(Sound.shoot);
        weapon.attack((int)x + (this.width/2), (int)y+(this.width/2), shots, rotation, this);

        hud.setCurrentMunitionCount(weapon.getMunition());
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        hud.setWeaponImage(weapon.getWeaponImage());
        hud.setCurrentMunitionCount(weapon.getMunition());
    }

    public int hit(int damage) {
        hud.setHeroHealth(health - damage);
        return super.hit(damage);
    }

    public void collect(Pickup pickup) {
        pickup.getPower(this);
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
        hud.setHeroHealth(health);
    }
}
