package eu.johncasson.gamble.service.io;

public interface VillageOutputter {

    void shouldVisit(int nextReward);

    void welcome();

    void visiting(int gold);

    void readyForBattle();

    void cardsRecharged();

    void backToBattle();

    void trekToVillage();

}