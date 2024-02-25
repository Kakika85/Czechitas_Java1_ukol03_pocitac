package cz.czechitas.ukol3;

public class Computer {

    //TODO metoda toString() do každé třídy
    private Procesor cpu;
    private Memory ram;
    private Disc hardDisc;
    private Disc2 hardDisc2;
    private boolean turnON;

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

    public Disc2 getHardDisc2() {
        return hardDisc2;
    }
    public void setHardDisc2(Disc2 hardDisc2) {
        this.hardDisc2 = hardDisc2;
    }

    public boolean turnON() {
        return turnON;
    }

    public void turnOn() {
        if (turnON) {
            System.err.println("Počítač nelze zapnout, jelikož je již zapnutý");
            return;
        }
        if (!turnON && (cpu == null || ram == null || hardDisc == null || hardDisc2 == null)) {
            System.err.println("Počítač nelze zapnout, jelikož mu chybí hardwarová/é součástka/y");
            return;
        }
        turnON = true;
        System.out.println("Zapínám počítač");
    }

    public void turnOff() {
        if (!turnON) {
            return;
        }
        turnON = false;
        System.out.println("Vypínám počítač");
    }

    @Override
    public String toString() {
        return String.format("Informace o počítači: Procesor: =%s cpu, operační paměť: =%s ram, Disc: =%s pevnyDisk, Disc2: =%s pevnyDisk2", cpu, ram, hardDisc, hardDisc2);
    }

    public void createSetOfValues(long sizeOf) {
        if (!turnON) {
            System.err.println("PC není zapnutý");
            return;
        }
        if (sizeOf < 0) {
            System.err.println("Soubor má zápornou velikost!!!");
            return;
        }

        long useSite = hardDisc.getUseSite();
        long capacity = hardDisc.getCapacityOf();
        long useSite2 = hardDisc2.getUseSite2();
        long capacityOf2 = hardDisc2.getCapacityOf2();

        if (useSite + sizeOf > capacity) {
            System.err.println("Na disku jedna není dostatek místa, provedu pokus zápisu na disk2");
        } else if (useSite + sizeOf > capacity || (useSite2 + sizeOf > capacityOf2)) {
            System.err.println("Ani na disku2 není dostatek místa, uvolněte místo či si kupte třetí disk :-)");
        } else if (useSite + sizeOf > capacity || (useSite2 + sizeOf < capacityOf2)) {
            useSite2 += sizeOf;
            hardDisc2.setUseSite2(useSite2);
            System.out.println("Na disk se zapsalo " + sizeOf + "bytů. Na disku zbývá " + (capacityOf2 - useSite2) + "bytů.");
            System.out.println("Využité místo je: " + useSite2 + "bytů");
            return;
        }
        useSite += sizeOf;
        hardDisc.setUseSite(useSite);
        System.out.println("Na disk se zapsalo " + sizeOf + "bytů. Na disku zbývá " + (capacity - useSite) + "bytů.");
        System.out.println("Využité místo je: " + useSite + "bytů");
        return;
    }

    public void deleteSetOfValues(long sizeOf) {
        long useSite = hardDisc.getUseSite();
        long capacity = hardDisc.getCapacityOf();
        long useSite2 = hardDisc2.getUseSite2();
        long capacity2 = hardDisc2.getCapacityOf2();

        if (!turnON) {
            System.err.println("PC není zapnutý");
            return;
        }

        if (sizeOf < 0) {
            System.err.println("Soubor má zápornou velikost!!!");
            return;
        }

        if (useSite - sizeOf < 0) {
            System.err.println("Tolik obsazeného místa nemám:-)");
        } else if (useSite - sizeOf < 0 || (useSite2 - sizeOf < 0)) {
            System.err.println("Ani na disku2 nemám tolik obsazeného místa");
        } else if (useSite - sizeOf < 0 || (useSite2 + sizeOf > 0)) {
            useSite2 -= sizeOf;
            hardDisc2.setUseSite2(useSite2);
            System.out.println("Na disk se zapsalo " + sizeOf + "bytů. Na disku zbývá " + (capacity2 - useSite2) + "bytů.");
            System.out.println("Využité místo je: " + useSite2 + "bytů");
            return;
        }
        useSite -= sizeOf;
        hardDisc.setUseSite(useSite);
        System.out.println("Na disk se zapsalo " + sizeOf + "bytů. Na disku zbývá " + (capacity - useSite) + "bytů.");
        System.out.println("Využité místo je: " + useSite + "bytů");
    }
}