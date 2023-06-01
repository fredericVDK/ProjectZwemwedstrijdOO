package logica;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class WedstrijdProgramma{

    private int wedstijdId;
    private int programmaId;
    private int programmanummer;
    private Leeftijd leeftijdscategorie;
    private Time aanvangsuur;
    private ArrayList<Serie> series;
    private ArrayList<Programma> programmas;


    public WedstrijdProgramma(int wedstijdId, int programmaId, int programmanummer, Leeftijd leeftijdscategorie, Time aanvangsuur) {
        this.wedstijdId = wedstijdId;
        this.programmaId = programmaId;
        this.programmanummer = programmanummer;
        this.leeftijdscategorie = leeftijdscategorie;
        this.aanvangsuur = aanvangsuur;
    }

    public int getWedstijdId() {
        return wedstijdId;
    }

    public int getProgrammaId() {
        return programmaId;
    }

    public int getProgrammanummer() {
        return programmanummer;
    }

    public Leeftijd getLeeftijdscategorie() {
        return leeftijdscategorie;
    }

    public Date getAanvangsuur() {
        return aanvangsuur;
    }

    public ArrayList<Serie> getSeries() {
        return series;
    }

    public ArrayList<Programma> getProgrammas() {
        return programmas;
    }
}
