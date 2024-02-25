package cz.czechitas.ukol3;

public class Pocitac {

    //TODO metoda toString() do každé třídy
    private Procesor cpu;
    private Pamet ram;
    private Disk pevnyDisk;
    private Disk2 pevnyDisk2;
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

    public Disk2 getPevnyDisk2() {
        return pevnyDisk2;
    }

    public void setPevnyDisk2(Disk2 pevnyDisk2) {
        this.pevnyDisk2 = pevnyDisk2;
    }

    public boolean jeZapnuty() {
        return jeZapnuty;
    }

    public void zapniSe() {
        if (jeZapnuty) {
            System.err.println("Počítač nelze zapnout, jelikož je již zapnutý");
            return;
        }
        if (!jeZapnuty && (cpu == null || ram == null || pevnyDisk == null || pevnyDisk2 == null)) {
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
        return String.format("Informace o počítači: Procesor: =%s cpu, operační paměť: =%s ram, Disk: =%s pevnyDisk, Disk2: =%s pevnyDisk2",
            cpu, ram, pevnyDisk, pevnyDisk2);
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
        long vyuziteMisto2 = pevnyDisk2.getVyuziteMisto2();
        long kapacita2 = pevnyDisk2.getKapacita2();

        if (vyuziteMisto + velikost > kapacita) {
            System.err.println("Na disku jedna není dostatek místa, provedu pokus zápisu na disk2");
        } else if (vyuziteMisto + velikost > kapacita || (vyuziteMisto2 + velikost > kapacita2)) {
            System.err.println("Ani na disku2 není dostatek místa, uvolněte místo či si kupte třetí disk :-)");
        } else if (vyuziteMisto + velikost > kapacita || (vyuziteMisto2 + velikost < kapacita2)) {
            vyuziteMisto2 += velikost;
            pevnyDisk2.setVyuziteMisto2(vyuziteMisto2);
            System.out.println("Na disk se zapsalo " + velikost + "bytů. Na disku zbývá " + (kapacita2 - vyuziteMisto2) + "bytů.");
            System.out.println("Využité místo je: " + vyuziteMisto2 + "bytů");
            return;
        }
        vyuziteMisto += velikost;
        pevnyDisk.setVyuziteMisto(vyuziteMisto);
        System.out.println("Na disk se zapsalo " + velikost + "bytů. Na disku zbývá " + (kapacita - vyuziteMisto) + "bytů.");
        System.out.println("Využité místo je: " + vyuziteMisto + "bytů");
        return;
    }

    public void vymazSouborOVelikosti(long velikost) {
        long vyuziteMisto = pevnyDisk.getVyuziteMisto();
        long kapacita = pevnyDisk.getKapacita();
        long vyuziteMisto2 = pevnyDisk2.getVyuziteMisto2();
        long kapacita2 = pevnyDisk2.getKapacita2();

        if (!jeZapnuty) {
            System.err.println("PC není zapnutý");
            return;
        }

        if (velikost < 0) {
            System.err.println("Soubor má zápornou velikost!!!");
            return;
        }


        if (vyuziteMisto - velikost < 0) {
            System.err.println("Tolik obsazeného místa nemám:-)");
        } else if (vyuziteMisto - velikost < 0 || (vyuziteMisto2 - velikost < 0)) {
            System.err.println("Ani na disku2 nemám tolik obsazeného místa");
        } else if (vyuziteMisto - velikost < 0 || (vyuziteMisto2 + velikost > 0)) {
            vyuziteMisto2 -= velikost;
            pevnyDisk2.setVyuziteMisto2(vyuziteMisto2);
            System.out.println("Na disk se zapsalo " + velikost + "bytů. Na disku zbývá " + (kapacita2 - vyuziteMisto2) + "bytů.");
            System.out.println("Využité místo je: " + vyuziteMisto2 + "bytů");
            return;
        }
        vyuziteMisto -= velikost;
        pevnyDisk.setVyuziteMisto(vyuziteMisto);
        System.out.println("Na disk se zapsalo " + velikost + "bytů. Na disku zbývá " + (kapacita - vyuziteMisto) + "bytů.");
        System.out.println("Využité místo je: " + vyuziteMisto + "bytů");
    }
}

