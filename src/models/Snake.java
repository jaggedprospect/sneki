package models;

import java.util.ArrayList;

public class Snake{

    private static final int INIT_LINK_COUNT = 3;   // number of SnakeLinks
    private static final int LINK_BUFFER = 5;       // distance between SnakeLinks

    private ArrayList<SnakeLink> links;
    private SnakeLink head;
    private SnakeLink tail;
    private SnakeState currentState;

    public enum SnakeState {
        SPLITTING,
        ALIVE,
        DEAD
    }
    
    public Snake(){
        buildLinks();
        head = links.get(0);
        tail = links.get(INIT_LINK_COUNT - 1);
        currentState = SnakeState.SPLITTING; 
    }

    private void buildLinks(){
        for(int i = 0; i < INIT_LINK_COUNT; i++){
            links.add(new SnakeLink());
        }
    }

    public ArrayList<SnakeLink> getLinks(){
        return links;
    }

    public SnakeLink getHead(){
        return head;
    }

    public SnakeLink getTail(){
        return tail;
    }
    
    public SnakeState getCurrentState(){
        return currentState;
    }
}
