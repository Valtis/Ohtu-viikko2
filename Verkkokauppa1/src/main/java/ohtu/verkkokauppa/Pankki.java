package ohtu.verkkokauppa;

public class Pankki implements IPankki {

    
    private IKirjanpito kirjanpito;

    public Pankki(IKirjanpito kir) {
        kirjanpito = kir;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
