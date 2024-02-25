package cz.czechitas.ukol3.model;

public class Memory {

    private long capacityRam;

    public long getCapacityRam() {
        return capacityRam;
    }

    public void setCapacityRam(long capacityRam) {
        this.capacityRam = capacityRam;
    }

    @Override
    public String toString() {
        return String.format("kapacitaRAM %s bytes", capacityRam);
    }
}