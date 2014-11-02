package ch.bfh.shooter.gameobjects;

import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.helper.ShooterConstants;

import java.awt.*;

/**
 * Created by Jan on 01.11.2014.
 */
public class Enemy extends MovableGameObject {

    Hero hero;
    private int health;

    public Enemy(int x, int y, Hero hero) {
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
        attackHero();

    }

    private void attackHero() {
        int heroX = hero.getX();
        int heroY = hero.getY();
        if(heroX > x) {
            x++;
        }
        if(heroX < x) {
            x--;
        }
        if(heroY > y) {
            y++;
        }
        if(heroY < y) {
            y--;
        }
    }

    public int hit(int damage) {
        this.health -= damage;
        return this.health;
    }

    public void draw(Graphics2D g) {
        super.draw(g);
        g.setColor(Color.GREEN);
        g.fillRect(x,y-10, health, 10);
        g.setColor(Color.RED);
        g.fillRect(x+health,y-10, (int)((float)width / ShooterConstants.ENEMY_MAXHEALTH * (ShooterConstants.ENEMY_MAXHEALTH - health)), 10);
    }

}
