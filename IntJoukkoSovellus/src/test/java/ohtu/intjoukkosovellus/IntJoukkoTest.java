package ohtu.intjoukkosovellus;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoTest {

    IntJoukko joukko;

    @Before
    public void setUp() {
        joukko = new IntJoukko();
        joukko.lisaa(10);
        joukko.lisaa(3);
    }

    @Test
    public void lukujaLisattyMaara() {
        joukko.lisaa(4);
        assertEquals(3, joukko.koko());
    }

    @Test
    public void samaLukuMeneeJoukkoonVaanKerran() {
        joukko.lisaa(10);
        joukko.lisaa(3);
        assertEquals(2, joukko.koko());
    }

    @Test
    public void vainLisatytLuvutLoytyvat() {
        assertTrue(joukko.kuuluu(10));
        assertFalse(joukko.kuuluu(5));
        assertTrue(joukko.kuuluu(3));
    }

    @Test
    public void poistettuEiOleEnaaJoukossa() {
        joukko.poista(3);
        assertFalse(joukko.kuuluu(3));
        assertEquals(1, joukko.koko());
    }
        
    @Test
    public void toimiiKasvatuksenJalkeen(){
        int[] lisattavat = {1,2,4,5,6,7,8,9,11,12,13,14};
        for (int luku : lisattavat) {
            joukko.lisaa(luku);
        }
        assertEquals(14, joukko.koko());
        assertTrue(joukko.kuuluu(11));
        joukko.poista(11);
        assertFalse(joukko.kuuluu(11));
        assertEquals(13, joukko.koko());
    }
    
    @Test
    public void toStringToimii(){
        assertEquals("{10, 3}", joukko.toString());
    }
    
    @Test
    public void toStringToimiiSuuremmallaJoukollaLukuja(){
        joukko.lisaa(15);
        joukko.lisaa(40);

        assertEquals("{10, 3, 15, 40}", joukko.toString());
    }
    
    @Test
    public void toStringToimiiTyhjalle(){
        joukko = new IntJoukko();

        assertEquals("{}", joukko.toString());
    }
    
    @Test 
    public void equalsToimiiOikeinSamoille() {
        IntJoukko toinenJoukko = new IntJoukko();
        toinenJoukko.lisaa(10);
        toinenJoukko.lisaa(3);
        assertTrue(toinenJoukko.equals(joukko));
    }
    
    
    @Test 
    public void equalsToimiiOikeinErille() {
        IntJoukko toinenJoukko = new IntJoukko();
        toinenJoukko.lisaa(30);
        toinenJoukko.lisaa(3);
        assertFalse(toinenJoukko.equals(joukko));
    }
}
