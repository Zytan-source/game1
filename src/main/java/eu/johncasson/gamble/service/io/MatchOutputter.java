package eu.johncasson.gamble.service.io;

import java.util.List;

import eu.johncasson.gamble.entities.PlayerCard;

public interface MatchOutputter {

    void gameOver();

    void score(long score);

    void nextRound(int roundNum);

    void finishEarlyBonus(long bonus, List<PlayerCard> cards);

    void rechargeChard();
}