package ch.bfh.shooter.GameState;

import ch.bfh.shooter.Sprites.Background;
import ch.bfh.shooter.Sprites.Hud;
import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.assets.Sound;
import ch.bfh.shooter.gameobjects.Enemy;
import ch.bfh.shooter.gameobjects.Hero;
import ch.bfh.shooter.gameobjects.attackstyle.ShootAttack;
import ch.bfh.shooter.gameobjects.pickups.Heart;
import ch.bfh.shooter.gameobjects.pickups.Pickup;
import ch.bfh.shooter.gameobjects.weapon.Pistol;
import ch.bfh.shooter.gameobjects.weapon.Rifle;
import ch.bfh.shooter.gameobjects.weapon.Shot;
import ch.bfh.shooter.gameobjects.weapon.Weapon;
import ch.bfh.shooter.helper.ShooterConstants;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Jan on 28.10.2014.
 */
public class GameState extends State {

    public static int enemyCount = 0;

    private Background bg;
    private Map map;
    private Hud hud;
    private Hero hero;
    private ArrayList<Enemy> enemies;
    private ArrayList<Shot> shots;
    private ArrayList<Pickup> pickups;
    private Weapon pistol;
    private Weapon rifle;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        bg = new Background(AssetManager.gameBackground);
        hud = new Hud(AssetManager.hud);
        map = new Map(AssetManager.level1Map);
        hero = new Hero(map, hud);
        enemies = new ArrayList<Enemy>();
        shots = new ArrayList<Shot>();
        pickups = new ArrayList<Pickup>();
        createEnemies();
        pickups.add(new Heart(ShooterConstants.WIDTH - 100, ShooterConstants.HEIGHT - 100));
        pistol = new Pistol(hero);
        rifle = new Rifle(hero);
        hero.setWeapon(pistol);


    }

    private void createEnemies() {
        Enemy e1 = new Enemy(map, 50, ShooterConstants.HEIGHT - 50, .5f, hero);
        Enemy e2 = new Enemy(map, ShooterConstants.WIDTH - 50, 50, .5f, hero);
        Enemy e3 = new Enemy(map, 50, 50, .5f, hero);
        Enemy e4 = new Enemy(map, ShooterConstants.WIDTH - 50, ShooterConstants.HEIGHT - 50, .5f, hero);
        e1.setAttack(new ShootAttack(e1, map, shots));
        enemies.add(e1);
        enemies.add(e2);
        enemies.add(e3);
        enemies.add(e4);
    }

    @Override
    public void init() {
        Sound.loop(Sound.gameMusic);
    }

    @Override
    public void update() {
        hero.update();
        updateEnemies();
        updateShots();
        checkShotCollision();
        checkPickupCollision();
        checkEnd();
    }

    private void checkPickupCollision() {
        for (int i = 0; i < pickups.size(); i++) {
            if(pickups.get(i).getCollisionRect().intersects(hero.getCollisionRect())) {
                hero.collect(pickups.get(i));
                pickups.remove(i);
            }
        }
    }

    @Override
    public void draw(Graphics2D g) {
        bg.draw(g);
        map.draw(g);
        hud.draw(g);
        drawEnemies(g);
        hero.draw(g);
        drawShots(g);
        drawPickups(g);
    }

    private void drawPickups(final Graphics2D g) {
        pickups.forEach(s -> s.draw(g));
    }

    private void updateShots() {
        shots.forEach(s -> s.update());
    }

    private void drawShots(Graphics2D g) {
        shots.forEach(s -> s.draw(g));
    }

    private void updateEnemies() {
        enemies.forEach(s -> s.update());
    }

    private void drawEnemies(Graphics2D g) {
        enemies.forEach(s -> s.draw(g));
    }

    private void checkShotCollision() {
        for (int i = 0; i < shots.size(); i++) {
            for (int j = 0; j < enemies.size(); j++) {
                if (shots.get(i).getOwner() != enemies.get(j) && enemies.get(j).getState() == Enemy.EnemyState.Alive && enemies.get(j).getCollisionRect().intersects(shots.get(i).getCollisionRect())) {
                    if (enemies.get(j).hit(shots.get(i).getDamage()) <= 0) {
                        enemies.get(j).die();
                    }
                    shots.remove(i);
                    break;
                }
                else if(shots.get(i).getOwner() != hero && hero.getCollisionRect().intersects(shots.get(i).getCollisionRect())) {
                    hero.hit(shots.get(i).getDamage());
                    shots.remove(i);
                    break;
                }
            }
            if (shots.size() > i && map.getTileType((int)shots.get(i).getX() / ShooterConstants.TILE_SIZE, (int)shots.get(i).getY() / ShooterConstants.TILE_SIZE) == Map.TileType.BLOCK) {
                shots.remove(i);
            }
        }
    }

    private void checkEnd() {
        if(hero.getHealth() <= 0) gsm.set(new LoseState(gsm));
        if(enemyCount <= 0) {
            gsm.set(new WinState(gsm));
        }
    }

    @Override
    public void keyPressed(int k) {
        if (k == KeyEvent.VK_LEFT) hero.setLeft(true);
        if (k == KeyEvent.VK_RIGHT) hero.setRight(true);
        if (k == KeyEvent.VK_DOWN) hero.setDown(true);
        if (k == KeyEvent.VK_UP) hero.setUp(true);
        if (k == KeyEvent.VK_1) hero.setWeapon(pistol);
        if (k == KeyEvent.VK_2) hero.setWeapon(rifle);
        if (k == KeyEvent.VK_SPACE) hero.attack(shots);
        if (k == KeyEvent.VK_R) hero.reload();
        if (k == KeyEvent.VK_ESCAPE) gsm.push(new HelpScreen(gsm));
    }

    @Override
    public void keyReleased(int k) {
        if (k == KeyEvent.VK_LEFT) hero.setLeft(false);
        if (k == KeyEvent.VK_RIGHT) hero.setRight(false);
        if (k == KeyEvent.VK_DOWN) hero.setDown(false);
        if (k == KeyEvent.VK_UP) hero.setUp(false);
    }

    @Override
    public void exit() {
        Sound.stop(Sound.gameMusic);
    }

}
