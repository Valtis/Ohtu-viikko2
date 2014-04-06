
package ohtu.verkkokauppa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class KauppaTest {
    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa k;
    
    public KauppaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        when(viite.uusi()).thenReturn(42);

        varasto = mock(Varasto.class);
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.saldo(2)).thenReturn(10); 
        when(varasto.saldo(3)).thenReturn(0);
        
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "tomaatti", 3));
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "kallis porkkana", 15));
        
        k = new Kauppa(varasto, pankki, viite);   
    }
    
    @After
    public void tearDown() {
    }
    
    // kopiotu malliksi tehtävänannosta
    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaan() {

        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt()); 
        
    }
    
    
    /* aloitetaan asiointi, koriin lisätään tuote ,jota varastossa on ja 
    suoritetaan ostos (eli kutsutaan metodia kaupan tilimaksu()). varmistettava 
    että kutsutaan pankin metodia tilisiirto oikealla asiakkaalla, tilinumerolla 
    ja summalla  */
    
    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeallaParametreilla() {
        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);   
    }
    
    /* aloitetaan asiointi, koriin lisätään kaksi eri tuotetta, joita varastossa 
    on ja suoritetaan ostos. varmistettava että kutsutaan pankin metodia 
    tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla*/
    @Test
    public void ostoksenPaatyttyaKunOstetaanKaksiEriTuotettaPankinMetodiaTilisiirtoKutsutaanOikeallaParametreilla() {
        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");

        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 8);
    }
    
    /* aloitetaan asiointi, koriin lisätään kaksi samaa tuotetta jota on 
    varastossa tarpeeksi ja suoritetaan ostos. varmistettava että kutsutaan 
    pankin metodia tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla
    */
    
    @Test public void pankinMetodiaKutsutaanOikeillaParametreillaKunOstetaanKaksiSamaaTuotetta() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 10);
    }
     /* aloitetaan asiointi, koriin lisätään tuote jota on varastossa tarpeeksi 
    ja tuote joka on loppu ja suoritetaan ostos. varmistettava että kutsutaan 
    pankin metodia tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla */
    @Test
    public void tiliSiirtoOikeinKunOstetaanTuoteJotaOnJaTuoteJokaOnLoppu() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(3);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 5);
    }
    
    /*
        varmistettava, että metodin aloitaAsiointi kutsuminen nollaa edellisen 
        ostoksen tiedot (eli edellisen ostoksen hinta ei näy uuden ostoksen hinnassa), 
        katso tarvittaessa apua projektin MockitoDemo testeistä!
    */
    
    @Test
    public void aloitaAsiointiNollaaSaldon() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.aloitaAsiointi();
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto("pekka", 42, "12345", "33333-44455", 0);
    }
    /*
    varmistettava, että kauppa pyytää uuden viitenumeron jokaiselle 
    maksutapahtumalle, katso tarvittaessa apua projektin MockitoDemo testeistä!
    */
    
    @Test
    public void kauppaPyytaaJokaiselleTapahtumalleUuudenViitenumeron() {
        k.aloitaAsiointi();
        k.tilimaksu("pekka", "12345");
        verify(viite, times(1)).uusi();
        
        k.aloitaAsiointi();
        k.tilimaksu("pekka", "12345");
        verify(viite, times(2)).uusi();
        
        k.aloitaAsiointi();
        k.tilimaksu("pekka", "12345");
        verify(viite, times(3)).uusi();
        
        k.aloitaAsiointi();
        k.tilimaksu("pekka", "12345");
        verify(viite, times(4)).uusi();
    }
    
    @Test
    public void koristaPoistoKutsuuVarastonHaeTuoteMetodiaOikeallaParametrilla() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        
        k.poistaKorista(1);
        verify(varasto, times(2)).haeTuote(1);
    }
    
    @Test
    public void koristaPoistoKutsuuVarastonPalautaMetodiaOikeallaParametrilla() {
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.poistaKorista(1);
        Tuote t = varasto.haeTuote(1);
        verify(varasto).palautaVarastoon(t);
    }
}

    
