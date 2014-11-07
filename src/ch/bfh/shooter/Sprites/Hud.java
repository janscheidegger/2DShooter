package ch.bfh.shooter.Sprites;

import ch.bfh.shooter.helper.ShooterConstants;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Jan on 28.10.2014.
 */
public class Hud {

    private BufferedImage image;
    private BufferedImage weaponImage;
    private int currentMunitionCount;

    private double x;
    private double y;

    public Hud(BufferedImage image) {
        this.image = image;
        this.setPosition(0, ShooterConstants.HEIGHT);

    }



    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        g.drawImage(image, (int) x, (int) y, null);
        g.drawImage(weaponImage, (int)x+100, (int)y+30, null);
        g.setFont(new Font("Century Gothic", Font.PLAIN, 28));
        g.drawString(Integer.toString(currentMunitionCount), (int) x + 20, (int)(y+(image.getHeight()/2)));
    }

    public void setCurrentMunitionCount(int count) {
        this.currentMunitionCount = count;
    }

    public void setWeaponImage(BufferedImage weaponImage) {
        this.weaponImage = weaponImage;
    }

}
