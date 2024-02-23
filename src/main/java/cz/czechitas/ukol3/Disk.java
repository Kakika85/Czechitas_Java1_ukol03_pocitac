package cz.czechitas.ukol3;

public class Disk {
    private long kapacita;
    private long vyuziteMisto;

    public Disk() {
        kapacita = 1*1024*1024*1024;
        vyuziteMisto = 1*1024*1024*1024;
    }
    public long getKapacita() {
        return kapacita;
    }
    public void setKapacita(long kapacita) {
        this.kapacita = kapacita;
    }

    public long getVyuziteMisto() {
        return vyuziteMisto;
    }

    public void setVyuziteMisto(long vyuziteMisto) {
        this.vyuziteMisto = vyuziteMisto;
    }
}
