package logica;

import java.sql.Time;

public class Serie {
    private int reeksnummer;
    private Time aanvangsuur;

    public Serie(int reeksnummer, Time aanvangsuur) {
        this.reeksnummer = reeksnummer;
        this.aanvangsuur = aanvangsuur;
    }

    public int getReeksnummer() {
        return reeksnummer;
    }

    public void setReeksnummer(int reeksnummer) {
        this.reeksnummer = reeksnummer;
    }

    public Time getAanvangsuur() {
        return aanvangsuur;
    }

    public void setAanvangsuur(Time aanvangsuur) {
        this.aanvangsuur = aanvangsuur;
    }
}
