package logica;


import java.util.Objects;

public class Adres {
    private String straat;
    private String huisnummer;
    private String gemeente;
    private int postcode;

    private int id;

    public Adres(String straat, String huisnummer, String gemeente, int postcode) {
        if (straat.equals("")) throw new IllegalArgumentException("Gelieve een straat in te vullen");
        if (huisnummer.equals("")) throw new IllegalArgumentException("Gelieve een Nummer in te vullen");
        if (gemeente.equals("")) throw new IllegalArgumentException("Gelieve een Gemeente in te vullen");
        if (postcode == 0) throw new IllegalArgumentException("Gelieve een postcode in te vullen");
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.gemeente = gemeente;
        this.postcode = postcode;

    }

    public Adres(String straat, String huisnummer, String gemeente, int postcode,int id) {
        if (straat.equals("")) throw new IllegalArgumentException("Gelieve een straat in te vullen");
        if (huisnummer.equals("")) throw new IllegalArgumentException("Gelieve een Nummer in te vullen");
        if (gemeente.equals("")) throw new IllegalArgumentException("Gelieve een Gemeente in te vullen");
        if (postcode == 0) throw new IllegalArgumentException("Gelieve een postcode in te vullen");
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.gemeente = gemeente;
        this.postcode = postcode;
        this.id = id;
    }
    public String getStraat() {
        return straat;
    }

    public int getId() {
        return id;
    }
    public String getHuisnummer() {
        return huisnummer;
    }
    public String getGemeente() {
        return gemeente;
    }
    public int getPostcode() {
        return postcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adres adres = (Adres) o;
        return postcode == adres.postcode && Objects.equals(straat, adres.straat) && Objects.equals(huisnummer, adres.huisnummer) && Objects.equals(gemeente, adres.gemeente);
    }

}
