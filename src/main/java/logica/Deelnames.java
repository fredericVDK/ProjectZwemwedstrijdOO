package logica;

import java.sql.Time;

public class Deelnames {
    private int zwemmerId;
    private int serieId;
    private int baan;

    public Deelnames(int zwemmerId, int serieId, int baan) {
        this.zwemmerId = zwemmerId;
        this.serieId = serieId;
        this.baan = baan;
    }

    public int getZwemmerId() {
        return zwemmerId;
    }

    public void setZwemmerId(int zwemmerId) {
        this.zwemmerId = zwemmerId;
    }

    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }

    public int getBaan() {
        return baan;
    }

    public void setBaan(int baan) {
        this.baan = baan;
    }
}
