package cz.czechitas.ukol3.model;

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
        return String.format("kapacita %s bytů a využité místo %s bytů", capacity, usedSize);
    }
}