
package Komennot;

import ohtu.Sovelluslogiikka;


public class Nollaa implements Komento {
    private Sovelluslogiikka logiikka;
    private int vanhaArvo;
    
    protected Nollaa(Sovelluslogiikka l) {
        logiikka = l;
    }
    
    @Override
    public void suorita() {
        vanhaArvo = logiikka.tulos();
        logiikka.nollaa();
    }

    @Override
    public void peru() {
        logiikka.plus(vanhaArvo);
    }
    
}
