package views;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import controllers.GameController;
import models.SnakeLink;

public class GameView extends JPanel{

    //private static final int WIDTH = 1600;
    //private static final int HEIGHT = 1600;

    private boolean isVisible; 

    private GameController gc;  // used to get game objects for rendering
    
    public GameView(boolean isVisible, GameController gc){
        this.isVisible = isVisible;
        this.gc = gc;

        init();
    }

    private void init(){
        getPreferredSize();
        setBackground(new Color(135, 50, 60));
        setVisible(isVisible);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawSnake(g);
    }

    public void drawSnake(Graphics g){
        SnakeLink snake = gc.getSnake();
        g.setColor(Color.GREEN);
        g.drawRect(snake.getX(), snake.getY(), snake.getWidth(), snake.getHeight());
    }

}
