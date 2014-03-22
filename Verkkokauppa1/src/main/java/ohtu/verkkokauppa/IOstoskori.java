package ohtu.verkkokauppa;

public interface IOstoskori {

    int hinta();

    void lisaa(Tuote t);

    void poista(Tuote t);

}
