package eu.johncasson.gamble.service;

import eu.johncasson.gamble.entities.Player;

public interface VillageService {

    public void visit(int matchCount, Player p);
    
    public void villageVisit(Player p);
}