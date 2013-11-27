import java.util.ArrayList;
import java.util.HashMap;

import javalib.worldimages.WorldImage;


public class LaneMap {
    HashMap<Integer, IObjectList> lanes;
    //HashMap<Integer, Integer> laneSpeed;
    ArrayList<Integer> safeZones;
    int roadStart = 1;
    int roadEnd = 5; //Exclusive
    
    /**
     * Constructor 
     * initiates lanes, laneSpeed and safeZones
     */
    LaneMap() {
    	this.safeZones.add(0);
    	this.safeZones.add(10);
    	this.safeZones.add(5);
    	/*
    	for (int i = 0; i <= FroggyWorld.LANE_NUM; i++) {
    		this.lanes.put(i, new ArrayList<IObject>());
    		this.laneSpeed.put(i, 0);
    	}
    	//*/
    }
    
    //as far as direction I assume we'll make it alternating so we can 
    //have a counter and have it mod 2 for object generation
    public void move() {
        for(int i : this.lanes.keySet()) {
            this.lanes.get(i).moveAll(0, FroggyWorld.WIDTH);
        }
    }
    /**
     * does frog collide with anything?
     * @param lane int 
     * @param x int
     * @return true if frog collides with any objects
     */
    public boolean hasCollide(int lane, int x) {
    	IObjectList temp = this.lanes.get(lane);
        for(IObject obj: temp.iObjects) {
    		if (obj.hasCollide(x)) {
    			return true;
    		}
    	}
    	//base case
    	return false;
    }
    
    /**
     * reports to tick method in world whether frog has died
     * @param lane
     * @param x
     * @return true if frog is in water or hit by car
     */
    public boolean hasDied(int lane, int x) {
    	//covers safe zones
    	if (this.safeZones.contains(lane)) {
    		return false;
    	}
    	// collision has occurred
    	if (hasCollide(lane, x)) {
    		//if frog is in road, collision means death
    		if (lane >= this.roadStart && lane < this.roadEnd) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//if not in safezone or road, no collision means the frog has drowned
    	return true;
    }
    
    /**
     * returns speed for frog to move if on movable object
     * @param lane
     * @return int at which frog should be moving
     */
    public int onSpeed(int lane) {
        //internal should be the same as hasCollide but return the objects speed instead
        return 0;
    }
    
    public WorldImage drawLane() {
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
    	this.generateNew();
    	this.killOffScreen();
    }
}
