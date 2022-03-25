package models;

import java.awt.Point;

import java.util.Queue;

public class SnakeLink extends Actor{

    private static final int WIDTH = 50;    // width of SnakeLink
    private static final int HEIGHT = 50;   // height of SnakeLink

    private Queue<Point> moves;
    
    private LinkState currentState;
    private LinkState lastState;

    public enum LinkState{
        IDLE,
        MOVING_UP,
        MOVING_DOWN,
        MOVING_LEFT,
        MOVING_RIGHT,
    };

    public SnakeLink(){
        super();

        currentState = LinkState.IDLE;
        lastState = currentState;
    }

    public int getWidth(){
        return WIDTH;
    }

    public int getHeight(){
        return HEIGHT;
    }

    public LinkState getCurrentState(){
        return currentState;
    }

    public LinkState getLastState(){
        return lastState;
    }

    public void setCurrentState(LinkState state){
        lastState = currentState;
        currentState = state;
    }
}