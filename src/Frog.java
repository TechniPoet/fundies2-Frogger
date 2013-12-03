import javalib.colors.Yellow;
import javalib.worldimages.*;


public class Frog {
    int posnX;
    int lives;
    int score;
    int lane;
    int horizSpeed;
    int posnY; // only used for draw function
    
    /** Constructor that allows you to set lives **/
    Frog(int lives) {
        this.horizSpeed = 0;
        this.lives = lives;
        this.score = 0;
        this.lane = 0; // begins at bottom of screen
        this.posnX = FroggyWorld.WIDTH/2; //starts at the widths center
        this.posnY = ((FroggyWorld.LANE_NUM - this.lane) * FroggyWorld.levelHeight) - (FroggyWorld.levelHeight / 2);
    }
    
    /** returns the frogs image **/
    public WorldImage draw() {
        return  new RectangleImage(new Posn(this.posnX, this.posnY), 30, 30, new Yellow());
    }
    
    public void tick() {
    	this.posnX += this.horizSpeed;
    }

    public void move(String ke) {
    	System.out.println(ke);
        switch (ke) {
        case "up":
        	if (this.lane < FroggyWorld.LANE_NUM - 1) {
        		this.lane += 1;
        	}
        	break;
        case "down":
        	if (this.lane > 0) {
        		this.lane -= 1;
        	}
        	break;
        case "left":
        	if (this.posnX - 25 > 0) { //25 is half frog width plus move amount
        		this.posnX -= 10;
        	}
        	else {
        		this.posnX = 15; // otherwise place on left edge of screen
        	}
        	break;
        case "right":
        	if (this.posnX + 25 < FroggyWorld.WIDTH) {
        		this.posnX += 10;
        	}
        	else {
        		this.posnX = FroggyWorld.WIDTH - 15;
        	}
        	break;
        default:
        	break;
        }
        this.posnY = ((FroggyWorld.LANE_NUM - this.lane) * FroggyWorld.levelHeight) - (FroggyWorld.levelHeight / 2);
    }
    
    public void restart(boolean dead) {
        if (dead) {
        	lives -= 1;
        }
        else {
        	score += 10;
        }
        this.posnX = FroggyWorld.WIDTH / 2; //back to start
    	this.lane = 0;
    	this.posnY = ((FroggyWorld.LANE_NUM - this.lane) * FroggyWorld.levelHeight) - (FroggyWorld.levelHeight / 2);
    	this.horizSpeed = 0;
    }
}
