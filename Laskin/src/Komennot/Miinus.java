
package Komennot;

import ohtu.Sovelluslogiikka;


public class Miinus extends AritmeettinenKomento {

    protected Miinus(Sovelluslogiikka l, int muutos) {
        super(l, muutos);
    }

    @Override
    protected void suoritusImpl(int muutos) {
        logiikka.miinus(muutos);
    }

    @Override
    protected void peruImpl(int muutos) {
        logiikka.plus(muutos);
    }
}
