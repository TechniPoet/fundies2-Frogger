//Assignment 8
// Ginsparg, Jacob
// jgins
// Robbins, Jeff     
// robbinsj
import javalib.impworld.World;


public class GameRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		World frogger = new FroggyWorld();
		frogger.bigBang(800, 600, .1);
	}

}
