package views;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.GameController;

public class GameView extends JPanel{

    //private static final int WIDTH = 1600;
    //private static final int HEIGHT = 1600;

    private boolean isVisible; 
    private JLabel fpsLabel;

    private GameController gc;  // used to get game objects for rendering
    
    public GameView(boolean isVisible, GameController gc){
        this.isVisible = isVisible;
        fpsLabel = new JLabel();
        this.gc = gc;

        init();
    }

    private void init(){
        getPreferredSize();
        setBackground(new Color(135, 50, 60));
        setVisible(isVisible);

        fpsLabel.setForeground(Color.white);
        add(fpsLabel);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawSnake(g);

        // temp
        drawFPS();
    }

    public void drawSnake(Graphics g){
        g.setColor(new Color(40, 210, 85));
        g.fillRect(gc.getSnake().getX(), gc.getSnake().getY(),
            gc.getSnake().getWidth(), gc.getSnake().getHeight());
    }

    // temp
    public void drawFPS(){
        fpsLabel.setText("FPS: " + gc.fps);
    }
}
