package eu.johncasson.gamble.service.io;

import java.util.List;

import eu.johncasson.gamble.config.Config;
import eu.johncasson.gamble.entities.PlayerCard;
import eu.johncasson.gamble.service.CardService;

public class ConsoleMatchOutputter implements MatchOutputter {
	
	CardService cs = new CardService(new ConsoleInputter());

	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.MatchOutputter#gameOver()
     */
	@Override
    public void gameOver() {
		String str = String.format("Uh oh, you're out of cards :(");
		Util.print(str);
	}
	
	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.MatchOutputter#score(long)
     */
	@Override
    public void score(long score) {
		String str = String.format("Your new score: %d gold", score);
		Util.print(str);
	}

	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.MatchOutputter#nextRound(int)
     */
	@Override
    public void nextRound(int roundNum) {
		String str = String.format("Your opponent shows their %s card", cs.numToName(roundNum));
		Util.print(str);
		Util.pause(Config.DELAY);
	}

	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.MatchOutputter#finishEarlyBonus(long, java.util.List)
     */
	@Override
    public void finishEarlyBonus(long bonus, List<PlayerCard> cards) {
		String str = String.format("If you call it quits now, we'll give you a bonus %d gold.\n"
				+ "You have %d cards with %d uses left\n"
				+ "Want to cash out? Type YES. If not, press enter to continue ", 
				bonus, cards.size(), cards.stream().mapToInt(c -> c.uses).sum());
		Util.print(str);
	}

    @Override
    public void rechargeChard() {
        String str = "Congratulations on a precise hit! Choose a card to recharge: ";
        Util.print(str);
    }
}
