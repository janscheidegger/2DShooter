package ch.bfh.shooter.gameobjects.attackstyle;

import ch.bfh.shooter.Sprites.Map;
import ch.bfh.shooter.gameobjects.MovableGameObject;
import ch.bfh.shooter.helper.ShooterConstants;

import java.util.ArrayList;

/**
 * Created by jan on 28/11/14.
 */
public class SmarterAttack extends Attack {
    private ArrayList<Node> openNodes = new ArrayList<Node>();
    private ArrayList<Node> closedNodes = new ArrayList<Node>();


    public SmarterAttack(MovableGameObject self, Map map) {
        super(self, map);

    }

    @Override
    public void attack(MovableGameObject target) {
        aStar(self, target);

    }

    private void aStar(MovableGameObject self, MovableGameObject target) {
        openNodes.add(new Node((int)self.x/ShooterConstants.TILE_SIZE, (int)self.y/ShooterConstants.TILE_SIZE,0,0,0,null));
        addNeighbours(openNodes, (int)self.x/ShooterConstants.TILE_SIZE, (int)self.y/ShooterConstants.TILE_SIZE);
        
    }

    private void addNeighbours(ArrayList<Node> list, int xPos, int yPos) {
        if(checkPosition(xPos,yPos)) {
            //addNode()
        }
    }

    private boolean checkPosition(int x, int y) {
        if(x>=0 && y>=0 && map.getTileType(x,y) != Map.BLOCK) {
            return true;
        }
        return false;
    }


}
class Node {
    private int x;
    private int y;
    private double g;
    private double h;
    private double f;
    private Node parent;
    public Node(int x, int y, double g, double h, double f, Node parent) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.h = h;
        this.f = f;
        this.parent = parent;
    }
}
