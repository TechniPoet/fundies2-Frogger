import javalib.worldimages.WorldImage;


public class LogList extends IObjectList {
    // logs go left
    
    /**
     * Constructor
     */
    LogList(int x) {
        super(x);
    }
    
    /**
     * Adds specified number of Cars to this CarList's ArrayList
     * @param x
     */
    public void addObjects(int x) {
        for (int i = 0; i < x; i++) {
            this.iObjects.add(new Log());
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
        if (this.iObjects.get(0).xPosn <= left) {
            this.iObjects.add(this.iObjects.remove(0));
            this.iObjects.get(last).xPosn = right;
        }
    }
}