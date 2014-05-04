
package Komennot;

import ohtu.Sovelluslogiikka;


public abstract class AritmeettinenKomento implements Komento {
    private int arvo;
    private int muutos;
    protected final Sovelluslogiikka logiikka;
    
    protected AritmeettinenKomento(Sovelluslogiikka l, int muutos) {
        this.arvo = l.tulos();
        this.muutos = muutos;
        logiikka = l;
    }
    
    @Override
    public void suorita() {
        suoritusImpl(muutos);
        arvo = logiikka.tulos();
    }

    @Override
    public void peru() {
        peruImpl(muutos);
    }
    
    protected abstract void suoritusImpl(int muutos);
    protected abstract void peruImpl(int muutos);
}
