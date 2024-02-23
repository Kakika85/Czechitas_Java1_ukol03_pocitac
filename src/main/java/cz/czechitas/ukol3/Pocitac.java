package cz.czechitas.ukol3;

public class Pocitac {

    //TODO metoda toString() do každé třídy
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;
    private boolean jeZapnuty;

    public Procesor getCpu() {
        return cpu;
    }

    public void setCpu(Procesor cpu) {
        this.cpu = cpu;
    }

    public Pamet getRam() {
        return ram;
    }

    public void setRam(Pamet ram) {
        this.ram = ram;
    }

    public Disk getPevnyDisk() {
        return pevnyDisk;
    }

    public void setPevnyDisk(Disk pevnyDisk) {
        this.pevnyDisk = pevnyDisk;
    }

    public boolean jeZapnuty() {
        return jeZapnuty;
    }

    public void zapniSe() {
        if (jeZapnuty) {
            System.err.println("Počítač nelze zapnout, jelikož je již zapnutý");
            return;
        }
        if (!jeZapnuty && (cpu == null || ram == null || pevnyDisk == null)) {
            System.err.println("Počítač nelze zapnout, jelikož mu chybí hardwarová/é součástka/y");
            return;
        }
        jeZapnuty = true;
        System.out.println("Zapínám počítač");
    }

    public void vypniSe() {
        if (!jeZapnuty) {
            return;
        }
        jeZapnuty = false;
        System.out.println("Vypínám počítač");
    }

    @Override
    public String toString() {
        return String.format("Informace o počítači: Procesor: =%scpu, operační paměť: =%sram, Disk: =%s pevnyDisk",
            cpu, ram, pevnyDisk);
    }

    public void vytvorSouborOVelikosti(long velikost) {
        if (!jeZapnuty) {
            System.err.println("PC není zapnutý");
            return;
        }
        if (velikost < 0) {
            System.err.println("Soubor má zápornou velikost!!!");
            return;
        }

        long vyuziteMisto = pevnyDisk.getVyuziteMisto();
        long kapacita = pevnyDisk.getKapacita();

        if (vyuziteMisto + velikost > kapacita) {
            System.err.println("Na disku není dostatek místa, uvolněte místo či si kupte větší disk:-)");
            return;
        }
        vyuziteMisto += velikost;
        pevnyDisk.setVyuziteMisto(vyuziteMisto);
        System.out.println("Na disk se zapsalo " + velikost + "bytů. Na disku zbývá " + (kapacita - vyuziteMisto) + "bytů.");
        System.out.println("Využité místo je: " + vyuziteMisto + "bytů");
    }

    public void vymazSouborOVelikosti(long velikost) {
        if (!jeZapnuty) {
            System.err.println("PC není zapnutý");
            return;
        }
        if (velikost < 0) {
            System.err.println("Soubor má zápornou velikost!!!");
            return;
        }

        long vyuziteMisto = pevnyDisk.getVyuziteMisto();
        long kapacita = pevnyDisk.getKapacita();

        if (vyuziteMisto - velikost < 0) {
            System.err.println("Tolik obsazeného místa nemám:-)");
            return;
        }
        vyuziteMisto -= velikost;
        pevnyDisk.setVyuziteMisto(vyuziteMisto);
        System.out.println("Na disk se zapsalo " + velikost + "bytů. Na disku zbývá " + (kapacita - vyuziteMisto) + "bytů.");
        System.out.println("Využité místo je: " + vyuziteMisto + "bytů");
    }
}
