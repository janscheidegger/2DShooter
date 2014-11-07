package ch.bfh.shooter.gameobjects.attackstyle;

import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.gameobjects.MovableGameObject;

/**
 * Created by jan on 07/11/14.
 */
public abstract class Attack {

    public abstract void attack(MovableGameObject self, MovableGameObject target, Map map);
}
