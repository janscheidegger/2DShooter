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
    protected boolean up;
    protected boolean left;
    protected boolean right;
    protected boolean down;

    public abstract void update();

    public abstract void draw(Graphics2D g);
    public Rectangle getCollisionRect() {
        return new Rectangle(x,y, width, height);
    }

    public boolean isUp() {
        return up;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isDown() {
        return down;
    }


    public void setUp(boolean up) {
        this.up = up;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
