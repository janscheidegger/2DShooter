package ch.bfh.shooter.gameobjects;

import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.helper.ShooterConstants;

/**
 * Created by Jan on 01.11.2014.
 */
public class Enemy extends MovableGameObject {

    Hero hero;

    public Enemy(int x, int y, Hero hero) {
        this.x = x;
        this.y = y;
        this.width = ShooterConstants.ENEMY_WIDTH;
        this.height = ShooterConstants.ENEMY_HEIGHT;
        this.hero = hero;
        this.sprite = AssetManager.enemySprite;
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
}
