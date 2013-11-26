import javalib.impworld.World;
import tester.*;
public class Examples {
    public static void main(String[] args) {
        World frogger = new FroggyWorld();
        frogger.bigBang(800, 600, .1);
    }
}
