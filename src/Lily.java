//Assignment 8
// Ginsparg, Jacob
// jgins
// Robbins, Jeff     
// robbinsj
import javalib.colors.Green;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;


public class Lily extends IObject {
	static int lilyWidth = 50;
	/*Template
	 * fields
	 * this.lilyWidth...			int
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
	Lily(int lane, int speed) {
		super(lane, speed);
		this.width = this.lilyWidth;
		this.height = 50;
	}

	/** returns image of lily **/
	WorldImage draw() {
		return new RectangleImage(new Posn(this.xPosn, this.yPosn),
				this.width, this.height, new Green());
	}
}
