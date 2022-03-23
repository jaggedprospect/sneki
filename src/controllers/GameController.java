package controllers;

import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Input;
import models.*;
import models.SnakeLink.State;
import views.GameView;

// Controls models and views
public class GameController {

    private static final int X_SPEED = 3;
    private static final int Y_SPEED = 3;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    
    private JFrame frame;
    private HashMap<String, JPanel> views;
    private JPanel currentView;
    private Input input;

    private SnakeLink snake;

    public GameController(){
        frame = new JFrame();
        initUI();

        snake = new SnakeLink();
        
        // temp
        snake.setX(200);
        snake.setY(200);
    }

    private void initUI(){
        // init HashMap and create panels
        buildViews();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();

        // add panels to frame
        for(String key : views.keySet()){
            frame.add(views.get(key));
        }

        // temporary
        currentView = views.get("game");

        input = new Input();
        frame.addKeyListener(input);

        frame.pack();
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setLocationRelativeTo(null);
        frame.requestFocus();
        frame.setFocusable(true);
        frame.setVisible(true);
    }

    private void buildViews(){
        views = new HashMap<String, JPanel>();
        views.put("game", new GameView(true, this));
    }

    public JPanel getCurrentView(){
        return currentView;
    }

    public Input getInput(){
        return input;
    }

    public SnakeLink getSnake(){
        return snake;
    }

    public void moveX(int dX){
        snake.setX(snake.getX() + X_SPEED * dX);
    }

    public void moveY(int dY){
        snake.setY(snake.getY() + Y_SPEED * dY);
    }

    private void checkInput(){
        if(input.isKeyDown(KeyEvent.VK_UP) && snake.getCurrentState() != State.MOVING_DOWN){
            snake.setCurrentState(State.MOVING_UP);
            //moveY(-1);
        }else if(input.isKeyDown(KeyEvent.VK_DOWN) && snake.getCurrentState() != State.MOVING_UP){
            snake.setCurrentState(State.MOVING_DOWN);
            //moveY(1);
        }else if(input.isKeyDown(KeyEvent.VK_LEFT) && snake.getCurrentState() != State.MOVING_RIGHT){
            snake.setCurrentState(State.MOVING_LEFT);
            //moveX(-1);
        }else if(input.isKeyDown(KeyEvent.VK_RIGHT) && snake.getCurrentState() != State.MOVING_LEFT){
            snake.setCurrentState(State.MOVING_RIGHT);
            //moveX(1);
        }
    }

    private void moveSnake(){
        if(snake.getCurrentState() == State.MOVING_UP){
            moveY(-1);
        }else if(snake.getCurrentState() == State.MOVING_DOWN){
            moveY(1);
        }else if(snake.getCurrentState() == State.MOVING_LEFT){
            moveX(-1);
        }else if(snake.getCurrentState() == State.MOVING_RIGHT){
            moveX(1);
        }else if(snake.getCurrentState() == State.IDLE){
            // do nothing
        }else{
            System.err.println("[ERROR] invalid State - GameController.java, moveSnake()");
        }
    }

    public void update(){
        checkInput();
        input.update();
        moveSnake();
    }
}