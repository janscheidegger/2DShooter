package ch.bfh.shooter.gameobjects.attackstyle;

import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.gameobjects.MovableGameObject;
import ch.bfh.shooter.gameobjects.weapon.Pistol;
import ch.bfh.shooter.gameobjects.weapon.Shot;
import ch.bfh.shooter.gameobjects.weapon.Weapon;
import ch.bfh.shooter.helper.ShooterConstants;

import java.util.ArrayList;


/**
 * Created by jan on 14/11/14.
 */
public class ShootAttack extends StupidAttack {

    ArrayList<Shot> shots;
    Weapon weapon = new Pistol(self);

    public ShootAttack(MovableGameObject self, Map map, ArrayList<Shot> shots) {
        super(self,map);
        this.shots = shots;
    }


    @Override
    public void attack(MovableGameObject target) {

        if(Math.abs(self.x - target.x) < 10) {
            if(self.y > target.y) weapon.attack((int)self.x + ShooterConstants.ENEMY_WIDTH /2, (int)self.y + ShooterConstants.ENEMY_HEIGHT/2, shots, 0, self);
            if(self.y < target.y) weapon.attack((int)self.x + ShooterConstants.ENEMY_WIDTH /2, (int)self.y + ShooterConstants.ENEMY_HEIGHT/2, shots, 180, self);
        }
        else if(Math.abs(self.y - target.y) < 10) {
            if(self.x > target.x) weapon.attack((int)self.x + ShooterConstants.ENEMY_WIDTH /2, (int)self.y + ShooterConstants.ENEMY_HEIGHT/2, shots, 270, self);
            if(self.x < target.x) weapon.attack((int)self.x + ShooterConstants.ENEMY_WIDTH /2, (int)self.y + ShooterConstants.ENEMY_HEIGHT/2, shots, 90, self);
        }
        else {
            super.attack(target);
        }
        weapon.lowerCooldown();
        
    }

}
