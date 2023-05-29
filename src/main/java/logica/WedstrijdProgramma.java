package logica;

import java.util.ArrayList;
import java.util.Date;

public class WedstrijdProgramma extends Wedstrijd{

    private int programmanummer;
    private Leeftijd leeftijdscategorie;
    private Date aanvangsuur;
    private ArrayList<Serie> series;
    private ArrayList<Programma> programmas;


    public WedstrijdProgramma(String naam, Tijdsregistratie tijdsregistratie, Dagdeel dagdeel, Date datum, int programmanummer, Leeftijd leeftijdscategorie, Date aanvangsuur, ArrayList<Serie> series, ArrayList<Programma> programmas) {
        super(naam, tijdsregistratie, dagdeel, datum);
        this.programmanummer = programmanummer;
        this.leeftijdscategorie = leeftijdscategorie;
        this.aanvangsuur = aanvangsuur;
        this.series = series;
        this.programmas = programmas;
    }

    public int getProgrammanummer() {
        return programmanummer;
    }

    public void setProgrammanummer(int programmanummer) {
        this.programmanummer = programmanummer;
    }

    public Leeftijd getLeeftijdscategorie() {
        return leeftijdscategorie;
    }

    public void setLeeftijdscategorie(Leeftijd leeftijdscategorie) {
        this.leeftijdscategorie = leeftijdscategorie;
    }

    public Date getAanvangsuur() {
        return aanvangsuur;
    }

    public void setAanvangsuur(Date aanvangsuur) {
        this.aanvangsuur = aanvangsuur;
    }

    public ArrayList<Serie> getSeries() {
        return series;
    }

    public void setSeries(ArrayList<Serie> series) {
        this.series = series;
    }

    public ArrayList<Programma> getProgrammas() {
        return programmas;
    }

    public void setProgrammas(ArrayList<Programma> programmas) {
        this.programmas = programmas;
    }
}
