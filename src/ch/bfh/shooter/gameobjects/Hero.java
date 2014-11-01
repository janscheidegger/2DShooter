package ch.bfh.shooter.gameobjects;

import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.helper.ShooterConstants;

import java.awt.*;

/**
 * Created by jan on 31/10/14.
 */
public class Hero extends MovableGameObject{
    private Map map;
    public Hero(Map map) {
        this.map = map;
        this.x = 50;
        this.y = 50;
        this.width = ShooterConstants.HERO_WIDTH;
        this.height = ShooterConstants.HERO_HEIGHT;
    }

    @Override
    public void update() {
        checkCollision();
        if (!topLeft && !topRight && this.up) y --;
        if(!bottomLeft && !bottomRight && this.down) y ++;
        if(!topLeft && ! bottomLeft && this.left) x --;
        if(!topRight && !bottomRight && this.right) x++;
    }

    private void checkCollision() {
        topLeft = map.getTileType(x/ShooterConstants.TILE_SIZE, y/ShooterConstants.TILE_SIZE) == 1;
        topRight = map.getTileType((x+ShooterConstants.HERO_WIDTH)/ShooterConstants.TILE_SIZE, y/ShooterConstants.TILE_SIZE) ==1;
        bottomLeft = map.getTileType(x/ShooterConstants.TILE_SIZE, (y+ShooterConstants.HERO_HEIGHT)/ShooterConstants.TILE_SIZE)==1;
        bottomRight = map.getTileType((x+ShooterConstants.HERO_WIDTH)/ShooterConstants.TILE_SIZE, (y+ShooterConstants.HERO_HEIGHT)/ShooterConstants.TILE_SIZE) ==1;

        System.out.println("topLeft= "+topLeft);
        System.out.println("topRight= "+topRight);
        System.out.println("bottomLeft= "+bottomLeft);
        System.out.println("bottomRight= "+bottomRight);

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.RED);
        g.fillRect(x,y,width,height);
    }
}
