package cz.czechitas.ukol3;

public class Procesor {

    private String vyrobce;
    private long rychlost;

    public Procesor(String výrobce, long rychlost) {
        this.vyrobce = výrobce;
        this.rychlost = rychlost;
    }

    public String getVyrobce() {
        return vyrobce;
    }

    public void setVyrobce(String vyrobce) {
        this.vyrobce = vyrobce;
    }

    public long getRychlost() {
        return rychlost;
    }

    public void setRychlost(long rychlost) {
        this.rychlost = rychlost;
    }

    @Override
    public String toString(){
        return String.format("Informace o procesoru: vyrobce=%/s, rychlost=%s Hz", vyrobce, rychlost);
    }
}
