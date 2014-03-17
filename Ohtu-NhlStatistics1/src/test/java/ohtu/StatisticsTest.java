/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Erkka
 */
public class StatisticsTest {
    
    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    public StatisticsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void searchReturnsPlayer() {
        assertNotNull(stats.search("Kurri"));
    }
    
    @Test
    public void searchReturnsCorrectPlayer() {
        Player p = stats.search("Kurri");
        assertEquals("Kurri", p.getName());
    }
    
    @Test 
    public void searchReturnsNullWhenNoPlayerFound() {
        assertNull(stats.search("Selanne"));
    }
    
    @Test 
    public void teamReturnsCorrectNumberOfPlayerWhenTeamExists() {
        assertEquals(3, stats.team("EDM").size());
    }
    @Test 
    public void teamReturnsCorrectPlayers() {
        List<Player> players = stats.team("EDM");
        List<String> names = new ArrayList<String>();
        
        for (Player p : players) {
            names.add(p.getName());
        }
        
        assertTrue(names.contains("Semenko"));
        assertTrue(names.contains("Kurri"));
        assertTrue(names.contains("Gretzky"));
    }
    
    @Test 
    public void teamReturnsCorrectNumberOfPlayersWhenTeamDoesNotExist() {
        assertEquals(0, stats.team("asdj").size());
    }
    
    
    
    @Test 
    public void topScorersReturnsCorrectNumberOfPlayers() {
        assertEquals(4, stats.topScorers(4).size());
    }
    
    @Test 
    public void topScorersReturnsPlayersInCorrectOrder() {
        List<Player> players = stats.topScorers(4);
        assertEquals("Gretzky", players.get(0).getName());
        assertEquals("Lemieux", players.get(1).getName());
        assertEquals("Yzerman", players.get(2).getName());
        assertEquals("Kurri", players.get(3).getName());
        assertEquals("Semenko", players.get(4).getName());
        
    }
}   
