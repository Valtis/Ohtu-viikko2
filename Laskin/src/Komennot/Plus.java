
package Komennot;

import ohtu.Sovelluslogiikka;


public class Plus extends AritmeettinenKomento {

    protected Plus(Sovelluslogiikka l, int muutos) {
        super(l, muutos);
    }

    @Override
    protected void suoritusImpl(int muutos) {
        logiikka.plus(muutos);
    }
    
    @Override
    protected void peruImpl(int muutos) {
        logiikka.miinus(muutos);
    }
    
}
