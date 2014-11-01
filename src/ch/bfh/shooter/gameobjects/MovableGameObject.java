package ch.bfh.shooter.gameobjects;

/**
 * Created by jan on 31/10/14.
 */
public abstract class MovableGameObject extends GameObject {

    protected float dx;
    protected float dy;

    //Collision Corners
    protected boolean topLeft;
    protected boolean topRight;
    protected boolean bottomLeft;
    protected boolean bottomRight;


}
