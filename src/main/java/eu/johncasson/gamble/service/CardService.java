package eu.johncasson.gamble.service;

import java.util.List;

import eu.johncasson.gamble.config.Config;
import eu.johncasson.gamble.entities.Player;
import eu.johncasson.gamble.entities.PlayerCard;
import eu.johncasson.gamble.service.io.CardOutputter;
import eu.johncasson.gamble.service.io.Inputter;

public class CardService {
    
    private Inputter in;
    private CardOutputter co;

	public CardService(Inputter consoleInputter, CardOutputter co) {
        super();
        this.in = consoleInputter;
        this.co = co;
    }

    public boolean movesLeft(List<PlayerCard> cards) {
		for(PlayerCard pc : cards) {
			if(pc.uses > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Convert number to name e.g. 2 = second, 3 = third etc
	 * @param num integer number to convert
	 * @return String string representation e.g. second, third
	 */
	public String numToName(int num) {
		return Config.NUM_TO_NAME[num - 1];
	}

	/**
	 * Allows the player to recharge a single card
	 */
    public void rechargeCard(Player p) {
        co.chooseCardToRecharge();
        PlayerCard card = in.selectCard(p.cards);
        card.uses = card.maxUses;
    }

}
