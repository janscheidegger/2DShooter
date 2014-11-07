package ch.bfh.shooter.gameobjects.attackstyle;

import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.gameobjects.MovableGameObject;
import ch.bfh.shooter.helper.ShooterConstants;

import java.util.Random;

/**
 * Created by jan on 07/11/14.
 */
public class StupidAttack extends Attack {
    private boolean topLeft;
    private boolean topRight;
    private boolean bottomLeft;
    private boolean bottomRight;
    private int attackDmg = 10;

    public StupidAttack() {
    }

    private void checkCollision(MovableGameObject self, Map map) {
        topLeft = map.getTileType(self.x/ ShooterConstants.TILE_SIZE, self.y/ShooterConstants.TILE_SIZE) == Map.BLOCK;
        topRight = map.getTileType((self.x+ShooterConstants.ENEMY_WIDTH)/ShooterConstants.TILE_SIZE, self.y/ShooterConstants.TILE_SIZE) ==Map.BLOCK;
        bottomLeft = map.getTileType(self.x/ShooterConstants.TILE_SIZE, (self.y+ShooterConstants.ENEMY_HEIGHT)/ShooterConstants.TILE_SIZE)==Map.BLOCK;
        bottomRight = map.getTileType((self.x+ShooterConstants.ENEMY_WIDTH)/ShooterConstants.TILE_SIZE, (self.y+ShooterConstants.ENEMY_HEIGHT)/ShooterConstants.TILE_SIZE) ==Map.BLOCK;
    }

    @Override
    public void attack(MovableGameObject self, MovableGameObject target, Map map) {
        int tempX = self.x;
        int tempY = self.y;

        int heroX = target.getX();
        int heroY = target.getY();
        if (heroX > self.x) {
            self.setRight(true);
            self.x++;
        }
        else {
            self.setRight(false);
        }
        if (heroX < self.x) {
            self.setLeft(true);
            self.x--;
        }
        else {
            self.setLeft(false);
        }
        if (heroY > self.y) {
            self.setDown(true);
            self.y++;
        }
        else {
            self.setDown(false);
        }
        if (heroY < self.y) {
            self.setUp(true);
            self.y--;
        }
        else {
            self.setUp(false);
        }

        checkCollision(self, map);

        if ((topLeft || topRight)&& self.isUp()) {
            self.y = tempY;
        }
        if ((bottomLeft || bottomRight) && self.isDown()) {
            self.y = tempY;
        }
        if ((topLeft || bottomLeft) && self.isLeft()) {
            self.x = tempX;
        }
        if ((topRight || bottomRight) && self.isRight()) {
            self.x = tempX;
        }

        if(self.getCollisionRect().intersects(target.getCollisionRect())) {
            target.hit(10);
        }

    }
}
