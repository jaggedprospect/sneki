package main;

import controllers.GameController;

public class Main {
    
    private static GameController gameController;

    private static boolean isRunning = false;

    private static void startGame(){
        gameController = new GameController();
        isRunning = true;

        new Thread(new Runnable() {
            @Override
            public void run() {
                gameLoop();
            }
        }).start();
    }

    private static void gameLoop(){
        long lastTime = System.nanoTime();          // time since last iteration of gameLoop()
        double targetFPS = 30;                      // max FPS
        double ns = 1000000000 / targetFPS;         // number of nanoseconds per frame
        double delta = 0;                           // elapsed time since last frame
        int frames = 0;                             // elapsed frames since last FPS display
        double time = System.currentTimeMillis();   // current time - used for displaying FPS

        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if(delta >= 1){
                // get input & update game objects
                gameController.update();
                // render game objects
                gameController.getCurrentView().repaint();
                frames++;
                delta--;
                
                if(System.currentTimeMillis() - time >= 1000){
                    System.out.println("fps: " + frames);
                    time += 1000;
                    frames = 0;
                }
            }
        }
    }
    
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                startGame();
            }
        });
    }
}
