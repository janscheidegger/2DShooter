package ch.bfh.shooter.gameobjects;

import java.awt.*;

/**
 * Created by jan on 31/10/14.
 */
public class Block extends GameObject{

    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        //g.setColor(Color.LIGHT_GRAY);
        //g.fillRect(x,y,width,height);
    }
}
