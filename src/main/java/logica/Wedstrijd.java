package logica;

import java.util.Date;

public class Wedstrijd {
    private int zwembad_id;
    private String naam;
    private Tijdsregistratie tijdsregistratie;
    private Dagdeel dagdeel;
    private Date datum;

    public Wedstrijd(String naam, Tijdsregistratie tijdsregistratie, Dagdeel dagdeel, Date datum) {
        if (naam.equals("")) throw new IllegalArgumentException("Gelieve een naam in te vullen");
        if (datum.equals("")) throw new IllegalArgumentException("Gelieve een geldige datum in te vullen");
        this.naam = naam;
        this.tijdsregistratie = tijdsregistratie;
        this.dagdeel = dagdeel;
        this.datum = datum;
    }

    public Wedstrijd(int zwembad_id, String naam, Tijdsregistratie tijdsregistratie, Dagdeel dagdeel, Date datum) {
        if (naam.equals("")) throw new IllegalArgumentException("Gelieve een naam in te vullen");
        if (datum.equals("")) throw new IllegalArgumentException("Gelieve een geldige datum in te vullen");
        this.zwembad_id = zwembad_id;
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

    public int getZwembad_id() {
        return zwembad_id;
    }

    public void setZwembad_id(int zwembad_id) {
        this.zwembad_id = zwembad_id;
    }
}
