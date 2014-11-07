package ch.bfh.shooter.gameobjects;

import java.awt.*;

/**
 * Created by jan on 31/10/14.
 */
public abstract class GameObject {
    public int x;
    public int y;
    protected int width;
    protected int height;
    protected Image sprite;

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public abstract void update();

    public abstract void draw(Graphics2D g);
    public Rectangle getCollisionRect() {
        return new Rectangle(x,y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
