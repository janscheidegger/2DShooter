package ch.bfh.shooter.GameState;

import ch.bfh.shooter.Sprites.Background;
import ch.bfh.shooter.assets.AssetManager;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Jan on 02.11.2014.
 */
public class HelpScreen extends State {

    Background bg;

    public HelpScreen(GameStateManager gsm) {
        this.gsm = gsm;
        bg = new Background(AssetManager.helpBackground);

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
        if(k == KeyEvent.VK_SPACE || k == KeyEvent.VK_ENTER) {
            gsm.pop();
        }
    }

    @Override
    public void keyReleased(int k) {

    }
}
