import java.awt.Color;

import javalib.colors.*;
import javalib.impworld.*;
import javalib.worldimages.*;
import javalib.worldimages.WorldImage;
public class FroggyWorld extends World {
    Frog frog;
    LevelMap level;
    static int height = 600;
    static int width = 800;
    int levelHeight = FroggyWorld.height/11;
    FroggyWorld(Frog frog, LevelMap level) {
        this.frog = frog;
        this.level = level;
    }
    FroggyWorld() { 
        
    }

    /**
     * Checks for collisions
     */
    public void onTick() {
        //on tick methods
    }
    
    WorldImage goalImage = new RectangleImage(new Posn(this.width / 2, this.levelHeight / 2), this.width, this.levelHeight, new Green());
    WorldImage waterImage = new RectangleImage(new Posn(this.width / 2, this.levelHeight * 3), this.width, this.levelHeight * 4, new Blue());
    WorldImage midImage = new RectangleImage(new Posn(this.width / 2, this.levelHeight * 5 + (this.levelHeight / 2)), this.width, this.levelHeight, new Green());
    WorldImage roadImage = new RectangleImage(new Posn(this.width / 2, this.levelHeight * 8), this.width, this.levelHeight * 4, new Black());
    WorldImage startImage = new RectangleImage(new Posn(this.width / 2, this.levelHeight * 10 + (this.levelHeight / 2)), this.width, this.levelHeight, new Green());
    
    WorldImage test = new RectangleImage(new Posn(0, 0), this.width, this.height, new Green());
    
    WorldImage background = new OverlayImages( this.startImage, 
            new OverlayImages( this.roadImage,
            new OverlayImages( this.midImage,
                    new OverlayImages(this.waterImage, this.goalImage))));
    /**
     * creates images for game
     */
    public WorldImage makeImage() {
        return this.background;
    }
    /**
     * processes key inputs
     * @param ke key input
     */
    public void onKey(String ke) {

    }

}
