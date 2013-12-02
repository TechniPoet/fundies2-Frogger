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
    public WorldImage drawFrog() {
        return  new RectangleImage(new Posn(this.posnX, this.posnY), 30, 30, new Yellow());
    }

    public void move(String ke) {
        
    }
    
    public boolean restart(boolean b) {
        return b;
    }
}
