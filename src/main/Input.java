package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener{
    
    private final int NUM_KEYS=256; // for standard keyboard
    private boolean[] keys=new boolean[NUM_KEYS];
    private boolean[] keysLast=new boolean[NUM_KEYS];

    public Input(){}
    
    public boolean isKey(int keyCode){
        return keys[keyCode];
    }
    
    public boolean isKeyUp(int keyCode){
        return !keys[keyCode] && keysLast[keyCode];
    }
    
    public boolean isKeyDown(int keyCode){
        return keys[keyCode] && !keysLast[keyCode];
    }
    
    public void update(){ // called after each input
        for(int i=0;i<NUM_KEYS;i++){
            keysLast[i]=keys[i];
        }
    }

    // temp
    public boolean[] getKeys(){
        return keys;
    }

    @Override
    public void keyPressed(KeyEvent e){
        keys[e.getKeyCode()]=true;
        //System.out.println("Key pressed: " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()]=false;
        //System.out.println("Key released: " + e.getKeyCode());
    }
    
    @Override
    public void keyTyped(KeyEvent e){}
}