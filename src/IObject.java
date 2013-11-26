import javalib.worldimages.WorldImage;

public abstract class IObject {
    int xPosn;
    int width;
    int height;
    int speed;
    String direction; 

    /**draws image of object
     * @return WorldImage of IObject
     */
    abstract WorldImage draw();
    /**
     * changes position along the x axis
     */
    void move() {
        if (this.direction.equals("r")) {
            this.xPosn += this.speed;
        }
        else {
            this.xPosn -= this.speed;
        }
    }
    /**
     * @return true if still on screen
     */
    boolean isVisible() {
        if (this.direction.equals("r")) {
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
        if(this.xPosn <= x && this.xPosn + this.width >= x) {
            return true;
        }
        else {
            return false;
        }
    }
}
