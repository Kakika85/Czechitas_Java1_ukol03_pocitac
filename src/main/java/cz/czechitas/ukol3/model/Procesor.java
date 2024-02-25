package cz.czechitas.ukol3.model;

public class Procesor {

    private String brand;
    private long speed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("výrobce %s, rychlost %s Hz", brand, speed);
    }
}