package ch.bfh.shooter.gameobjects.attackstyle;

import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.gameobjects.MovableGameObject;
import ch.bfh.shooter.helper.ShooterConstants;

import java.util.ArrayList;

/**
 * Created by jan on 28/11/14.
 */
public class SmarterAttack extends Attack {

    private enum Directions {
        left(0), right(1), up(2), down(3);

        private int num;
        Directions(int num) {
            this.num = num;
        }
        public int getNum() {
            return num;
        }

        public String getName() {
            return name();
        }
    }

    private int[] directionPriorities = new int[4];
    int searchRadius = 50;


    public SmarterAttack(MovableGameObject self, Map map) {
        super(self, map);

    }

    @Override
    public void attack(MovableGameObject target) {
        resetPriorities();
        checkObstacles();
        searchPlayer(target);

        move();

        debugPriorities();
    }

    private void move() {
//        if()
    }

    private void searchPlayer(MovableGameObject target) {
        if(target.getX() > self.x) directionPriorities[Directions.right.getNum()] = 2;
        if(target.getX() < self.x) directionPriorities[Directions.left.getNum()] = 2;
        if (target.getY() > self.y) directionPriorities[Directions.down.getNum()] = 2;
        if (target.getY() < self.y) directionPriorities[Directions.up.getNum()] = 2;
    }

    private void checkObstacles() {
        for(int i = 0; i <= searchRadius; i++) {
            if(directionPriorities[Directions.left.getNum()] > 0 && map.getTileType((int)(self.getX() - i)/ShooterConstants.TILE_SIZE, (int)self.getY()/ShooterConstants.TILE_SIZE) == Map.BLOCK)
                directionPriorities[Directions.left.getNum()] = 0;
            if(directionPriorities[Directions.right.getNum()] > 0 && map.getTileType((int)(self.getX() + i)/ShooterConstants.TILE_SIZE, (int)self.getY()/ShooterConstants.TILE_SIZE) == Map.BLOCK)
                directionPriorities[Directions.right.getNum()] = 0;
            if(directionPriorities[Directions.up.getNum()] > 0 && map.getTileType((int)self.getX()/ShooterConstants.TILE_SIZE, (int)(self.getY() - i)/ShooterConstants.TILE_SIZE) == Map.BLOCK)
                directionPriorities[Directions.up.getNum()] = 0;
            if(directionPriorities[Directions.down.getNum()] > 0 && map.getTileType((int)self.getX()/ShooterConstants.TILE_SIZE, (int)(self.getY() + i)/ShooterConstants.TILE_SIZE) == Map.BLOCK)
                directionPriorities[Directions.down.getNum()] = 0;
        }
    }

    private void resetPriorities() {
        for (int i = 0; i < directionPriorities.length; i++) {
            directionPriorities[i] = 1;
        }
    }

    private void debugPriorities() {
       for(int dir : directionPriorities) {
           System.out.println(dir);
       }
    }


}
