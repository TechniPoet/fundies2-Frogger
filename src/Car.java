import javalib.colors.Red;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;


public class Car extends IObject {
    static int carWidth = 60;
    /*Template
     * fields
     * this.carWidth...			int
     * this.xPosn...			int
     * this.yPosn...			int
     * this.width...			int
     * this.height...			int
     * this.speed...			int
     * Methods
     * this.draw()...			WorldImage
     * this.move()...			void
     * this.isVisible()...		boolean
     * this.hasCollide(int x)	boolean
     */
    Car(int lane, int speed) {
    	super(lane, speed);
        this.width = this.carWidth;
        this.height = 50;
    }
    @Override
    WorldImage draw() {
    	return new RectangleImage(new Posn(this.xPosn, this.yPosn),
        		this.width, this.height, new Red());
    }

}
