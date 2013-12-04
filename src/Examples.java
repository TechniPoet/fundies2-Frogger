import java.util.ArrayList;

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
    Lily lilyOff;
    Log log1;
    Car car1;
    ArrayList<IObject> lane6;
    ArrayList<IObject> lane1;
    
    public void reset() {
    	this.f1 = new FroggyWorld();
    	this.frog1 = new Frog(1);
    	this.laneMap1 = new LaneMap();
    	
    	this.lily1 = new Lily(1, 5);
    	this.lilyOff = new Lily(1, 5);
    	this.lilyOff.xPosn = FroggyWorld.WIDTH + 30;
    	this.log1 = new Log(2, -3);
    	this.car1 = new Car(3, 4);
    	
    	this.lane6 = new ArrayList<IObject>();
    	this.lane1 = new ArrayList<IObject>();
    	this.lane6.add(this.lily1);
    	this.lane6.add(this.lilyOff);
    	this.lane1.add(this.car1);
    	this.laneMap1.lanes.put(6, this.lane6);
    	this.laneMap1.lanes.put(1, this.lane1);
    }
    
    //Draw methods
    public void testDraw(Tester t) {
    	this.reset();
    	//frog
    	t.checkExpect(this.frog1.draw(),
    			new OverlayImages(new OverlayImages(
    					new RectangleImage(new Posn(400, 567),
    							30, 30, new Yellow()),
        		new TextImage(new Posn(40, 20),
        				"Score: " + 0, new Red())),
        		new TextImage(new Posn(40, 40),
        				"Lives: " + 1, new Red())));
    	//lily
    	t.checkExpect(this.lily1.draw(), new RectangleImage(
    			new Posn(0, 513), 50, 50, new Green()));
    	//log
    	t.checkExpect(this.log1.draw(), new RectangleImage(
    			new Posn(FroggyWorld.WIDTH, 459),
        		100, 50, new Green()));
    	//car
    	t.checkExpect(this.car1.draw(), new RectangleImage(
    			new Posn(0, 405), 60, 50, new Red()));
    	
    	//makeImage
    	
    }
    
    //tick methods
    public void testTick(Tester t) {
    	this.reset();
    	//frog
    	t.checkExpect(this.frog1.posnX, 400);
    	this.frog1.horizSpeed = 10;
    	this.frog1.tick();
    	t.checkExpect(this.frog1.posnX, 410);
    	//LaneMap
    	//TODO
    	
    	//t.checkExpect();
    	
    }
    public void testOnTick(Tester t) {
    	this.reset();
    }
    
    //move methods
    public void testMove(Tester t) {
    	this.reset();
    	
    	//IObject
    	t.checkExpect(this.lily1.xPosn, 0);
    	this.lily1.move();
    	t.checkExpect(this.lily1.xPosn, 5);
    	//laneMap
    	t.checkExpect(this.laneMap1.lanes.get(6).get(0).xPosn, 5);
    	this.laneMap1.move();
    	t.checkExpect(this.laneMap1.lanes.get(6).get(0).xPosn, 10);
    }
    
    //frog restart
    public void testRestart(Tester t) {
    	//True
    	this.reset();
    	t.checkExpect(this.frog1.lives, 1);
    	t.checkExpect(this.frog1.score, 0);
    	this.frog1.posnX = 100;
    	this.frog1.posnY = 100;
    	this.frog1.lane = 2;
    	this.frog1.horizSpeed = 10;
    	
    	this.frog1.restart(true);
    	t.checkExpect(this.frog1.lives, 0);
    	t.checkExpect(this.frog1.score, 0);
    	t.checkExpect(this.frog1.posnX, 400);
    	t.checkExpect(this.frog1.posnY, 567);
    	t.checkExpect(this.frog1.lane, 0);
    	t.checkExpect(this.frog1.horizSpeed, 0);
    	
    	//False
    	this.reset();
    	t.checkExpect(this.frog1.lives, 1);
    	t.checkExpect(this.frog1.score, 0);
    	this.frog1.posnX = 100;
    	this.frog1.posnY = 100;
    	this.frog1.lane = 2;
    	this.frog1.horizSpeed = 10;
    	
    	this.frog1.restart(false);
    	t.checkExpect(this.frog1.lives, 1);
    	t.checkExpect(this.frog1.score, 10);
    	t.checkExpect(this.frog1.posnX, 400);
    	t.checkExpect(this.frog1.posnY, 567);
    	t.checkExpect(this.frog1.lane, 0);
    	t.checkExpect(this.frog1.horizSpeed, 0);
    }
    
    // collide methods
    public void testHasCollide(Tester t) {
    	this.reset();
    	//IObject
    	t.checkExpect(this.car1.hasCollide(100), false);
    	t.checkExpect(this.car1.hasCollide(31), false);
    	t.checkExpect(this.car1.hasCollide(30), true);
    	t.checkExpect(this.car1.hasCollide(-30), true);
    	//LaneMap
    	t.checkExpect(this.laneMap1.hasCollide(6, 25), true);
    	t.checkExpect(this.laneMap1.hasCollide(6, -25), true);
    	t.checkExpect(this.laneMap1.hasCollide(6, 30), false);
    	t.checkExpect(this.laneMap1.hasCollide(2, 25), false);
    	
    }
    
    //hasDied method
    public void testHasDied(Tester t) {
    	this.reset();
    	//safeZones
    	t.checkExpect(this.laneMap1.hasDied(0, 30), false);
    	t.checkExpect(this.laneMap1.hasDied(5, 30), false);
    	t.checkExpect(this.laneMap1.hasDied(10, 30), false);
    	t.checkExpect(this.laneMap1.hasDied(10, 30), false);
    	
    	//road
    	t.checkExpect(this.laneMap1.hasDied(3, 30), false);
    	t.checkExpect(this.laneMap1.hasDied(1, 30), true);
    	//water
    	t.checkExpect(this.laneMap1.hasDied(7, 30), true);
    	t.checkExpect(this.laneMap1.hasDied(6, 25), false);
    	//t.checkExpect();
    }
    
    //onSpeed method
    public void testOnSpeed(Tester t) {
    	this.reset();
    	t.checkExpect(this.f1.laneMap.onSpeed(3),
    			this.f1.laneMap.laneSpeed.get(3));
    	t.checkExpect(this.f1.laneMap.onSpeed(7),
    			this.f1.laneMap.laneSpeed.get(7));
    	//t.checkExpect();
    }
    
    //killOffScreeb method
    public void testKillOffScreen(Tester t) {
    	this.reset();
    	//t.checkExpect();
    }
    
    //create methods
    public void testCreateLanes(Tester t) {
    	this.reset();
    	//t.checkExpect();
    }
    public void testCreateLaneTickers(Tester t) {
    	this.reset();
    	//t.checkExpect();
    }
    public void testCreateLaneSpeed(Tester t) {
    	this.reset();
    	//t.checkExpect();
    }
    //generation methods
    public void testLogGen(Tester t) {
    	this.reset();
    	//t.checkExpect();
    }
    public void testLilyGen(Tester t) {
    	this.reset();
    	//t.checkExpect();
    }
    public void testCarGen(Tester t) {
    	this.reset();
    	//t.checkExpect();
    }
    
}
