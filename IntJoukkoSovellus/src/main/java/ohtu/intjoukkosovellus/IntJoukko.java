package ohtu.intjoukkosovellus;

import java.util.LinkedHashSet;
import java.util.Set;

public class IntJoukko {

    private final Set<Integer> luvut;

    public IntJoukko() {
        luvut = new LinkedHashSet<Integer>();
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
