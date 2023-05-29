package logica;

import java.util.Date;

public class Wedstrijd {
    private String naam;
    private Tijdsregistratie tijdsregistratie;
    private Dagdeel dagdeel;
    private Date datum;

    public Wedstrijd(String naam, Tijdsregistratie tijdsregistratie, Dagdeel dagdeel, Date datum) {
        this.naam = naam;
        this.tijdsregistratie = tijdsregistratie;
        this.dagdeel = dagdeel;
        this.datum = datum;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Tijdsregistratie getTijdsregistratie() {
        return tijdsregistratie;
    }

    public void setTijdsregistratie(Tijdsregistratie tijdsregistratie) {
        this.tijdsregistratie = tijdsregistratie;
    }

    public Dagdeel getDagdeel() {
        return dagdeel;
    }

    public void setDagdeel(Dagdeel dagdeel) {
        this.dagdeel = dagdeel;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
