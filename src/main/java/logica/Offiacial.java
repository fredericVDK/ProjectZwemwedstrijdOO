package logica;

public class Offiacial extends Persoon{

    private boolean kamprechter = false;
    private boolean jurysecretaris = false;
    private boolean starter = false;
    private boolean tak = false;

    public Offiacial(String naam, String voornaam, Adres adres, int geboortejaar, char geslacht, String licentienummer, String club, boolean kamprechter, boolean jurysecretaris, boolean starter, boolean tak) {
        super(naam, voornaam, adres, geboortejaar, geslacht, licentienummer, club);
        this.kamprechter = kamprechter;
        this.jurysecretaris = jurysecretaris;
        this.starter = starter;
        this.tak = tak;
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

    public void setTak(boolean tak) {
        this.tak = tak;
    }
}
