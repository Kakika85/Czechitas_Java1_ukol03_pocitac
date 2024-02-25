package cz.czechitas.ukol3;

public class Disc2 {
    private long capacity2;
    private long usedSize2;

    public long getCapacity2() {
        return capacity2;
    }

    public void setCapacity2(long capacity2) {
        this.capacity2 = capacity2;
    }

    public long getUsedSize2() {
        return usedSize2;
    }

    public void setUsedSize2(long useSite2) {
        this.usedSize2 = useSite2;
    }

    @Override
    public String toString() {
        return String.format("Informace o disku2: kapacita2 =%s bytů a využité místo je vyuziteMisto2 =%s bytů", capacity2, usedSize2);
    }


}