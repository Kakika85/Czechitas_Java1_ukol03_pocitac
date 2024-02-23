package cz.czechitas.ukol3;

public class Procesor {

    private String výrobce;
    private long rychlost;

    public Procesor(String výrobce, long rychlost) {
        this.výrobce = výrobce;
        this.rychlost = rychlost;
    }

    public String getVýrobce() {
        return výrobce;
    }

    public void setVýrobce(String výrobce) {
        this.výrobce = výrobce;
    }

    public long getRychlost() {
        return rychlost;
    }

    public void setRychlost(long rychlost) {
        this.rychlost = rychlost;
    }
}
