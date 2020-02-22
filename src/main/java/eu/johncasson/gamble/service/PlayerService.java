package eu.johncasson.gamble.service;

import java.util.List;

import eu.johncasson.gamble.entities.Player;
import eu.johncasson.gamble.entities.PlayerCard;

public class PlayerService {

	public Player setup() {
		Player p = new Player();

		p.cards.add(new PlayerCard(1, 1, 10));
		p.cards.add(new PlayerCard(2, 10, 3));
		p.cards.add(new PlayerCard(3, 4, 3));
		p.cards.add(new PlayerCard(5, 10, 3));
		
		return p;
	}

	public void resetCardUses(List<PlayerCard> cards) {
		for(PlayerCard c : cards) {
			c.uses = c.maxUses;
		}
	}

}
