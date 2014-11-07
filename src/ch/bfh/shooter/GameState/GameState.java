package ch.bfh.shooter.GameState;

import ch.bfh.shooter.Sprites.Background;
import ch.bfh.shooter.Sprites.Hud;
import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.gameobjects.Enemy;
import ch.bfh.shooter.gameobjects.Hero;
import ch.bfh.shooter.gameobjects.weapon.Pistol;
import ch.bfh.shooter.gameobjects.weapon.Rifle;
import ch.bfh.shooter.gameobjects.weapon.Shot;
import ch.bfh.shooter.gameobjects.attackstyle.StupidAttack;
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
    private Hud hud;
    private Hero hero;
    private ArrayList<Enemy> enemies;
    private ArrayList<Shot> shots;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        bg = new Background(AssetManager.gameBackground);
        hud = new Hud(AssetManager.hud);
        map = new Map(AssetManager.level1Map);
        hero = new Hero(map, hud);
        enemies = new ArrayList<Enemy>();
        shots = new ArrayList<Shot>();
        createEnemies();

    }

    private void createEnemies() {
        enemies.add(new Enemy(map, ShooterConstants.WIDTH - 50, ShooterConstants.HEIGHT - 50, hero,new StupidAttack()) );
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        hero.update();
        updateEnemies();
        updateShots();
        checkShotCollision();
        checkEnd();
    }




    @Override
    public void draw(Graphics2D g) {
        bg.draw(g);
        map.draw(g);
        hud.draw(g);
        hero.draw(g);
        drawEnemies(g);
        drawShots(g);
    }

    private void updateShots() {
        for (Shot shot : shots) {
            shot.update();
        }
    }

    private void drawShots(Graphics2D g) {
        for (Shot shot : shots) {
            shot.draw(g);
        }
    }

    private void updateEnemies() {
        for (Enemy enemy : enemies) {
            enemy.update();
        }
    }

    private void drawEnemies(Graphics2D g) {
        for (Enemy enemy : enemies) {
            enemy.draw(g);
        }
    }

    private void checkShotCollision() {
        for (int i = 0; i < shots.size(); i++) {
            for (int j = 0; j < enemies.size(); j++) {
                if (enemies.get(j).getCollisionRect().intersects(shots.get(i).getCollisionRect())) {
                    if (enemies.get(j).hit(shots.get(i).getDamage()) <= 0) {
                        enemies.remove(j);
                    }
                    shots.remove(i);
                }
            }
            if (shots.size() > i && map.getTileType(shots.get(i).getX() / ShooterConstants.TILE_SIZE, shots.get(i).getY() / ShooterConstants.TILE_SIZE) == Map.BLOCK) {
                shots.remove(i);
            }
        }
    }

    private void checkEnd() {
        if(hero.getHealth() <= 0) gsm.set(new LoseState(gsm));
        if(enemies.size() <= 0) {
            gsm.set(new WinState(gsm));
        }
    }

    @Override
    public void keyPressed(int k) {
        if (k == KeyEvent.VK_LEFT) hero.setLeft(true);
        if (k == KeyEvent.VK_RIGHT) hero.setRight(true);
        if (k == KeyEvent.VK_DOWN) hero.setDown(true);
        if (k == KeyEvent.VK_UP) hero.setUp(true);
        if (k == KeyEvent.VK_1) hero.setWeapon(new Pistol());
        if (k == KeyEvent.VK_2) hero.setWeapon(new Rifle());
        if (k == KeyEvent.VK_SPACE) hero.attack(shots);
        if (k == KeyEvent.VK_ESCAPE) gsm.push(new HelpScreen(gsm));
    }

    @Override
    public void keyReleased(int k) {
        if (k == KeyEvent.VK_LEFT) hero.setLeft(false);
        if (k == KeyEvent.VK_RIGHT) hero.setRight(false);
        if (k == KeyEvent.VK_DOWN) hero.setDown(false);
        if (k == KeyEvent.VK_UP) hero.setUp(false);
    }

}
