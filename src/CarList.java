import java.util.ArrayList;

import javalib.worldimages.WorldImage;


public class CarList extends IObjectList {
    // cars go right
    
    /**
     * The constructor
     */
    CarList(int x) {
        super(x);
    }
    
    /**
     * Adds specified number of Cars to this CarList's ArrayList
     * @param x
     */
    public void addObjects(int x) {
        for (int i = 0; i < x; i++) {
            this.iObjects.add(new Car());
        }
    }
    
    /**
     * Returns the row of Cars in image form
     */
    public WorldImage toImage() {
        return null;
    }
    
    /**
     * Checks whether any objects in this CarList are
     * at the end, and moves them if necessary
     */
    public void checkEnd(int left, int right) {
        int last = this.iObjects.size() - 1;
        if (this.iObjects.get(last).xPosn >= right) {
            this.iObjects.add(0, this.iObjects.remove(last));
            this.iObjects.get(0).xPosn = 0;
        }
    }
}