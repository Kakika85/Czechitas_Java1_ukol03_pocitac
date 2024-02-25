package cz.czechitas.ukol3;

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
        return String.format("Informace o paměti RAM: kapacitaRAM=%s byte", capacityRam);
    }
}