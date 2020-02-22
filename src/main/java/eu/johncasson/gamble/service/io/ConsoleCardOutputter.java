package eu.johncasson.gamble.service.io;

import java.util.List;

import eu.johncasson.gamble.entities.PlayerCard;

public class ConsoleCardOutputter implements CardOutputter {

    @Override
    public void showPlayerCards(List<PlayerCard> cards) {
        
        String str = String.format("You have %d cards", cards.size());
        Util.print(str);
        
        int cardCount = 1;
        for(PlayerCard pc : cards) {
            str = String.format("Card %d:%2d-%2d uses left: %d", cardCount, pc.minValue, pc.maxValue, pc.uses);
            Util.print(str);
            cardCount++;
        }
    }
}
