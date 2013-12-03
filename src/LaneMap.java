import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javalib.colors.Red;
import javalib.worldimages.*;


public class LaneMap {
    HashMap<Integer, ArrayList<IObject>> lanes;
    HashMap<Integer, Integer> laneSpeed;
    HashMap<Integer, Integer> laneTickers;
    ArrayList<Integer> safeZones;
    int roadStart = 1; //inclusive
    int roadEnd = 5; //Exclusive
    Random rand = new Random();
    int carTicker = 0;
    int lilyTicker = 0;
    int logTicker = 0;
    
    /**
     * Constructor 
     * initiates lanes, laneSpeed and safeZones
     */
    LaneMap() {
    	this.lanes = new HashMap<Integer, ArrayList<IObject>>();
    	this.laneSpeed = new HashMap<Integer, Integer>();
    	this.laneTickers = new HashMap<Integer, Integer>();
    	this.safeZones = new ArrayList<Integer>();
    	this.safeZones.add(0);
    	this.safeZones.add(10);
    	this.safeZones.add(5);
    	this.createLaneSpeed();
    	this.createLanes();
    	this.createLaneTickers();
    }
    
    public void createLanes() {
        for (int i = 0; i < FroggyWorld.LANE_NUM; i++) {
            if (!this.safeZones.contains(i)) {
                this.lanes.put(i, new ArrayList<IObject>());
            }
        }
    }
    public void createLaneTickers() {
        for (int i = 0; i <= FroggyWorld.LANE_NUM; i++) {
            if (!this.safeZones.contains(i)) {
                this.laneTickers.put(i, 0);
            }
        }
    }
    public void createLaneSpeed() {
    	for (int i = 0; i <= FroggyWorld.LANE_NUM; i++) {
    		if (this.safeZones.contains(i)) {
    			this.laneSpeed.put(i, 0); //safe zones don't move
    		}
    		else {
    			int speed = rand.nextInt(10) + 2;
    			if (i % 2 == 0) { // if lane is even the speed is positive
    				this.laneSpeed.put(i, speed);
    			}
    			else { // otherwise speed is negative and object moves left
    				this.laneSpeed.put(i, speed - (2 * speed));
    			}
    		}
    		
    	}
    }
    
    
    public void move() {
        for(int i : this.lanes.keySet()) {
            for(IObject o: this.lanes.get(i)) {
            	o.move();
            }
        }
    }
    /**
     * does frog collide with anything?
     * @param lane int 
     * @param x int
     * @return true if frog collides with any objects
     */
    public boolean hasCollide(int lane, int x) {
    	for(IObject obj: this.lanes.get(lane)) {
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
    	if (this.hasCollide(lane, x)) {
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
        return this.laneSpeed.get(lane);
    }
    
    public WorldImage draw() {
    	int counter = 0; //how many objects returning images
    	// unimportant temp image
    	WorldImage temp = new RectangleImage(new Posn(-1000, -1000), 0, 0, new Red());
    	for(int i : this.lanes.keySet()) { // goes through each lane
            for(IObject o: this.lanes.get(i)) { // each object in array list
            	if (counter > 0) {
            		temp = new OverlayImages(temp, o.draw());
            		counter += 1;
            	}
            	else {
            		temp = o.draw();
            		counter += 1;
            	}
            }
        }
    	return temp;
    }
    
    /** checks the first item in each lane to see if its still on screen
     * if its not it is removed
     * only checking the first item ensures
     *  that items just added aren't destroyed
     */
    public void killOffScreen() {
    	for(int i : this.lanes.keySet()) {
            if (this.lanes.get(i).size() > 0 && !this.lanes.get(i).get(0).isVisible()) {
                ArrayList<IObject> temp = this.lanes.get(i);
                temp.remove(0);
            	this.lanes.put(i, temp);
            }
        }
    }
    public void generateNew() {
        for(int i : this.lanes.keySet()) {
            if (!this.safeZones.contains(i)) {
                if (i >= this.roadStart && i < this.roadEnd) {
                    this.carGen(i);
                }
                else {
                    if (i % 2 == 0) {
                        this.lilyGen(i);
                    }
                    else {
                        this.logGen(i);
                    }
                }
            }
        }
    }
    public void logGen(int lane) {
    	if (this.laneTickers.get(lane) == 0) {
			int speed = this.laneSpeed.get(lane);
			this.lanes.get(lane).add(new Log(lane, speed));
			this.laneTickers.put(lane, Log.logWidth / Math.abs(speed) + 15 + this.rand.nextInt(30));
		}
		else {
		    int temp = this.laneTickers.get(lane) - 1;
		    this.laneTickers.put(lane, temp);
		}
    }
    public void lilyGen(int lane) {
        if (this.laneTickers.get(lane) == 0) {
            int speed = this.laneSpeed.get(lane);
            this.lanes.get(lane).add(new Lily(lane, speed));
            this.laneTickers.put(lane, Lily.lilyWidth / Math.abs(speed) + 15 + this.rand.nextInt(30));
        }
        else {
            int temp = this.laneTickers.get(lane) - 1;
            this.laneTickers.put(lane, temp);
        }
    }
    public void carGen(int lane) {
        if (this.laneTickers.get(lane) == 0) {
            int speed = this.laneSpeed.get(lane);
            this.lanes.get(lane).add(new Car(lane, speed));
            this.laneTickers.put(lane, Car.carWidth / Math.abs(speed) + 15 + this.rand.nextInt(30));
        }
        else {
            int temp = this.laneTickers.get(lane) - 1;
            this.laneTickers.put(lane, temp);
        }
    }
    /**
     * general tick method to contain
     * killOffScreen(), generateNew(), and move()
     */
    public void tick() {
    	this.move();
    	this.generateNew();
    	this.killOffScreen();
    	
    }
}
