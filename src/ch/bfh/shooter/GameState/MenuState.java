package ch.bfh.shooter.GameState;

import ch.bfh.shooter.Sprites.Background;
import ch.bfh.shooter.assets.AssetManager;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Jan on 28.10.2014.
 */
public class MenuState extends State {

    private Background bg;
    private String[] options = {
            "Start",
            "Hilfe",
            "Quit"
    };
    private int currentChoice = 0;

    private Color titleColor;
    private Font titleFont;

    private Font font;

    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;
        bg = new Background(AssetManager.menuBackground);

        titleColor = new Color(128, 0, 0);
        titleFont = new Font("Century Gothic", Font.PLAIN, 28);

        font = new Font("Arial", Font.PLAIN, 12);
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
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("2D Shooter", 80, 70);

        // options
        g.setFont(font);
        for (int i = 0; i < options.length; i++) {
            if (i == currentChoice) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.LIGHT_GRAY);
            }
            g.drawString(options[i], 145, 140 + i * 15);
        }
    }

    private void select() {

        if(currentChoice == 0) {
            gsm.set(new GameState(gsm));
        }
        if(currentChoice == 1) {
            gsm.push(new HelpScreen(gsm));
        }
        if(currentChoice == 2) {
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(int k) {
        if (k == KeyEvent.VK_ENTER) {
            select();
        }
        if (k == KeyEvent.VK_UP) {
            currentChoice--;
            if (currentChoice == -1) currentChoice = options.length - 1;
        }
        if (k == KeyEvent.VK_DOWN) {
            currentChoice++;
            if (currentChoice == options.length) currentChoice = 0;
        }
    }

    @Override
    public void keyReleased(int k) {

    }
}