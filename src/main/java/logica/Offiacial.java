package logica;

public class Offiacial {

    private int officalId;
    private Functie functie;

    public Offiacial(int officalId, Functie functie) {
        this.officalId = officalId;
        this.functie = functie;
    }

    public int getOfficalId() {
        return officalId;
    }

    public Functie getFunctie() {
        return functie;
    }

    @Override
    public String toString() {
        return "Official ID : " + officalId + '\t' + '\t' + "Functie : " + functie + '\n';
    }

}
