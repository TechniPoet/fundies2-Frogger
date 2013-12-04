//Assignment 8
// Ginsparg, Jacob
// jgins
// Robbins, Jeff     
// robbinsj
import javalib.colors.Green;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;


public class Log extends IObject {
	static int logWidth = 100;
	/*Template
     * fields
     * this.logWidth...			int
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
    Log(int lane, int speed) {
    	super(lane, speed);
        this.width = this.logWidth;
        this.height = 50;
    }
    
    @Override
    WorldImage draw() {
    	return new RectangleImage(new Posn(this.xPosn, this.yPosn),
        		this.width, this.height, new Green());
    }

}
