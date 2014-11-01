package ch.bfh.shooter.GameState;

import ch.bfh.shooter.Sprites.Background;
import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.assets.AssetManager;
import ch.bfh.shooter.gameobjects.Hero;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Jan on 28.10.2014.
 */
public class GameState extends State {

    private Background bg;
    private Map map;
    private Hero hero;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        bg = new Background(AssetManager.gameBackground);
        map = new Map(AssetManager.level1Map);
        hero = new Hero(map);

    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        hero.update();

    }

    @Override
    public void draw(Graphics2D g) {
        bg.draw(g);
        map.draw(g);
        hero.draw(g);
    }

    @Override
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_LEFT) hero.setLeft(true);
        if(k == KeyEvent.VK_RIGHT) hero.setRight(true);
        if (k == KeyEvent.VK_DOWN) hero.setDown(true);
        if (k == KeyEvent.VK_UP) hero.setUp(true);
    }

    @Override
    public void keyReleased(int k) {
        if(k == KeyEvent.VK_LEFT) hero.setLeft(false);
        if(k == KeyEvent.VK_RIGHT) hero.setRight(false);
        if (k == KeyEvent.VK_DOWN) hero.setDown(false);
        if (k == KeyEvent.VK_UP) hero.setUp(false);
    }

}
