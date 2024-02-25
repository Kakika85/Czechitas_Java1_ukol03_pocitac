package cz.czechitas.ukol3;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
        //TODO tady bude váš kód - vytvoření instance třídy Computer, zapnutí, vpynutí, výpis hodnot.
        Computer karolinyComputer = new Computer();
        System.out.println(karolinyComputer.toString());
        karolinyComputer.turnOn();  //Vypíše očekávanou chybu o nekompletnosti

        Procesor karolinyProcesor = new Procesor();
        karolinyProcesor.setSpeed(2_200_000_000L);
        karolinyProcesor.setBrand("Intel");

        Memory karolinyMemory = new Memory();
        karolinyMemory.setCapacityRam(16);

        Disc karolinyDisc = new Disc();
        karolinyDisc.setCapacity(126_641_762_304L);
        karolinyDisc.setUsedSize(99_952_730_112L);

        Disc karolinyDisc2 = new Disc();
        karolinyDisc2.setCapacity(888_945_246_208L);
        karolinyDisc2.setUsedSize(90_851_504_128L);

        karolinyComputer.setCpu(karolinyProcesor);
        karolinyComputer.setRam(karolinyMemory);
        karolinyComputer.setHardDisc(karolinyDisc);
        karolinyComputer.setHardDisc2(karolinyDisc2);

        System.out.println(karolinyComputer.toString());

        karolinyComputer.turnOn();
        karolinyComputer.turnOn();    // vypíše chybu jelikož nelze zapnout 2x
        System.out.println(karolinyComputer.toString());

        karolinyComputer.createFileOfSize(100L);             // zpráva, že zapsalo na disk 1
        karolinyComputer.createFileOfSize(126_641_762_304L); // zprava, že zapsalo na disk 2
        karolinyComputer.createFileOfSize(906_641_762_304L); // zpráva, že nedokáže zapsat ani na disk 2
        karolinyComputer.deleteFileOfSize(100L);
        karolinyComputer.deleteFileOfSize(50_000_000_000L);  // zpráva, že smazalo z disku 1
        karolinyComputer.deleteFileOfSize(210_000_000_000L); // zpráva, že smazalo z diksu 2
        karolinyComputer.deleteFileOfSize(50_000_000_000L);  // zpráva, že nebylo možné smazat z žádného disku

        karolinyComputer.turnOff();
        karolinyComputer.turnOff();    // chybu nepíše jen se neprovede operace
    }
}