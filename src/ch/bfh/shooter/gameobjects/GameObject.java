package ch.bfh.shooter.gameobjects;

import java.awt.*;

/**
 * Created by jan on 31/10/14.
 */
public abstract class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public abstract void update();
    public abstract void draw(Graphics2D g);

    public Rectangle getCollisionRect() {
        return new Rectangle(x,y, width, height);
    }


}
