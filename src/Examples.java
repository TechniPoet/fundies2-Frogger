import javalib.impworld.World;
import tester.*;

// examples of our Frogger classes and methods
public class Examples {
    public static void main(String[] args) {
    	Frog frog = new Frog(3);
        World frogger = new FroggyWorld(frog);
        frogger.bigBang(800, 600, .1);
    }
}
