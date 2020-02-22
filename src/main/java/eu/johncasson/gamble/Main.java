package eu.johncasson.gamble;

import eu.johncasson.gamble.config.Config;
import eu.johncasson.gamble.entities.Player;
import eu.johncasson.gamble.service.PlayerService;

/**
 * Overview
 * 
 * The GameFactory creates a GameService which starts the game using a Player 
 * created from the PlayerService. GameService starts the Matches 
 * and allows the user to visit the village.
 * 
 * The MatchService plays a match which is a series of rounds, run by the RoundService.
 * 
 * The Outputters and Inputters provide IO with the user.
 */
public class Main 
{
    public static void main( String[] args ) {
        Player p = new PlayerService().setup();
        GameFactory.create().play(p, Config.CARDS_PER_MATCH);
    }
}