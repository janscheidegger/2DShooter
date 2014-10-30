package ch.bfh.shooter.Sprites;

import ch.bfh.shooter.helper.ShooterConstants;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Jan on 28.10.2014.
 */
public class Background {

    private BufferedImage image;

    private double x;
    private double y;

    public Background(BufferedImage image) {
        this.image = image;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g) {
        g.drawImage(image, (int) x, (int) y, null);
    }

}
