package cz.czechitas.ukol3.model;

public class Computer {
    private Procesor cpu;
    private Memory ram;
    private Disc hardDisc;
    private Disc hardDisc2;
    private boolean isTurnedOn;

    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Memory getRam() {
        return ram;
    }

    public void setRam(Memory ram) {
        this.ram = ram;
    }

    public Disc getHardDisc() {
        return hardDisc;
    }

    public void setHardDisc(Disc hardDisc) {
        this.hardDisc = hardDisc;
    }

    public Disc getHardDisc2() {
        return hardDisc2;
    }

    public void setHardDisc2(Disc hardDisc2) {
        this.hardDisc2 = hardDisc2;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void turnOn() {
        if (isTurnedOn) {
            System.err.println("Počítač nelze zapnout, jelikož je již zapnutý.");
            return;
        }
        if (cpu == null || ram == null || hardDisc == null) {
            System.err.println("Počítač nelze zapnout, jelikož mu chybí hardwarová/é součástka/y.");
            return;
        }
        isTurnedOn = true;
        System.out.println("Zapínám počítač!");
    }

    public void turnOff() {
        if (!isTurnedOn) {
            return;
        }
        isTurnedOn = false;
        System.out.println("Vypínám počítač!");
    }

    @Override
    public String toString() {
        return String.format("Informace o počítači: procesor {%s}, operační paměť {%s}, disk {%s}, disk2 {%s}", cpu, ram, hardDisc, hardDisc2);
    }

    public void createFileOfSize(long bytes) {
        if (!isTurnedOn) {
            System.err.println("PC není zapnutý!");
            return;
        }
        if (bytes < 0) {
            System.err.println("Soubor má zápornou velikost!!!");
            return;
        }

        long usedSize = hardDisc.getUsedSize();
        long capacity = hardDisc.getCapacity();

        if (usedSize + bytes <= capacity) {
            usedSize += bytes;
            hardDisc.setUsedSize(usedSize);
            System.out.println("Na disk1 se zapsalo " + bytes + " bytů. Na disku zbývá " + (capacity - usedSize) + " bytů.");
            System.out.println("Využité místo je: " + usedSize + " bytů.");
        } else if (hardDisc2 != null && hardDisc2.getUsedSize() + bytes <= hardDisc2.getCapacity()) {
            long usedSize2 = hardDisc2.getUsedSize();
            long capacity2 = hardDisc2.getCapacity();
            usedSize2 += bytes;
            hardDisc2.setUsedSize(usedSize2);
            System.out.println("Na disk2 se zapsalo " + bytes + " bytů. Na disku zbývá " + (capacity2 - usedSize2) + " bytů.");
            System.out.println("Využité místo je: " + usedSize2 + " bytů.");
        } else {
            System.err.println("Na disku není dostatek místa, uvolněte místo či si kupte další disk. :-)");
        }
    }

    public void deleteFileOfSize(long bytes) {
        if (!isTurnedOn) {
            System.err.println("PC není zapnutý!");
            return;
        }
        if (bytes < 0) {
            System.err.println("Soubor má zápornou velikost!!!");
            return;
        }

        long usedSize = hardDisc.getUsedSize();
        long capacity = hardDisc.getCapacity();

        if (usedSize - bytes >= 0) {
            usedSize -= bytes;
            hardDisc.setUsedSize(usedSize);
            System.out.println("Z disku1 se smazalo " + bytes + " bytů. Na disku zbývá " + (capacity - usedSize) + " bytů.");
            System.out.println("Využité místo je: " + usedSize + " bytů");
        } else if (hardDisc2 != null && hardDisc2.getUsedSize() - bytes >= 0) {
            long usedSize2 = hardDisc2.getUsedSize();
            long capacity2 = hardDisc2.getCapacity();
            usedSize2 -= bytes;
            hardDisc2.setUsedSize(usedSize2);
            System.out.println("Z disku2 se smazalo " + bytes + " bytů. Na disku zbývá " + (capacity2 - usedSize2) + " bytů.");
            System.out.println("Využité místo je: " + usedSize2 + " bytů.");
        } else {
            System.err.println("Disk není dostatečně zaplněn.");
        }
    }
}