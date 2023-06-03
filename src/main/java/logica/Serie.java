package logica;

import java.sql.Time;

public class Serie {
    private int id;
    private int wedstijdprogrammaId;

    private int reeksnummer;
    private Time aanvangsuur;

    public Serie(int wedstijdprogrammaId, Time aanvangsuur) {
        this.wedstijdprogrammaId = wedstijdprogrammaId;
        this.aanvangsuur = aanvangsuur;
    }

    public Serie(int id, int wedstijdprogrammaId, int reeksnummer, Time aanvangsuur) {
        this.id = id;
        this.wedstijdprogrammaId = wedstijdprogrammaId;
        this.reeksnummer = reeksnummer;
        this.aanvangsuur = aanvangsuur;
    }

    @Override
    public String toString() {
        return id + " . " + "wedstrijdProg :" + wedstijdprogrammaId + " reeksNr :" + reeksnummer + " tijd :" + aanvangsuur;
    }

    public int getWedstijdprogrammaId() {
        return wedstijdprogrammaId;
    }

    public void setWedstijdprogrammaId(int wedstijdprogrammaId) {
        this.wedstijdprogrammaId = wedstijdprogrammaId;
    }
    public Time getAanvangsuur() {
        return aanvangsuur;
    }

    public void setAanvangsuur(Time aanvangsuur) {
        this.aanvangsuur = aanvangsuur;
    }
}
