package eu.johncasson.gamble;

import eu.johncasson.gamble.service.CardService;
import eu.johncasson.gamble.service.GameService;
import eu.johncasson.gamble.service.MatchService;
import eu.johncasson.gamble.service.PlayerService;
import eu.johncasson.gamble.service.RoundService;
import eu.johncasson.gamble.service.VillageService;
import eu.johncasson.gamble.service.io.CardOutputter;
import eu.johncasson.gamble.service.io.ConsoleCardOutputter;
import eu.johncasson.gamble.service.io.ConsoleGameOutputter;
import eu.johncasson.gamble.service.io.ConsoleInputter;
import eu.johncasson.gamble.service.io.ConsoleMatchOutputter;
import eu.johncasson.gamble.service.io.ConsoleRoundOutputter;
import eu.johncasson.gamble.service.io.ConsoleVillageOutputter;
import eu.johncasson.gamble.service.io.GameOutputter;
import eu.johncasson.gamble.service.io.Inputter;
import eu.johncasson.gamble.service.io.MatchOutputter;
import eu.johncasson.gamble.service.io.RoundOutputter;
import eu.johncasson.gamble.service.io.VillageOutputter;

public class GameFactory {
    public static GameService create() {

        Inputter in = new ConsoleInputter();
        
        GameOutputter out = new ConsoleGameOutputter();
        CardOutputter co = new ConsoleCardOutputter();
        VillageOutputter vos = new ConsoleVillageOutputter();
        RoundOutputter ro = new ConsoleRoundOutputter();
        
        PlayerService ps = new PlayerService();
        CardService cs = new CardService(in, co);
        MatchOutputter mo = new ConsoleMatchOutputter(cs);
        RoundService rs = new RoundService(co, ro, in, cs);
        MatchService ms = new MatchService(rs, cs, mo, co);        
        VillageService vs = new VillageService(vos, in, ps);
        
        return new GameService(out, ms, vs);
    }
}
