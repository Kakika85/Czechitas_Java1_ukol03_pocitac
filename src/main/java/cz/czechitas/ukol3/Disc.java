package cz.czechitas.ukol3;

public class Disc {
    private long capacity;
    private long usedSize;

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(long useSite) {
        this.usedSize = useSite;
    }

    @Override
    public String toString() {
        return String.format("Informace o disku: kapacita je kapacita=%s bytů a využité místo je vyuziteMisto=%s bytů", capacity, usedSize);
    }
}