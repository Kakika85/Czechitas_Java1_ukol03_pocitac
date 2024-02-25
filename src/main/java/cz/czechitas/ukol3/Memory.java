package cz.czechitas.ukol3;

public class Memory {

    private long capacityRAM;

    public long getCapacityRAM() {
        return capacityRAM;
    }

    public void setCapacityRAM(long capacityRAM) {
        this.capacityRAM = capacityRAM;
    }

    @Override
    public String toString() {
        return String.format("Informace o paměti RAM: kapacitaRAM=%s byte", capacityRAM);
    }
}