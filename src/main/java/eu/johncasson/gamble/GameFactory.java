package eu.johncasson.gamble;

import eu.johncasson.gamble.service.GameService;
import eu.johncasson.gamble.service.MatchService;
import eu.johncasson.gamble.service.MatchService;
import eu.johncasson.gamble.service.PlayerService;
import eu.johncasson.gamble.service.VillageService;
import eu.johncasson.gamble.service.VillageServiceImpl;
import eu.johncasson.gamble.service.io.ConsoleGameOutputter;
import eu.johncasson.gamble.service.io.ConsoleInputter;
import eu.johncasson.gamble.service.io.ConsoleVillageOutputter;
import eu.johncasson.gamble.service.io.GameOutputter;
import eu.johncasson.gamble.service.io.Inputter;
import eu.johncasson.gamble.service.io.VillageOutputter;

public class GameFactory {
    public static GameService create() {

        GameOutputter out = new ConsoleGameOutputter();
        MatchService ms = new MatchService();
        
        VillageOutputter vos = new ConsoleVillageOutputter();
        Inputter input = new ConsoleInputter();
        PlayerService ps = new PlayerService();
        
        VillageService vs = new VillageServiceImpl(vos, input, ps);
        
        
        return new GameService(out, ms, vs);
    }
}
