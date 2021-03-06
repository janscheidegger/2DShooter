package ch.bfh.shooter.gameobjects;

import ch.bfh.shooter.Sprites.Map;

import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by jan on 31/10/14.
 */
public abstract class MovableGameObject extends GameObject {


    //Collision Corners
    protected boolean topLeft;
    protected boolean topRight;
    protected boolean bottomLeft;
    protected boolean bottomRight;
    protected boolean up;
    protected boolean left;
    protected boolean right;
    protected boolean down;
    protected int rotation;
    protected Map map;
    protected int health;
    protected float speed;

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

    public void draw(Graphics2D g) {
        handleRotation();
        AffineTransform t = new AffineTransform();
        t.setToTranslation(x, y);
        t.rotate(Math.toRadians(rotation), width/2, height/2);
        g.drawImage(sprite, t, null);
    }

    private void handleRotation() {
        if(isRight()) {
            this.rotation = 90;
        }
        if(isLeft()) rotation = 270;
        if(isUp()) rotation = 0;
        if(isDown()) rotation = 180;
    }

    public Map getMap() {
        return map;
    }

    public int hit(int damage) {
        this.health -= damage;
        return this.health;
    }

    public int getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
