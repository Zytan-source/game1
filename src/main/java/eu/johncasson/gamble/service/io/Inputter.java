package eu.johncasson.gamble.service.io;

import java.util.List;

import eu.johncasson.gamble.entities.PlayerCard;

public interface Inputter {

    /**
     * Selects a card with uses left
     */
    PlayerCard selectAvailableCard(List<PlayerCard> cards);

    /**
     * Selects any card
     */
    PlayerCard selectCard(List<PlayerCard> cards);

    void pause();

    boolean yesOrNo();

}