package ohtu;

import Komennot.Komento;
import Komennot.KomentoTehdas;
import Komennot.KomentoTyyppi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Tapahtumankuuntelija implements ActionListener {

    private final Map<JButton, KomentoTyyppi> komennot;

    private final JButton nollaa;
    private final JButton undo;
    private final JTextField tuloskentta;
    private final JTextField syotekentta;
    private final Sovelluslogiikka sovellus;
    private final Stack<Komento> suoritetutKomennot;
 
    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        komennot = new HashMap<JButton, KomentoTyyppi>();
        suoritetutKomennot = new Stack<Komento>();
      
        komennot.put(plus, KomentoTyyppi.PLUS);
        komennot.put(miinus, KomentoTyyppi.MIINUS);
        komennot.put(nollaa, KomentoTyyppi.NOLLAA);
        
        this.nollaa = nollaa;
        this.undo = undo;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = new Sovelluslogiikka();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        suoritaKomento(ae);
        paivitaKentat();
    }

    private void suoritaKomento(ActionEvent ae) {
        KomentoTyyppi tyyppi = komennot.get(ae.getSource());
        if (tyyppi != null) {
            Komento komento = KomentoTehdas.luo(tyyppi, sovellus, syotekentta);
            if (komento != null) {
                komento.suorita();
                suoritetutKomennot.push(komento);
            }
        } else {
            Komento k = suoritetutKomennot.pop();
            k.peru();
        }
    }

    private void paivitaKentat() {
        int laskunTulos = sovellus.tulos();
         
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        nollaa.setEnabled(laskunTulos != 0);
        undo.setEnabled(suoritetutKomennot.size() > 0);
    }
 
}