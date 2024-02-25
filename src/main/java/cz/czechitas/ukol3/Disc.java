package cz.czechitas.ukol3;

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

    public boolean createFileOfSize(long bytes) {
        if (bytes < 0) {
            System.err.println("Soubor má zápornou velikost!!!");
            return false;
        }

        if (usedSize + bytes >= capacity) {
            System.err.println("Na disku není dost místa.");
            return false;
        }
        usedSize += bytes;

        System.out.println("Na disk se zapsalo " + bytes + " bytů. Na disku zbývá " + (capacity - usedSize) + " bytů.");
        System.out.println("Využité místo je: " + usedSize + " bytů.");
        return true;
    }

    public boolean deleteFileOfSize(long bytes) {
        if (bytes < 0) {
            System.err.println("Soubor má zápornou velikost!!!");
            return false;
        }

        if (usedSize - bytes < 0) {
            System.err.println("Disk není dostatečně zaplněn.");
            return false;
        }
        usedSize -= bytes;

        System.out.println("Z disku se smazalo " + bytes + " bytů. Na disku zbývá " + (capacity - usedSize) + " bytů.");
        System.out.println("Využité místo je: " + usedSize + " bytů");
        return true;
    }

    @Override
    public String toString() {
        return String.format("Informace o disku: kapacita je kapacita=%s bytů a využité místo je vyuziteMisto=%s bytů", capacity, usedSize);
    }
}