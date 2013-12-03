import java.awt.Color;
import java.util.ArrayList;

import javalib.colors.*;
import javalib.impworld.*;
import javalib.worldimages.*;

public class FroggyWorld extends World {
    Frog frog;
    LaneMap laneMap;
    final static int LANE_NUM = 11;
    final static int HEIGHT = 600;
    final static int WIDTH = 800;
    
    final static int levelHeight = FroggyWorld.HEIGHT/LANE_NUM;
    
    FroggyWorld() {
        this.frog = new Frog(3);
        this.laneMap = new LaneMap();
    }
    
    FroggyWorld(Frog frog, LaneMap laneMap) {
    	this();
    	this.frog = frog;
    	this.laneMap = laneMap;
    }

    /**
     * Checks for collisions
     */
    ///*
    public void onTick() {
    	this.laneMap.tick();
    	this.frog.tick();
    	
    	//checks if frog has reached the end
    	if (this.frog.lane >= LANE_NUM - 1) {
    		this.frog.restart(false);
    		return;
    	}
    	//if frog has died
        if (this.laneMap.hasDied(this.frog.lane, this.frog.posnX)) {
        	this.frog.restart(true);
        }
        else {
        	this.frog.horizSpeed = this.laneMap.onSpeed(this.frog.lane);
        }
        
    }
    //
    
    WorldImage goalImage = new RectangleImage(new Posn(this.WIDTH / 2, this.levelHeight / 2), this.WIDTH, this.levelHeight, new Green());
    WorldImage waterImage = new RectangleImage(new Posn(this.WIDTH / 2, this.levelHeight * 3), this.WIDTH, this.levelHeight * 4, new Blue());
    WorldImage midImage = new RectangleImage(new Posn(this.WIDTH / 2, this.levelHeight * 5 + (this.levelHeight / 2)), this.WIDTH, this.levelHeight, new Green());
    WorldImage roadImage = new RectangleImage(new Posn(this.WIDTH / 2, this.levelHeight * 8), this.WIDTH, this.levelHeight * 4, new Black());
    WorldImage startImage = new RectangleImage(new Posn(this.WIDTH / 2, this.levelHeight * 10 + (this.levelHeight / 2)), this.WIDTH, this.levelHeight, new Green());
    
    WorldImage test = new RectangleImage(new Posn(0, 0), this.WIDTH, this.HEIGHT, new Green());
    
    WorldImage background = new OverlayImages( this.startImage, 
            new OverlayImages( this.roadImage,
            new OverlayImages( this.midImage,
                    new OverlayImages(this.waterImage, this.goalImage))));
    /**
     * creates images for game
     */
    public WorldImage makeImage() {
        return new OverlayImages(new OverlayImages(this.background, this.laneMap.draw()), this.frog.draw());
    }
    /**
     * processes key inputs
     * if <code>x</code> is pressed game is ended
     * else arrow keys move frog
     * @param ke key input
     */
    public void onKeyEvent(String ke) {
    	if (ke.equals("x")) {
    		this.endOfWorld("Game Ended");
    	}
    	else {
    		this.frog.move(ke);
    	}
    }
    
    public WorldEnd worldEnds() {
    	if(this.frog.lives == 0) {
    		return new WorldEnd(true, this.lastImage());
    	}
    	else {
    		return new WorldEnd(false, this.makeImage());
    	}
    }
    public WorldImage lastImage() {
    	return new TextImage(new Posn(FroggyWorld.HEIGHT / 2, FroggyWorld.WIDTH / 2), "Your hippity hopping in a better place now", 
                    Color.red);
    }

}
