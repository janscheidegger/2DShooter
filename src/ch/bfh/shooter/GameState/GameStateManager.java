package ch.bfh.shooter.GameState;

import java.awt.*;
import java.util.Stack;

/**
 * Created by Jan on 28.10.2014.
 */
public class GameStateManager {

    private Stack<State> gameStates;


    public GameStateManager() {
        gameStates = new Stack<State>();

        gameStates.push(new MenuState(this));
    }

    public void push(GameState state) {
        gameStates.push(state);
    }

    public void pop() {
        gameStates.pop();
    }

    public void set(State state) {
        gameStates.pop();
        gameStates.push(state);
    }

    public void update() {
        gameStates.peek().update();
    }

    public void draw(Graphics2D g) {
        gameStates.peek().draw(g);
    }

    public void keyPressed(int k) {
        gameStates.peek().keyPressed(k);
    }

    public void keyReleased(int k) {
        gameStates.peek().keyReleased(k);
    }
}
