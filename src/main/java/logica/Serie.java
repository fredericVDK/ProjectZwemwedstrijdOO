package logica;

import java.sql.Time;

public class Serie {
    private int wedstijdprogrammaId;

    private Time aanvangsuur;

    public Serie(int wedstijdprogrammaId, Time aanvangsuur) {
        this.wedstijdprogrammaId = wedstijdprogrammaId;
        this.aanvangsuur = aanvangsuur;
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
