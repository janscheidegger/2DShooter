package ch.bfh.shooter.GameState;

import ch.bfh.shooter.Sprites.Background;
import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.gameobjects.Enemy;
import ch.bfh.shooter.gameobjects.Hero;
import ch.bfh.shooter.gameobjects.Shot;
import ch.bfh.shooter.helper.ShooterConstants;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Jan on 28.10.2014.
 */
public class GameState extends State {

    private Background bg;
    private Map map;
    private Hero hero;
    private ArrayList<Enemy> enemies;
    private ArrayList<Shot> shots;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        bg = new Background(AssetManager.gameBackground);
        map = new Map(AssetManager.level1Map);
        hero = new Hero(map);
        enemies = new ArrayList<Enemy>();
        shots = new ArrayList<Shot>();
        createEnemies();

    }

    private void createEnemies() {
        new Enemy(ShooterConstants.WIDTH-50, ShooterConstants.HEIGHT - 50, hero);
        enemies.add(new Enemy(ShooterConstants.WIDTH-50, ShooterConstants.HEIGHT - 50, hero));
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        hero.update();
        updateEnemies();
        updateShots();

    }



    @Override
    public void draw(Graphics2D g) {
        bg.draw(g);
        map.draw(g);
        hero.draw(g);
        drawEnemies(g);
        drawShots(g);
    }

    private void updateShots() {
        for(Shot shot: shots) {
            shot.update();
        }
    }

    private void drawShots(Graphics2D g) {
        for(Shot shot: shots) {
            shot.draw(g);
        }
    }

    private void updateEnemies() {
        for(Enemy enemy: enemies) {
            enemy.update();
        }
    }

    private void drawEnemies(Graphics2D g) {
        for(Enemy enemy: enemies) {
            enemy.draw(g);
        }
    }

    @Override
    public void keyPressed(int k) {
        if (k == KeyEvent.VK_LEFT) hero.setLeft(true);
        if (k == KeyEvent.VK_RIGHT) hero.setRight(true);
        if (k == KeyEvent.VK_DOWN) hero.setDown(true);
        if (k == KeyEvent.VK_UP) hero.setUp(true);
        if (k == KeyEvent.VK_SPACE) hero.shoot(shots);
    }

    @Override
    public void keyReleased(int k) {
        if (k == KeyEvent.VK_LEFT) hero.setLeft(false);
        if (k == KeyEvent.VK_RIGHT) hero.setRight(false);
        if (k == KeyEvent.VK_DOWN) hero.setDown(false);
        if (k == KeyEvent.VK_UP) hero.setUp(false);
    }

}
