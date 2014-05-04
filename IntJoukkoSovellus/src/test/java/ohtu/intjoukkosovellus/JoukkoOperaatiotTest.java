
package ohtu.intjoukkosovellus;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JoukkoOperaatiotTest {
    
    
    @Test
    public void yhdisteToimii() {
        IntJoukko eka = teeJoukko(1,2);
        IntJoukko toka = teeJoukko(3,4);
        
        IntJoukko tulos = IntJoukko.yhdiste(eka, toka);
        
        assertEquals(teeJoukko(1, 2, 3, 4), tulos);        
    } 
    
    @Test
    public void yhdisteessaEiDuplikaatteja() {
        IntJoukko eka = teeJoukko(1,2, 3);
        IntJoukko toka = teeJoukko(3,4);
        
        IntJoukko tulos = IntJoukko.yhdiste(eka, toka);
        
        assertEquals(teeJoukko(1, 2, 3, 4), tulos);       
    } 
    
    @Test
    public void leikkausToimii() {
        IntJoukko eka = teeJoukko(1,2,3, 4, 5, 6);
        IntJoukko toka = teeJoukko(3,4,9, 10);
        
        IntJoukko tulos = IntJoukko.leikkaus(eka, toka);
        
        assertEquals(teeJoukko(3, 4), tulos);        
    } 

    private IntJoukko teeJoukko(int... luvut) {
        IntJoukko joukko = new IntJoukko();
        
        for (int luku : luvut) {
            joukko.lisaa(luku);
        }
        
        return joukko;
    }
}
