package ch.bfh.shooter.gameobjects;

import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.gameobjects.attackstyle.Attack;
import ch.bfh.shooter.helper.ShooterConstants;

import java.awt.*;

/**
 * Created by Jan on 01.11.2014.
 */
public class Enemy extends MovableGameObject {

    Hero hero;
    private Attack attack;

    public Enemy(Map map, int x, int y, Hero hero, Attack attack) {
        this.map = map;
        this.attack = attack;
        this.x = x;
        this.y = y;
        this.width = ShooterConstants.ENEMY_WIDTH;
        this.height = ShooterConstants.ENEMY_HEIGHT;
        this.hero = hero;
        this.sprite = AssetManager.enemySprite;
        this.health = ShooterConstants.ENEMY_MAXHEALTH;
    }

    @Override
    public void update() {
        attack.attack(this, hero, map);

    }



    public void draw(Graphics2D g) {
        super.draw(g);
        g.setColor(Color.GREEN);
        g.fillRect(x,y-10, health, 10);
        g.setColor(Color.RED);
        g.fillRect(x+health,y-10,  (ShooterConstants.ENEMY_MAXHEALTH - health), 10);
    }

}
