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
        karolinyProcesor.setProducer("Intel");

        Memory karolinyMemory = new Memory();
        karolinyMemory.setCapacityRAM(16);

        Disc karolinyDisc = new Disc();
        karolinyDisc.setCapacityOf(126_641_762_304L);
        karolinyDisc.setUseSite(99_952_730_112L);

        Disc2 karolinyDisc2 = new Disc2();
        karolinyDisc2.setCapacityOf2(0L);
        karolinyDisc2.setUseSite2(0L);

        karolinyComputer.setCpu(karolinyProcesor);
        karolinyComputer.setRam(karolinyMemory);
        karolinyComputer.setHardDisc(karolinyDisc);

        System.out.println(karolinyComputer.toString());

        karolinyComputer.turnOn();
        karolinyComputer.turnOn();    // vypíše chybu jelikož nelze zapnout 2x
        System.out.println(karolinyComputer.toString());

        karolinyComputer.createSetOfValues(100);
        karolinyComputer.createSetOfValues(1000);
        karolinyComputer.deleteSetOfValues(100);

        karolinyComputer.turnOff();
        karolinyComputer.turnOff();    // chybu nepíše jen se neprovede operace
    }
}