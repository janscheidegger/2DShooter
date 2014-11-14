package ch.bfh.shooter.gameobjects.attackstyle;

import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.gameobjects.MovableGameObject;

/**
 * Created by jan on 07/11/14.
 */
public abstract class Attack {

    Map map;
    MovableGameObject self;

    public Attack(MovableGameObject self, Map map) {
        this.map = map;
        this.self = self;
    }

    public abstract void attack(MovableGameObject target);
}
