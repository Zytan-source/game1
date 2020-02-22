package eu.johncasson.gamble.service;

import eu.johncasson.gamble.config.Config;
import eu.johncasson.gamble.entities.Player;
import eu.johncasson.gamble.service.io.Inputter;
import eu.johncasson.gamble.service.io.VillageOutputter;

public class VillageServiceImpl implements VillageService {
	
	VillageOutputter vos;
	Inputter input;
	PlayerService ps;
	
	public VillageServiceImpl(VillageOutputter vos, Inputter input, PlayerService ps) {
        super();
        this.vos = vos;
        this.input = input;
        this.ps = ps;
    }

    /* (non-Javadoc)
     * @see eu.johncasson.gamble.service.VillageService#visit(int, eu.johncasson.gamble.entities.Player)
     */
	@Override
    public void visit(int matchCount, Player p) {
		if(villageJustUnlocked(matchCount)) {
			vos.welcome();
		}
		
		if(!villageUnlocked(matchCount)) {
			return; 
		}

		vos.shouldVisit();
		boolean visit = input.yesOrNo();
		if(!visit) {
			return;
		}
		
		villageVisit(p);
	}

	public void villageVisit(Player p) {
		boolean finished = false;
		
		vos.trekToVillage();
		ps.resetCardUses(p.cards);
		vos.cardsRecharged();
		p.multiplier = 1;
		
		while(!finished) {
			vos.visiting(p.gold);
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