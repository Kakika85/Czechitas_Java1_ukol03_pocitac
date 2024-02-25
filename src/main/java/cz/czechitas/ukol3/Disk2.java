package cz.czechitas.ukol3;

public class Disk2 {
    private long kapacita2;
    private long vyuziteMisto2;

    public long getKapacita2() {
        return kapacita2;
    }

    public void setKapacita2(long kapacita2) {
        this.kapacita2 = kapacita2;
    }

    public long getVyuziteMisto2() {
        return vyuziteMisto2;
    }

    public void setVyuziteMisto2(long vyuziteMisto2) {
        this.vyuziteMisto2 = vyuziteMisto2;
    }

    @Override
    public String toString() {
        return String.format("Informace o disku2: kapacita2 =%s bytů a využité místo je vyuziteMisto2 =%s bytů",
            kapacita2, vyuziteMisto2);
    }
}
