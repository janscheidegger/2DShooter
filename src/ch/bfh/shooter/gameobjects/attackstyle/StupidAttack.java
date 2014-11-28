package ch.bfh.shooter.gameobjects.attackstyle;

import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.gameobjects.MovableGameObject;
import ch.bfh.shooter.helper.ShooterConstants;

/**
 * Created by jan on 07/11/14.
 */
public class StupidAttack extends Attack {
    private boolean topLeft;
    private boolean topRight;
    private boolean bottomLeft;
    private boolean bottomRight;
    private int attackDmg = 10;

    public StupidAttack(MovableGameObject self, Map map) {
        super(self, map);
    }


    @Override
    public void attack(MovableGameObject target) {

        self.setRight(target.getX() > self.x);
        self.setLeft(target.getX() < self.x);
        self.setDown(target.getY() > self.y);
        self.setUp(target.getY() < self.y);

        if(self.isLeft()) moveLeft(self, map);
        if(self.isRight()) moveRight(self, map);
        if(self.isUp()) moveUp(self, map);
        if(self.isDown()) moveDown(self, map);


        if(self.getCollisionRect().intersects(target.getCollisionRect())) {
            target.hit(attackDmg);
        }

    }

    private void moveDown(MovableGameObject self, Map map) {
        float tempY = self.y;
        self.y +=self.getSpeed();
        checkCollision(self, map);
        if(bottomRight || bottomLeft) self.y = tempY;
    }

    private void moveUp(MovableGameObject self, Map map) {
        float tempY = self.y;
        self.y -=self.getSpeed();
        checkCollision(self, map);
        if(topLeft || topRight) self.y = tempY;
    }

    private void moveRight(MovableGameObject self, Map map) {
        float tempX = self.x;
        self.x +=self.getSpeed();
        checkCollision(self, map);
        if(bottomLeft || bottomRight) self.x = tempX;
    }

    private void moveLeft(MovableGameObject self, Map map) {
        float tempX = self.x;
        self.x -=self.getSpeed();
        checkCollision(self, map);
        if(topLeft || bottomLeft) self.x = tempX;
    }

    private void checkCollision(MovableGameObject self, Map map) {
        topLeft = map.getTileType((int)self.x/ ShooterConstants.TILE_SIZE, (int)self.y/ShooterConstants.TILE_SIZE) == Map.BLOCK;
        topRight = map.getTileType(((int)self.x+ShooterConstants.ENEMY_WIDTH)/ShooterConstants.TILE_SIZE, (int)self.y/ShooterConstants.TILE_SIZE) ==Map.BLOCK;
        bottomLeft = map.getTileType((int)self.x/ShooterConstants.TILE_SIZE, ((int)self.y+ShooterConstants.ENEMY_HEIGHT)/ShooterConstants.TILE_SIZE)==Map.BLOCK;
        bottomRight = map.getTileType(((int)self.x+ShooterConstants.ENEMY_WIDTH)/ShooterConstants.TILE_SIZE, ((int)self.y+ShooterConstants.ENEMY_HEIGHT)/ShooterConstants.TILE_SIZE) ==Map.BLOCK;
    }


}
