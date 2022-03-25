package controllers;

import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Input;
import models.*;
import models.SnakeLink.LinkState;
import models.Snake.SnakeState;
import views.GameView;

// Controls models and views
public class GameController {

    private static final int JUMP = 3;          // distance each SnakeLink moves on update
    private static final int WIDTH = 800;       // width of JFrame
    private static final int HEIGHT = 800;      // height of JFrame
    private static final int ORIGIN_X = 200;    // starting X position for Snake
    private static final int ORIGIN_Y = 200;    // starting Y position for Snake
    
    private JFrame frame;
    private HashMap<String, JPanel> views;
    private JPanel currentView;
    private Input input;

    private Snake snake;

    // temp
    public int fps;

    public GameController(){
        frame = new JFrame();
        initUI();

        snake = new Snake();
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

        // temp
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

    public Snake getSnake(){
        return snake;
    }

    private void checkInput(){
        if(input.isKeyDown(KeyEvent.VK_UP) && snake.getHead().getCurrentState() != LinkState.MOVING_DOWN){
            snake.getHead().setCurrentState(LinkState.MOVING_UP);
        }else if(input.isKeyDown(KeyEvent.VK_DOWN) && snake.getHead().getCurrentState() != LinkState.MOVING_UP){
            snake.getHead().setCurrentState(LinkState.MOVING_DOWN);
        }else if(input.isKeyDown(KeyEvent.VK_LEFT) && snake.getHead().getCurrentState() != LinkState.MOVING_RIGHT){
            snake.getHead().setCurrentState(LinkState.MOVING_LEFT);
        }else if(input.isKeyDown(KeyEvent.VK_RIGHT) && snake.getHead().getCurrentState() != LinkState.MOVING_LEFT){
            snake.getHead().setCurrentState(LinkState.MOVING_RIGHT);
        }
    }

    private void moveSnake(){

        if(snake.getCurrentState() == SnakeState.SPLITTING){

        }else{
            for(SnakeLink link : snake.getLinks()){
                switch(link.getCurrentState()){
                    case MOVING_UP:
                        break;
                    case MOVING_DOWN:
                        break;
                    case MOVING_LEFT:
                        break;
                    case MOVING_RIGHT:
                        break;
                    default:
                        System.err.println("[ERROR] invalid State - GameController.java, moveSnake()");
                }
            }
        }
    }

    public void update(){
        checkInput();
        input.update();
        moveSnake();
    }
}