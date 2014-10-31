package ch.bfh.shooter.GameState;

import ch.bfh.shooter.Sprites.Background;
import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.assets.AssetManager;

import java.awt.*;

/**
 * Created by Jan on 28.10.2014.
 */
public class GameState extends State {

    private Background bg;
    private Map map;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        bg = new Background(AssetManager.gameBackground);
        map = new Map(AssetManager.level1Map);

    }

    @Override
    public void init() {

    }

    @Override
    public void update() {


    }

    @Override
    public void draw(Graphics2D g) {
        bg.draw(g);
        map.draw(g);
    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }

    private void drawMap() {

    }
}
