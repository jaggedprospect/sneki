package main;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Sneki {

    private static JFrame frame;

    private static void init(){
        // initialize panels
    }

    private static void startApp(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
        frame.pack();
        frame.setSize(new Dimension(400, 400));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                startApp();
            }
        });
    }
}
