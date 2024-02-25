package cz.czechitas.ukol3;

public class Disc {
    private long capacityOf;
    private long useSite;

    public long getCapacityOf() {
        return capacityOf;
    }

    public void setCapacityOf(long capacityOf) {
        this.capacityOf = capacityOf;
    }

    public long getUseSite() {
        return useSite;
    }

    public void setUseSite(long useSite) {
        this.useSite = useSite;
    }

    @Override
    public String toString() {
        return String.format("Informace o disku: kapacita je kapacita=%s bytů a využité místo je vyuziteMisto=%s bytů", capacityOf, useSite);
    }
}