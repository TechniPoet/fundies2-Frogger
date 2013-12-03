import javalib.worldimages.WorldImage;

public abstract class IObject {
    int xPosn;
    int yPosn;
    int width;
    int height;
    int speed;

    /**
     * The constructor for this class
     */
    IObject(int lane, int speed) {
        this.yPosn = ((FroggyWorld.LANE_NUM - lane) * FroggyWorld.levelHeight) - (FroggyWorld.levelHeight / 2);
        this.speed = speed;
        if (speed < 0) {
        	this.xPosn = FroggyWorld.WIDTH;
        }
        else {
        	this.xPosn = 0;
        }
    }
    
    /**draws image of object
     * @return WorldImage of IObject
     */
    abstract WorldImage draw();
    
    /**
     * changes position along the x axis
     */
    void move() {
        this.xPosn += this.speed;
    }
    
    /**
     * @return true if still on screen
     */
    boolean isVisible() {
        if (this.speed > 0) {
            if (this.xPosn > FroggyWorld.WIDTH) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            if (this.xPosn + this.width < 0) {
                return false;
            }
            else {
                return true;
            }
        }

    }
    
    /**
     * @param x posn
     * @return true if int x is in objects range
     */
    boolean hasCollide(int x) {
        if(this.xPosn - (this.width / 2) <= x && this.xPosn + (this.width / 2) >= x) {
            return true;
        }
        else {
            return false;
        }
    }
}
