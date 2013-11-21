import javalib.impworld.*;
import javalib.worldimages.WorldImage;
public class FroggyWorld extends World {
    Frog frog;
    LevelMap level;
    static int height = 800;
    static int width = 800;
    FroggyWorld(Frog frog, LevelMap level) {
        this.frog = frog;
        this.level = level;
    }

    /**
     * Checks for collisions
     */
    public void onTick() {
        //on tick methods
    }

    /**
     * creates images for game
     */
    public WorldImage makeImage() {
        // TODO Auto-generated method stub
        return null;
    }
    /**
     * processes key inputs
     * @param ke key input
     */
    public void onKey(String ke) {

    }

}
