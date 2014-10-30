package ch.bfh.shooter.GameState;

import ch.bfh.shooter.Sprites.Background;
import ch.bfh.shooter.assets.AssetManager;
import tiled.core.Map;
import tiled.core.TileLayer;
import tiled.io.TMXMapReader;

import java.awt.*;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Jan on 28.10.2014.
 */
public class GameState extends State {

    private Background bg;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        bg = new Background(AssetManager.gameBackground);
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

    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }
}
