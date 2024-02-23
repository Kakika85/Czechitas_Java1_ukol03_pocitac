package cz.czechitas.ukol3;

/**
 * Spouštěcí třída celého programu
 */
public class HlavniProgram {

    public static void main(String... args) {
        //TODO tady bude váš kód - vytvoření instance třídy Pocitac, zapnutí, vpynutí, výpis hodnot.
        Pocitac karolinyPocitac = new Pocitac();
        System.out.println(karolinyPocitac.toString());
        karolinyPocitac.zapniSe();  //Vypíše očekávanou chybu o nekompletnosti

        Procesor karolinyProcesor = new Procesor();
        karolinyProcesor.setRychlost(2_200_000_000L);
        karolinyProcesor.setVyrobce("Intel");

        Pamet karolinyPamet = new Pamet();
        karolinyPamet.setKapacitaRAM(16);

        Disk karolinyDisk = new Disk();
        karolinyDisk.setKapacita(126_641_762_304L);
        karolinyDisk.setVyuziteMisto(99_952_730_112L);

        karolinyPocitac.setCpu(karolinyProcesor);
        karolinyPocitac.setRam(karolinyPamet);
        karolinyPocitac.setPevnyDisk(karolinyDisk);

        System.out.println(karolinyPocitac.toString());

        karolinyPocitac.zapniSe();
        karolinyPocitac.zapniSe();    // vypíše chybu jelikož nelze zapnout 2x
        System.out.println(karolinyPocitac.toString());

        karolinyPocitac.vytvorSouborOVelikosti(100);
        karolinyPocitac.vytvorSouborOVelikosti(1000);
        karolinyPocitac.vymazSouborOVelikosti(100);

        karolinyPocitac.vypniSe();
        karolinyPocitac.vypniSe();    // chybu nepíše jen se neprovede operace

    }
}
