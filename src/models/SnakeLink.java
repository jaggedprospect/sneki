package models; 

public class SnakeLink extends Actor{

    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    //private int lastX, lastY;
    
    private State currentState;
    private State lastState;

    public enum State{
        IDLE,
        MOVING_UP,
        MOVING_DOWN,
        MOVING_LEFT,
        MOVING_RIGHT,
        DEAD
    };

    public SnakeLink(){
        super();

        currentState = State.IDLE;
        lastState = currentState;
    }

    public int getWidth(){
        return WIDTH;
    }

    public int getHeight(){
        return HEIGHT;
    }

    public State getCurrentState(){
        return currentState;
    }

    public State getLastState(){
        return lastState;
    }

    public void setCurrentState(State state){
        lastState = currentState;
        currentState = state;
    }
}