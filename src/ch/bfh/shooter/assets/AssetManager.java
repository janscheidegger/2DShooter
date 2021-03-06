package ch.bfh.shooter.assets;

import ch.bfh.shooter.Sprites.Map;
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

    public static BufferedImage menuBackground = getBufferedImage("/backgrounds/menubg.png");
    public static BufferedImage gameBackground = getBufferedImage("/backgrounds/map.png");
    public static BufferedImage winBackground = getBufferedImage("/backgrounds/winbg.png");
    public static BufferedImage loseBackground = getBufferedImage("/backgrounds/losebg.png");
    public static BufferedImage helpBackground = getBufferedImage("/backgrounds/helpbg.png");

    public static BufferedImage heroSprite = getBufferedImage("/sprites/hero.png");
    public static BufferedImage enemySprite = getBufferedImage("/sprites/enemy.png");
    public static BufferedImage enemySpriteDead = getBufferedImage("/sprites/enemy_dead.png");
    public static BufferedImage shotSprite = getBufferedImage("/sprites/shot.png");
    public static BufferedImage heartSprite = getBufferedImage("/sprites/heart.png");
    public static BufferedImage hud = getBufferedImage("/sprites/hud.png");
    public static BufferedImage pistolImage = getBufferedImage("/sprites/pistol.png");
    public static BufferedImage rifleImage = getBufferedImage("/sprites/rifle.png");

    public static Map.TileType[][] level1Map = parseMapFile("/tilemap/level1.mapconfig");



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

    public static Map.TileType[][] parseMapFile(String path) {

        String mapFile = readMapFile(path);
        String lines[] = mapFile.split("\\r?\\n");
        int width = lines[0].split(" ").length;
        Map.TileType[][] map = new Map.TileType[lines.length][width];
        for(int i = 0; i < lines.length; i++) {
            for(int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(lines[i].split(" ")[j]) == 1 ? Map.TileType.BLOCK : Map.TileType.NOTHING;
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
