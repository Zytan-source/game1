package eu.johncasson.gamble.service.io;

import java.util.List;

import eu.johncasson.gamble.entities.PlayerCard;

public interface CardOutputter {

    public void showPlayerCards(List<PlayerCard> cards);
}
