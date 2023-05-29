package logica;

import java.sql.Time;

public class Besttijden {
    private Time besttijd;

    public Besttijden(Time besttijd) {
        this.besttijd = besttijd;
    }

    public Time getBesttijd() {
        return besttijd;
    }

    public void setBesttijd(Time besttijd) {
        this.besttijd = besttijd;
    }
}
