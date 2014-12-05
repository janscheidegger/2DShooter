package ch.bfh.shooter.gameobjects;

import ch.bfh.shooter.GameState.GameState;
import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.gameobjects.attackstyle.Attack;
import ch.bfh.shooter.gameobjects.attackstyle.StupidAttack;
import ch.bfh.shooter.helper.ShooterConstants;

import java.awt.*;

/**
 * Created by Jan on 01.11.2014.
 */
public class Enemy extends MovableGameObject {

    Hero hero;
    private Attack attack;
    private EnemyState state;

    public void die() {
        this.state = EnemyState.Dead;
        this.sprite = AssetManager.enemySpriteDead;
        GameState.enemyCount--;
    }

    public enum EnemyState {
        Dead, Alive
    }

    public Enemy(Map map, int x, int y, float speed, Hero hero) {
        GameState.enemyCount++;
        this.state = EnemyState.Alive;
        this.map = map;
        this.x = x;
        this.y = y;
        this.width = ShooterConstants.ENEMY_WIDTH;
        this.height = ShooterConstants.ENEMY_HEIGHT;
        this.speed = speed;
        this.hero = hero;
        this.sprite = AssetManager.enemySprite;
        this.health = ShooterConstants.ENEMY_MAXHEALTH;
        this.attack = new StupidAttack(this, map);
    }

    @Override
    public void update() {
        if(this.state == EnemyState.Alive) {
            attack.attack(hero);
        }

    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }



    public void draw(Graphics2D g) {
        super.draw(g);
        if(this.state == EnemyState.Alive) {
            g.setColor(Color.GREEN);
            g.fillRect((int) x, (int) y - 10, health, 10);
            g.setColor(Color.RED);
            g.fillRect((int) x + health, (int) y - 10, (ShooterConstants.ENEMY_MAXHEALTH - health), 10);
        }
    }

    public EnemyState getState() {
        return state;
    }
}
