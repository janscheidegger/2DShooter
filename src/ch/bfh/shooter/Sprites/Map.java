package ch.bfh.shooter.Sprites;

import ch.bfh.shooter.gameobjects.Block;
import ch.bfh.shooter.helper.ShooterConstants;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by jan on 31/10/14.
 */
public class Map {

    public static enum TileType {
        NOTHING, BLOCK
    }
        private TileType[][] mapConfig;

    ArrayList<Block> blocks = new ArrayList<Block>();

    public Map(TileType[][] mapConfig) {
        this.mapConfig = mapConfig;
        initBlocks(mapConfig);
    }
    public void draw(Graphics2D g) {
        for (Block block : blocks) {
            block.draw(g);
        }
    }

    private void initBlocks(TileType[][] mapConfig) {
        for(int i = 0; i < mapConfig.length;i++) {
            for(int j = 0; j<mapConfig[0].length;j++) {
                switch(mapConfig[i][j]) {
                    case NOTHING:
                        break;
                    case BLOCK:
                        blocks.add(new Block(j* ShooterConstants.TILE_SIZE, i*ShooterConstants.TILE_SIZE,
                                ShooterConstants.TILE_SIZE, ShooterConstants.TILE_SIZE));
                }
            }
        }
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public TileType getTileType(int x, int y) {
        return mapConfig[y][x];

    }
}
