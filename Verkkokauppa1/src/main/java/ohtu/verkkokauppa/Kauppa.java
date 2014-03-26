package ohtu.verkkokauppa;

public class Kauppa {

    private IVarasto varasto;
    private IPankki pankki;
    private IOstoskori ostoskori;
    private IViitegeneraattori viitegeneraattori;
    private String kaupanTili;

    public Kauppa(IVarasto var, IPankki pan, IViitegeneraattori vii) {
        varasto = var;
        pankki = pan;
        viitegeneraattori = vii;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

	// checkstyle-testausta
	public void rikotaanSaannot(int arvo1, int arvo2) {
		if (arvo1 > 0) {
			if (arvo2 > 5) {
				arvo2--;
				if (arvo2 < 7) {
					arvo2 *= 5;
				}
			}
			else {
				arvo2++;
			}
		}
		
		for (int i = 0; i < 10; ++i) {
			for (int i = 0; i < 5; ++j) {
				arvo1 += arvo2;
			}
		}
	}
	
	public int copyPaste(int arvo1, int arvo2) {
		if (arvo1 > 0) {
			if (arvo2 > 5) {
				arvo2--;
				if (arvo2 < 7) {
					arvo2 *= 5;
				}
			}
			else {
				arvo2++;
			}
		}
		
		return arvo1 + arvo2;
	}
	
	
	
	
}
