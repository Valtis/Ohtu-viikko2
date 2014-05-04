package ohtu.intjoukkosovellus;

import java.util.LinkedHashSet;
import java.util.Set;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    private Set<Integer> luvut;

    public IntJoukko() {
        luvut = new LinkedHashSet<Integer>();

        ljono = new int[KAPASITEETTI];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public boolean lisaa(int luku) {
        return luvut.add(luku);
    }

    public boolean kuuluu(int luku) {
        return luvut.contains(luku);
    }

    public boolean poista(int luku) {
        return luvut.remove(luku);
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int koko() {
        return luvut.size();
    }

    @Override
    public String toString() {

        StringBuilder rakentaja = new StringBuilder();
        rakentaja.append("{");

        for (int luku : luvut) {
            rakentaja.append(luku);
            rakentaja.append(", ");
        }

        rakentaja.delete(rakentaja.length() - 2, rakentaja.length());
        rakentaja.append("}");

        return rakentaja.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        IntJoukko toinenJoukko = (IntJoukko) o;
        return toinenJoukko.luvut.equals(this.luvut);
    }

    public int[] toIntArray() {
        int[] arr = new int[luvut.size()];
        int paikka = 0;
        for (int luku : luvut) {
            arr[paikka++] = luku;
        }
        return arr;
    }

    public static IntJoukko yhdiste(IntJoukko ensimmainen, IntJoukko toinen) {
        IntJoukko uusi = new IntJoukko();
        uusi.luvut.addAll(ensimmainen.luvut);
        uusi.luvut.addAll(toinen.luvut);
        return uusi;
    }

    public static IntJoukko leikkaus(IntJoukko ensimmainen, IntJoukko toinen) {
        return leikkausErotusApuri(ensimmainen, toinen, true);
    }

    public static IntJoukko erotus(IntJoukko ensimmainen, IntJoukko toinen) {
        return leikkausErotusApuri(ensimmainen, toinen, false);
    }

    private static IntJoukko leikkausErotusApuri(IntJoukko ensimmainen, IntJoukko toinen, boolean onLeikkaus) {
        IntJoukko uusi = new IntJoukko();
        for (int luku : ensimmainen.luvut) {
            if (toinen.kuuluu(luku) == onLeikkaus) {
                uusi.lisaa(luku);
            }
        }
        return uusi;
    }

}
