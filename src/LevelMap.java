import java.util.ArrayList;
import java.util.HashMap;

import javalib.worldimages.WorldImage;


public class LevelMap {
    HashMap<Integer, ArrayList<IObject>> levels;
    HashMap<Integer, Integer> levelSpeed;
    int dangerStart;
    int dangerEnd;
    //as far as direction I assume well make it alternating so we can 
    //have a counter and have it mod 2 for object generation
    public void move() {

    }
    /**
     * does frog collide with anything?
     * @param lane int 
     * @param x int
     * @return true if frog collides with any objects
     */
    public boolean hasCollide(int lane, int x) {
        return true;
    }
    //returns speed for frog to move if on movable object
    public int onSpeed() {
        //internal should be the same as hasCollide but return the objects speed instead
        return 0;
    }
    public WorldImage drawLevels() {
        return null;
    }
    public void killOffScreen() {

    }
    public void generateNew() {

    }
    /**
     * general tick method to contain
     * killOffScreen() and generateNew()
     */
    public void tick() {

    }
}
