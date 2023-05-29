package logica;



public class Zwembad {
    private String naam;
    private Adres adres;
    private Aantal_banen aantalBanen;
    private Lengte lengte;

    public Zwembad(String naam, Adres adres, Aantal_banen aantalBanen, Lengte lengte) {
        if (naam.equals("")) throw new IllegalArgumentException("Gelieve een naam in te vullen");
        if (adres == null) throw new IllegalArgumentException("Gelieve een straat in te vullen");
        this.naam = naam;
        this.adres = adres;
        this.aantalBanen = aantalBanen;
        this.lengte = lengte;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Aantal_banen getAantalBanen() {
        return aantalBanen;
    }

    public void setAantalBanen(Aantal_banen aantalBanen) {
        this.aantalBanen = aantalBanen;
    }

    public Lengte getLengte() {
        return lengte;
    }

    public void setLengte(Lengte lengte) {
        this.lengte = lengte;
    }
}
