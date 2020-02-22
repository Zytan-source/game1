package eu.johncasson.gamble.config;

public class Config {

	public static final int MAX_CPU_CARD_VALUE = 10;
	public static int DELAY = 500;
	
	// Rewards for each match
	public static final int[] REWARDS = {1,2,3,4,5,6,7,8,9,10};
	
	// Number of CPU cards in each match
	public static final int[] CARDS_PER_MATCH = {1,1,2,2,3,3,3,3,3,3};
	
	public static final String[] NUM_TO_NAME = { "first", "second", "third", "fourth", "fifth",
												  "sixth", "seventh", "eigth", "ninth", "tenth",
												  "eleventh", "twelfth", "thirteenth", "fourteenth",
												  "fifteenth"};
	
	public static final int VILLAGE_UNLOCKED_AFTER = 1;
}
