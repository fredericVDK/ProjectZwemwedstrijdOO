package logica;

public class Offiacial{

    private  int officalId;
    private Functie functie;
    private boolean kamprechter = false;
    private boolean jurysecretaris = false;
    private boolean starter = false;
    private boolean tak = false;


    public Offiacial(int officalId, boolean kamprechter, boolean jurysecretaris, boolean starter, boolean tak) {
        this.officalId = officalId;
        this.kamprechter = kamprechter;
        this.jurysecretaris = jurysecretaris;
        this.starter = starter;
        this.tak = tak;
    }
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
    public void setTak(boolean tak) {
        this.tak = tak;
    }
    @Override
    public String toString() {
        return "Official ID : " + officalId + '\t' + '\t' + "Functie : " + functie + '\n' ;
    }

}
