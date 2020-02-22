package eu.johncasson.gamble.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import eu.johncasson.gamble.entities.Player;
import eu.johncasson.gamble.service.io.Inputter;
import eu.johncasson.gamble.service.io.VillageOutputter;

@RunWith(MockitoJUnitRunner.class)
public class VillageServiceTest {

    @InjectMocks
    private VillageServiceImpl vs;
    
    @Mock
    private Inputter inputterMock;
    
    @Mock
    private PlayerService playerServiceMock;
    
    @Mock
    private VillageOutputter voMock;
    
    @Test
    public void multiplierReset() {
        
        // Given
        Player p = new Player();
        p.multiplier = 11;
        when(inputterMock.yesOrNo()).thenReturn(true);
        
        // When
        vs.villageVisit(p);
        
        // Then
        assertEquals(1, p.multiplier);
    }
}
