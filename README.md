# Úkol 3 – Třídy a objekty – počítač

Každou část úkolu vytvořte jako samostatný commit (důležité je to spíš pro vás – pokud na to zapoemenete a budete mít vše najednou, není potřeba commity
po částech vyvářet dodatečně). Pokud zjistíte dodatečně v kódu nějakou chybu, nevadí, commitněte opravu jako další commit. Pokud si chcete práci průběžně
zálohovat, po commitu udělejte také push, čímž se všechny neodeslané commity nahrají na GitHub.

Úkolem bude pomocí tříd vytvořit v Javě jednoduchý model počítače, vypsat o něm nějaké informace a vyzkoušet zapnutí a vypnutí počítače. 

💡 Poznámka: Při výpisu do konzole (terminálu) se ve skutečnosti rozlišují dva druhý výstupů – standardní výstup (běžné hlášky programu) a chybový výstup (chyby).
V některých prostředích je chybový výstup odlišen – např. v konzoli IntelliJ Idea je chybový výstup zobrazen červeně.

V Javě se výstup rozlišuje tím, jakou vlastnost používáte pro výpis chyb. `System.out` je standardní výstup, zatímco `System.err` je chybový výstup. Příklad
použití: 

```java
System.out.println("Program se spustil.");
System.err.println("V programu došlo k chybě");
```

Protože se tyto výpisy používají často, má pro ně IntelliJ Idea zkratky. Stačí napsat `sout` nebo `serr` a stisknout tabulátor, a IntelliJ Idea kód rozvine do 
celého příkazu:
* `sout` → `System.out.println(|);`
* `serr` → `System.err.println(|);`

## Část 1
Vytvořte veřejné třídy `Disk`, `Pamet`, `Procesor`, `Pocitac` v balíčku `cz.czechitas.ukol3.model`. Třídy budou mít následující vlastnosti:

###  Disk
* `long` kapacita – v bajtech
* `long` vyuziteMisto – v bajtech


### Pamet
* `long` kapacita – v bajtech

### Procesor
* `String` vyrobce
* `long` rychlost – v Hz

### Pocitac
* `boolean` jeZapnuty – toto bude pouze field, bez getteru a setteru
* `Procesor` cpu – budeme se tvářit, že počítač má jen jeden procesor s jedním jádrem
* `Pamet` ram
* `Disk` pevnyDisk

Do každé třídy naprogramujte metodu `toString()`, která bude v lidsky čitelné podobě vypisovat údaje o daném zařízení.

Do třídy `Pocitac` naprogamujte tři metody:
* `public boolean jeZapnuty()`
* `public void zapniSe()`
* `public void vypniSe()`

První metoda bude vracet stav, zda je počítač zapnutý (hodnotu fieldu `jeZapnuty`).
Další dvě metody budou počítač zapínat resp. vypínat, tj. budou nastavovat proměnnou (field) `jeZapnuty` a do konzole vypíšou odpovídající informaci (např. „Počítač se zapnul.“).

Počítač není možno zapnout dvakrát.
Při takovém pokusu vypište chybovou hlášku.

Počítač je možno vypnout vícekrát, ale opakované volání metody `vypniSe()` se ignoruje (ani se nevypíše žádná hláška).

Aby bylo možné počítač zapnout, musí mít procesor, paměť a disk.
Při pokusu o zapnutí počítače tedy musíte zkontrolovat, zda se daná část v počítači nachází.
Pokud nějaké chybí (např. `ram == null`), metoda pro zapnutí vypíše do konzle chybovou hlášku a metoda se ukončí (počítač se nezapne).


V metodě `main(String... args)` v `HlavniProgram` vytvořte model **svého** počítače a vyzkoušejte, že vám fungují správně metody
`toString()` u všech tříd a že počítač jde zapnout, jen pokud je správně sestavený.

💡 Poznámka: Číslo, které končí na `L` znamená, že jde o číslo typu `long` a nikoliv `int`. Rozdíl je v rozsahu. `int` pojme čísla od `-2 147 483 648` do
`+2 147 483 647` (tj. něco přes dvě miliardy), což není dostatečné pro kapacitu harddisku, paměti ani pro rychlosti současných procesorů. Proto
použijte `long`, který zvládne čísla od `-9 223 372 036 854 775 808` do `+9 223 372 036 854 775 807` (tj. přes devět trilionů).
To už je dostatečné na uchování údajů o současných počítačích.

Aby byl zápis čísel ve zdrojovém kódu přehlednější, umožňuje Java vkládat do čísel podtržítka (jako oddělovač tisíců – tam, kde my běžně píšeme mezery).

Příklad metody `main` Filipova počítače:

```java
public static void main(String... args) {
    Pocitac filipuvPocitac = new Pocitac();
    System.out.println(filipuvPocitac.toString());
    filipuvPocitac.zapniSe();      // Vypíše chybu, protože počítač v tuto chvíli nemá všechny povinné součásti.

    Procesor filipuvProcesor = new Procesor();
    filipuvProcesor.setRychlost(3_490_000_000L);
    filipuvProcesor.setVyrobce("Apple");

    Pamet filipovaPamet = new Pamet();
    filipovaPamet.setKapacita(24_000_000_000L);

    Disk filipuvDisk = new Disk();
    filipuvDisk.setKapacita(994_662_584_320L);

    filipuvPocitac.setCpu(filipuvProcesor);
    filipuvPocitac.setRam(filipovaPamet);
    filipuvPocitac.setPevnyDisk(filipuvDisk);

    System.out.println(filipuvPocitac.toString());

    filipuvPocitac.zapniSe();
    filipuvPocitac.zapniSe();      // Vypíše chybu, protože počítač už běží
    System.out.println(filipuvPocitac.toString());
    filipuvPocitac.vypniSe();

    filipuvPocitac.vypniSe();      // Nevypíše chybu, ale nic neprovede, protože počítač už je vypnutý
}
```

Nezapomeňte, že je úkolem vytvořit **model vašeho počítače**.
Parametry vašeho počítače budou pravděpodobně **jiné** než Filipova počítače.
(Pokud ale nějaký parametr neumíte snadno zjistit, klidně si údaj vymyslete.)

### Část 2

Vylepšete třídu `Pocitac` o metody:

* `public void vytvorSouborOVelikosti(long velikost)`
* `public void vymazSouboryOVelikosti(long velikost)`

Metoda `vytvorSouborOVelikosti(long velikost)` zvýší proměnnou `vyuziteMisto` o `velikost`. Pokud by se už nově vytvářený soubor na disk nevešel
(`vyuziteMisto > kapacita`), metoda vypíše chybu a `vyuziteMisto` se nebude měnit. Metoda `vymazSouboryOVelikosti(long velikost)` sníží proměnnou
`vyuziteMisto` o `velikost`. `vyuziteMisto` nemůže klesnout pod `0`. Metody budou fungovat pouze, pokud je počítač zapnutý.

Demonstrujte v `main(...)`, že se metody chovají, jak mají.

### Část 3 – Nepovinná část

Tuto část nemusíte naprogramovat pro uznání splnění úkolu. Ale zkuste to 💪

Vylepšete třídu `Pocitac` o druhý disk:
* `Disk` druhyDisk

Opravte metody `vytvorSouborOVelikosti(long velikost)` a `vymazSouboryOVelikosti(long velikost)` tak, aby nejprve zabíraly místo na prvním harddisku
a potom na druhém. Teprve pokud se soubor nedá vytvořit ani na druhém harddisku, vypíše metoda `vytvorSouborOVelikosti(long velikost)` chybu.

Demonstrujte v `main(...)`, že se metody chovají, jak mají.
