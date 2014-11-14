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
        int heroX = target.getX();
        int heroY = target.getY();
        if (heroX > self.x) {
            self.x++;
        }
        if (heroX < self.x) {
            self.x--;
        }
        if (heroY > self.y) {
            self.y++;
        }
        if (heroY < self.y) {
            self.y--;
        }

    }
}
