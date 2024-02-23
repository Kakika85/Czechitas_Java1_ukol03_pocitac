package cz.czechitas.ukol3;

public class Pamet {

    private long kapacitaRAM;

    public long getKapacitaRAM() {
        return kapacitaRAM;
    }

    public void setKapacitaRAM(long kapacitaRAM) {
        this.kapacitaRAM = kapacitaRAM;
    }

    @Override
    public String toString() {
        return String.format("Informace o paměti RAM: kapacitaRAM=%s byte", kapacitaRAM);
    }
}
