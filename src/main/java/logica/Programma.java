package logica;

public class Programma {
    private Slag slag;
    private Afstand afstand;
    private boolean aflossing;
    private Geslacht geslacht;

    public Programma(Slag slag, Afstand afstand, boolean aflossing, Geslacht geslacht) {
        this.slag = slag;
        this.afstand = afstand;
        this.aflossing = aflossing;
        this.geslacht = geslacht;
    }

    @Override
    public String toString() {
        return afstand.toString().replace("_","") + "m " + slag + " slag " + geslacht + " " + "Aflossing: " + aflossing;
    }
}
