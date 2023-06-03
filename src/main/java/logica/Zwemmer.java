package logica;

import java.sql.Time;
import java.util.ArrayList;

public class Zwemmer extends Persoon {

    private int finapunten;
    private String besttijd;

    public Zwemmer(String naam, String voornaam, String besttijd) {
        super(naam, voornaam);
        this.besttijd = besttijd;
    }

    @Override
    public String toString() {
        return super.getNaam() + " " + super.getVoornaam() + " besttijd : " + besttijd + '\n';
    }
}
