import javalib.colors.Green;
import javalib.colors.Red;
import javalib.colors.Yellow;
import javalib.impworld.World;
import javalib.worldimages.OverlayImages;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import tester.*;

// examples of our Frogger classes and methods
public class Examples {
	FroggyWorld f1;
    Frog frog1;
    LaneMap laneMap1;
    Lily lily1;
    Log log1;
    Car car1;
    
    public void reset() {
    	this.f1 = new FroggyWorld();
    	this.frog1 = new Frog(1);
    	this.laneMap1 = new LaneMap();
    	this.lily1 = new Lily(1, 5);
    	this.log1 = new Log(2, -3);
    	this.car1 = new Car(3, 4);
    }
    
    //Draw methods
    public void testDraw(Tester t) {
    	this.reset();
    	t.checkExpect(this.frog1.draw(),
    			new OverlayImages(new OverlayImages(
    					new RectangleImage(new Posn(400, 567),
    							30, 30, new Yellow()),
        		new TextImage(new Posn(40, 20),
        				"Score: " + 0, new Red())),
        		new TextImage(new Posn(40, 40),
        				"Lives: " + 1, new Red())));
    	
    	t.checkExpect(this.lily1.draw(), new RectangleImage(
    			new Posn(0, 513), 50, 50, new Green()));
    	
    	t.checkExpect(this.log1.draw(), new RectangleImage(
    			new Posn(FroggyWorld.WIDTH, 459),
        		100, 50, new Green()));
    	
    	t.checkExpect(this.car1.draw(), new RectangleImage(
    			new Posn(0, 405), 60, 50, new Red()));
    	
    }
    
    //tick methods
    public void testTick(Tester t) {
    	
    }
    public void testOnTick(Tester t) {
    	
    }
    
    //move methods
    public void testMove(Tester t) {
    	
    }
    
    //frog restart
    public void testRestart(Tester t) {
    	
    }
    
    // collide methods
    public void testHasCollide(Tester t) {
    	
    }
    
    //hasDied method
    public void testHasDied(Tester t) {
    	
    }
    
    //onSpeed method
    public void testOnSpeed(Tester t) {
    	
    }
    
    //killOffScreeb method
    public void testKillOffScreen(Tester t) {
    	
    }
    
    //create methods
    public void testCreateLanes(Tester t) {
    	
    }
    public void testCreateLaneTickers(Tester t) {
    	
    }
    public void testCreateLaneSpeed(Tester t) {
    	
    }
    //generation methods
    public void testLogGen(Tester t) {
    	
    }
    public void testLilyGen(Tester t) {
    	
    }
    public void testCarGen(Tester t) {
    	
    }
    
}
