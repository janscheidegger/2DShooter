package ch.bfh.shooter.assets;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.IOException;

/**
 * Created by Jan on 29.10.2014.
 */
public class AssetManager {

    public static BufferedImage menuBackground = getBufferedImage("/backgrounds/menubg.gif");
    public static BufferedImage gameBackground = getBufferedImage("/backgrounds/map.png");

    private static BufferedImage getBufferedImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(AssetManager.class.getResourceAsStream(path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
