package logica;

import java.sql.Time;

public class Deelnames {
    private int baan;
    private Time resultaat;
    private String uitsluitingscode;
    private boolean forfait;

    public Deelnames(int baan, Time resultaat, String uitsluitingscode, boolean forfait) {
        this.baan = baan;
        this.resultaat = resultaat;
        this.uitsluitingscode = uitsluitingscode;
        this.forfait = forfait;
    }

    public int getBaan() {
        return baan;
    }

    public void setBaan(int baan) {
        this.baan = baan;
    }

    public Time getResultaat() {
        return resultaat;
    }

    public void setResultaat(Time resultaat) {
        this.resultaat = resultaat;
    }

    public String getUitsluitingscode() {
        return uitsluitingscode;
    }

    public void setUitsluitingscode(String uitsluitingscode) {
        this.uitsluitingscode = uitsluitingscode;
    }

    public boolean isForfait() {
        return forfait;
    }

    public void setForfait(boolean forfait) {
        this.forfait = forfait;
    }
}
