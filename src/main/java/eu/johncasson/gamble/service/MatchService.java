package eu.johncasson.gamble.service;

import eu.johncasson.gamble.entities.MatchResult;
import eu.johncasson.gamble.entities.Player;
import eu.johncasson.gamble.entities.Round;
import eu.johncasson.gamble.entities.RoundResult;
import eu.johncasson.gamble.service.io.CardOutputter;
import eu.johncasson.gamble.service.io.MatchOutputter;

/**
 * Plays a match against the CPU. A match has many rounds, one for each CPU card.
 */
public class MatchService {
    
	private RoundService rs;
	private CardService cs;
	private MatchOutputter mos;
	private CardOutputter cardOut;
	
    public MatchService(RoundService rs, CardService cs, MatchOutputter mos, CardOutputter cardOut) {
        super();
        this.rs = rs;
        this.cs = cs;
        this.mos = mos;
        this.cardOut = cardOut;
    }

    public MatchResult play(Player p, int cpuCards) {
		int roundNum = 1;
		
		for(; cpuCards > 0; cpuCards--) {
			
			Round r = rs.createRound();
			mos.nextRound(roundNum, cpuCards);
			
			RoundResult rr = rs.play(r,  p);
			
			if(!rr.won) {
				mos.gameOver();
				return new MatchResult(false);
			} else {
				roundNum++;
			}
			
			if(rr.exactMatch) {
			    mos.rechargeChard();
			    cardOut.showPlayerCards(p.cards);
			    cs.rechargeCard(p);
			}
		}
		return new MatchResult(true);
	}
}
