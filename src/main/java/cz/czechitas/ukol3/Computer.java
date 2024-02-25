package cz.czechitas.ukol3;

public class Computer {

    //TODO metoda toString() do každé třídy
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
        if (!isTurnedOn && (cpu == null || ram == null || hardDisc == null || hardDisc2 == null)) {
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
        return String.format("Informace o počítači: Procesor: =%s cpu, operační paměť: =%s ram, Disc: =%s pevnyDisk, Disc2: =%s pevnyDisk2", cpu, ram, hardDisc, hardDisc2);
    }

    public void createFileOfSize(long bytes) {
        if (!isTurnedOn) {
            System.err.println("PC není zapnutý!");
            return;
        }
        System.out.println("Zapisuji na disk 1");
        boolean success = hardDisc.createFileOfSize(bytes);
        if (!success) {
            System.out.println("Zápis na disk 1 se nezdařil, přecházím na disk 2.");
            success = hardDisc2.createFileOfSize(bytes);
        }
        if (!success) {
            System.err.println("Na disku1 ani na disku2 není dostatek místa, uvolněte místo či si kupte třetí disk. :-)");
        }
    }

    public void deleteFileOfSize(long bytes) {
        if (!isTurnedOn) {
            System.err.println("PC není zapnutý!");
            return;
        }
        boolean success = hardDisc.deleteFileOfSize(bytes);
        if (!success) {
            System.out.println("Výmaz z disku 1 se nezdařil, přecházím na disk 2.");
            success = hardDisc2.deleteFileOfSize(bytes);
        }
        if (!success) {
            System.err.println("Disk1 ani disk2 není dostatečně zaplněn.");
        }
    }
}