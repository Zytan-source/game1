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
            str = String.format("Card %d  %2d-%2d     Uses left  %2d/%2d", 
                    cardCount, pc.minValue, pc.maxValue, pc.uses, pc.maxUses);
            Util.print(str);
            cardCount++;
        }
    }

    @Override
    public void chooseCardToRecharge() {
        Util.print("Choose a card to recharge: ");
        
    }
}
