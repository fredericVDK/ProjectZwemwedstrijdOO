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

    public boolean isKamprechter() {
        return kamprechter;
    }

    public void setKamprechter(boolean kamprechter) {
        this.kamprechter = kamprechter;
    }

    public boolean isJurysecretaris() {
        return jurysecretaris;
    }

    public void setJurysecretaris(boolean jurysecretaris) {
        this.jurysecretaris = jurysecretaris;
    }

    public boolean isStarter() {
        return starter;
    }

    public void setStarter(boolean starter) {
        this.starter = starter;
    }

    public boolean isTak() {
        return tak;
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
