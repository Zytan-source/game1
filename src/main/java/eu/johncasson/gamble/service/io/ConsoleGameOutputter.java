package eu.johncasson.gamble.service.io;

import eu.johncasson.gamble.config.Config;

public class ConsoleGameOutputter implements GameOutputter {

	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.GameOutputter#nextMatch(int)
     */
	@Override
    public void nextMatch(int matchNum) {
		String str = String.format("**************************************\n"
				+ "You come face to face with opponent %d\n"
				+ "**************************************\n", matchNum);
	
		Util.print(str);
		Util.pause(Config.DELAY * 3);
	}

	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.GameOutputter#beatOpponent(int, int)
     */
	@Override
    public void beatOpponent(int opponentNum, int reward, int multiplier) {
		String str = String.format("Nice one! Opponent %d is defeated. "
		        + "You get %d gold. "
		        + "Your next reward will be %d times bigger.", 
		        opponentNum, reward, multiplier);
		Util.print(str);
		Util.pause(Config.DELAY * 2); 
	}
	
	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.GameOutputter#lost(int)
     */
	@Override
    public void lost(int opponentNum) {
		String str = String.format("Uh oh. You've been beaten by opponent %d ", opponentNum);
		Util.print(str);
		Util.pause(Config.DELAY * 2); 
	}

	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.GameOutputter#gold(int)
     */
	@Override
    public void gold(int gold) {
		String str = String.format("You have %d gold\n", gold);
		Util.print(str);
	}
}
