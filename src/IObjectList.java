import java.util.ArrayList;
import javalib.worldimages.WorldImage;




// for a list of objects
public abstract class IObjectList {
    ArrayList<IObject> iObjects;
    
    /**
     * General Constructor
     */
    IObjectList(int x) {
        this.iObjects = new ArrayList<IObject>();
        this.addObjects(x);
    }
    
    /**
     * Adds all of the objects necessary for this IObjectList
     * @param x
     */
    public abstract void addObjects(int x);
    
    /**
     * Moves each object in this IObjectList's ArrayList
     */
    public void moveAll(int left, int right) {
        for(IObject o : this.iObjects) {
            o.move();
        }
        this.checkEnd(left, right);
    }
    
    /**
     * Checks whether any objects in this IObjectList are
     * at the end, and moves them if necessary
     */
    public abstract void checkEnd(int left, int right);
    
    /**
     * Returns the image form of this IObject
     */
    public abstract WorldImage toImage();
}