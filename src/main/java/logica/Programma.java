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

    public Slag getSlag() {
        return slag;
    }

    public void setSlag(Slag slag) {
        this.slag = slag;
    }

    public Afstand getAfstand() {
        return afstand;
    }

    public void setAfstand(Afstand afstand) {
        this.afstand = afstand;
    }

    public boolean isAflossing() {
        return aflossing;
    }

    public void setAflossing(boolean aflossing) {
        this.aflossing = aflossing;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        this.geslacht = geslacht;
    }
}
