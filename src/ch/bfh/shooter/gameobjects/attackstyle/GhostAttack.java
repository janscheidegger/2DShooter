package ch.bfh.shooter.gameobjects.attackstyle;

import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.gameobjects.MovableGameObject;

/**
 * Created by jan on 07/11/14.
 */
public class GhostAttack extends Attack {
    public GhostAttack(MovableGameObject self, Map map) {
        super(self, map);
    }

    public void attack( MovableGameObject target) {
        float heroX = target.getX();
        float heroY = target.getY();
        if (heroX > self.x) {
            self.x+=self.getSpeed();
        }
        if (heroX < self.x) {
            self.x-=self.getSpeed();
        }
        if (heroY > self.y) {
            self.y+=self.getSpeed();
        }
        if (heroY < self.y) {
            self.y-=self.getSpeed();
        }

    }
}
