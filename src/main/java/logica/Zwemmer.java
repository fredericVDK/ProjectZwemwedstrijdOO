package logica;

import java.util.ArrayList;

public class Zwemmer extends Persoon {

    private int finapunten;
    private ArrayList<Deelnames> deelnames;
    private ArrayList<Besttijden> besttijden;

    public Zwemmer(String naam, String voornaam, Adres adres, int geboortejaar, char geslacht, String licentienummer, String club, int finapunten, ArrayList<Deelnames> deelnames, ArrayList<Besttijden> besttijden) {
        super(naam, voornaam, adres, geboortejaar, geslacht, licentienummer, club);
        this.finapunten = finapunten;
        this.deelnames = deelnames;
        this.besttijden = besttijden;
    }

    public int getFinapunten() {
        return finapunten;
    }

    public void setFinapunten(int finapunten) {
        this.finapunten = finapunten;
    }

    public ArrayList<Deelnames> getDeelnames() {
        return deelnames;
    }

    public void setDeelnames(ArrayList<Deelnames> deelnames) {
        this.deelnames = deelnames;
    }

    public ArrayList<Besttijden> getBesttijden() {
        return besttijden;
    }

    public void setBesttijden(ArrayList<Besttijden> besttijden) {
        this.besttijden = besttijden;
    }
}
