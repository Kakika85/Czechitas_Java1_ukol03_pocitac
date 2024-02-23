package cz.czechitas.ukol3;

public class Pamet {

    private long kapacitaRAM;

    public Pamet() {
        kapacitaRAM = 1*1024*1024*1024;
    }

    public long getKapacitaRAM() {
        return kapacitaRAM;
    }

    public void setKapacitaRAM(long kapacitaRAM) {
        this.kapacitaRAM = kapacitaRAM;
    }
    @Override
    public String toString(){
        return String.format("Informace o paměti RAM: kapacitaRAM=%/s byte", kapacitaRAM);
    }
}
