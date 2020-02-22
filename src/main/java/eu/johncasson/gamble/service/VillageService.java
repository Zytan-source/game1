package eu.johncasson.gamble.service;

import eu.johncasson.gamble.config.Config;
import eu.johncasson.gamble.entities.Player;
import eu.johncasson.gamble.service.io.Inputter;
import eu.johncasson.gamble.service.io.VillageOutputter;

public class VillageService {
	
	VillageOutputter vos;
	Inputter input;
	PlayerService ps;
	
	public VillageService(VillageOutputter vos, Inputter input, PlayerService ps) {
        super();
        this.vos = vos;
        this.input = input;
        this.ps = ps;
    }

    public void visit(int matchCount, Player p, int targetGold) {
		if(villageJustUnlocked(matchCount)) {
			vos.welcome();
		}
		
		if(!villageUnlocked(matchCount)) {
			return; 
		}

		vos.shouldVisit(Config.REWARDS[matchCount]);
		boolean visit = input.yesOrNo();
		if(!visit) {
			return;
		}
		
		villageVisit(p, targetGold);
	}

	public void villageVisit(Player p, int targetGold) {
		boolean finished = false;
		
		vos.trekToVillage();
		ps.resetCardUses(p.cards);
		vos.cardsRecharged();
		p.multiplier = 1;
		
		vos.idol();
		if(p.gold >= targetGold) {
		    vos.win();
		    System.exit(0);
		} else {
		    vos.notEnoughGold(targetGold);
		}
		
		
		while(!finished) {
			vos.visiting();
			vos.readyForBattle();
			finished = input.yesOrNo();
		}
		
		vos.backToBattle();
	}

	private boolean villageJustUnlocked(int matchCount) {
		if(matchCount == Config.VILLAGE_UNLOCKED_AFTER) {
			return true;
		} else {
			return false;
		}
	}

	private boolean villageUnlocked(int matchCount) {
		if(matchCount>= Config.VILLAGE_UNLOCKED_AFTER) {
			return true;
		} else {
			return false;
		}
	}
}
