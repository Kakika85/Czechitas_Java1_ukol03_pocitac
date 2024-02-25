package cz.czechitas.ukol3;

public class Disc2 {
    private long capacityOf2;
    private long useSite2;

    public long getCapacityOf2() {
        return capacityOf2;
    }

    public void setCapacityOf2(long capacityOf2) {
        this.capacityOf2 = capacityOf2;
    }

    public long getUseSite2() {
        return useSite2;
    }

    public void setUseSite2(long useSite2) {
        this.useSite2 = useSite2;
    }

    @Override
    public String toString() {
        return String.format("Informace o disku2: kapacita2 =%s bytů a využité místo je vyuziteMisto2 =%s bytů", capacityOf2, useSite2);
    }
}