package models;

public class Actor {

    //private String imagePath;
    private int x, y;
    private boolean isActive;

    public Actor(){
        // temp
        isActive = true;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean isActive(){
        return isActive;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setActive(boolean state){
        isActive = state;
    }
}
