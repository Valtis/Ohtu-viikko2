
package Komennot;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;


public class KomentoTehdas {
    public static Komento luo(KomentoTyyppi tyyppi, Sovelluslogiikka logiikka, JTextField muutosKentta) {
        int muutos;
        try {
            muutos = Integer.parseInt(muutosKentta.getText());
        } catch (Exception e) {
           muutos = 0;
        }
        
        switch (tyyppi) {
            case PLUS:
                if (muutos != 0) {
                    return new Plus(logiikka, muutos); 
                }
            break;
            case MIINUS:
                if (muutos != 0) {
                    return new Miinus(logiikka, muutos);
                }
            break;
            case NOLLAA:
                return new Nollaa(logiikka);
            default:
                throw new IllegalArgumentException("Tuntematon komentotyyppi");
        }
        
        return null;
    }
}
