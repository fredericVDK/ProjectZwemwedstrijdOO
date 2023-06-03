package logica;


import java.util.Objects;

public class Zwembad {
    private int id;
    private int adresId;
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
    public Zwembad(int id, int adresId, String naam, Aantal_banen aantalBanen, Lengte lengte) {
        this.id = id;
        this.adresId = adresId;
        this.naam = naam;
        this.aantalBanen = aantalBanen;
        this.lengte = lengte;
    }

    public Zwembad(int id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }
    public Aantal_banen getAantalBanen() {
        return aantalBanen;
    }
    public Lengte getLengte() {
        return lengte;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zwembad zwembad = (Zwembad) o;
        return id == zwembad.id && adresId == zwembad.adresId && Objects.equals(naam, zwembad.naam) && Objects.equals(adres, zwembad.adres) && aantalBanen == zwembad.aantalBanen && lengte == zwembad.lengte;
    }

    @Override
    public String toString() {
        return id + ". " + naam;
    }
}
