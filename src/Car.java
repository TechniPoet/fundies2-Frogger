import javalib.colors.Black;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;


public class Car extends IObject {
    static int carWidth = 60;
    
    Car(int lane, int speed) {
    	super(lane, speed);
        this.width = this.carWidth;
        this.height = 50;
    }
    @Override
    WorldImage draw() {
    	return new RectangleImage(new Posn(this.xPosn, this.yPosn),
        		this.width, this.height, new Black());
    }

}
