package eu.johncasson.gamble.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import eu.johncasson.gamble.entities.MatchResult;
import eu.johncasson.gamble.entities.Player;
import eu.johncasson.gamble.service.io.GameOutputter;
import eu.johncasson.gamble.service.io.Inputter;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {
    
    @InjectMocks
    private GameService gameService;
    
    @Mock
    private GameOutputter outMock;
    
    @Mock
    private MatchService msMock;
        
    @Mock
    private VillageService vs;

    @Mock
    private Inputter inputter;
    
    /**
     * Multiplier increases after every match won
     */
    @Test
    public void multiplierIncrease() {
        // Given
        Player p = new Player();
        p.multiplier = 1;
        when(msMock.play(p,  1)).thenReturn(new MatchResult(true));
        
        // When
        gameService.play(p, new int[] {1});
        
        // Then
        assertEquals(2, p.multiplier);
    }
    
    @Test
    public void multiplierIncreaseTenMatches() {
        // Given
        // 10 Matches
        Player p = new Player();
        p.multiplier = 1;
        when(msMock.play(p,  1)).thenReturn(new MatchResult(true));
        
        // When
        gameService.play(p, new int[] {1,1,1,1,1,1,1,1,1,1});
        
        // Then
        assertEquals(11, p.multiplier);
    }
}
