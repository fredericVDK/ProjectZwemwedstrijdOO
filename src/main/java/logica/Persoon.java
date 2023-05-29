package logica;

public class Persoon {
    private String naam;
    private String voornaam;
    private Adres adres;
    private int geboortejaar;
    private char geslacht;
    private String licentienummer;
    private String club;

    public Persoon(String naam, String voornaam, Adres adres, int geboortejaar, char geslacht, String licentienummer, String club) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.adres = adres;
        this.geboortejaar = geboortejaar;
        this.geslacht = geslacht;
        this.licentienummer = licentienummer;
        this.club = club;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public int getGeboortejaar() {
        return geboortejaar;
    }

    public void setGeboortejaar(int geboortejaar) {
        this.geboortejaar = geboortejaar;
    }

    public char getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(char geslacht) {
        this.geslacht = geslacht;
    }

    public String getLicentienummer() {
        return licentienummer;
    }

    public void setLicentienummer(String licentienummer) {
        this.licentienummer = licentienummer;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
