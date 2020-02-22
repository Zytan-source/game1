package eu.johncasson.gamble.service.io;

public class ConsoleVillageOutputter implements VillageOutputter {

	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.VillageOutputter#shouldVisit()
     */
	@Override
    public void shouldVisit(int nextReward) {
	    String str = String.format("Will you trek back to the village?\n"
                + "If you visit the village you'll lose your multiplier.\n"
                + "Your next opponent has %d gold\n"
                + "Type yes or no: ", nextReward);
	    
		Util.print(str);
	}

	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.VillageOutputter#welcome()
     */
	@Override
    public void welcome() {
		Util.print("A nearby village has a place you can rest and recharge your cards.");
	}

	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.VillageOutputter#visiting(int)
     */
	@Override
    public void visiting(int gold) {
		String str = String.format("You are having a great time in the village\nYou have %d gold to spend", gold);
		Util.print(str);
		
	}

	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.VillageOutputter#readyForBattle()
     */
	@Override
    public void readyForBattle() {
		Util.print("Are you ready to return to battle?");
	}

	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.VillageOutputter#cardsRecharged()
     */
	@Override
    public void cardsRecharged() {
		Util.print("You arrive in the village and find a mysterious card charger.\n"
				+ "The card charger recharge your cards");
	}

	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.VillageOutputter#backToBattle()
     */
	@Override
    public void backToBattle() {
		Util.print("You leave the village and trek through the dense forest.\n");		
	}

	/* (non-Javadoc)
     * @see eu.johncasson.gamble.service.output.VillageOutputter#trekToVillage()
     */
	@Override
    public void trekToVillage() {
		Util.print("You trek through a dark, dense forest. On the other side you find the village");		
	}
}
