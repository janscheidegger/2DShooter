package ch.bfh.shooter.assets;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Created by Jan on 29.10.2014.
 */
public class AssetManager {

    public static BufferedImage menuBackground = getBufferedImage("/backgrounds/menubg.gif");
    public static BufferedImage gameBackground = getBufferedImage("/backgrounds/map.png");
    public static BufferedImage winBackground = getBufferedImage("/backgrounds/winbg.png");
    public static BufferedImage helpBackground = getBufferedImage("/backgrounds/helpbg.png");
    public static BufferedImage heroSprite = getBufferedImage("/sprites/hero.png");
    public static BufferedImage enemySprite = getBufferedImage("/sprites/enemy.png");
    public static BufferedImage shotSprite = getBufferedImage("/sprites/shot.png");
    public static int[][] level1Map = parseMapFile("/tilemap/level1.mapconfig");

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

    public static int[][] parseMapFile(String path) {

        String mapFile = readMapFile(path);
        String lines[] = mapFile.split("\\r?\\n");
        int width = lines[0].split(" ").length;
        int[][] map = new int[lines.length][width];
        for(int i = 0; i < lines.length; i++) {
            for(int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(lines[i].split(" ")[j]);
            }
        }

        return map;


    }
    private static String readMapFile(String path) {
        URL url = AssetManager.class.getResource(path);
        String text = "";
        try {
            text = Resources.toString(url, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

}
