package com.genbrugsstation;

import java.util.HashMap;

class Butik extends Space {

    private static HashMap<Integer, Upgrades> upgrades;
    private HashMap<Integer, Upgrades> allUpgrades;

     Butik(String name) {
        super(name);
        allUpgrades = new HashMap<Integer, Upgrades>();
        upgrades = new HashMap<Integer, Upgrades>();
        initUpgrades(allUpgrades);
        initUpgrades(upgrades);
     }

    @Override
    public void welcome() {
    }

    private void firstDayWelcome() {
        System.out.println("\n_______________________________________________________");
        System.out.println("\n" + "Velkommen til shoppen! Butikkens udvalg er vist foroven.\n" +
                "Her kan du få brugt mønter, som du får, når du genanvender skrald fra genbrugsstationen!\n" +
                "Du må træffe de rigtige beslutninger, når du skal investere i opgraderingerne, for de er vigtige for din bys bæredygtighed!\n" +
                "Du kan altid tjekke byens status og din udvikling som borgmester i kontoret." +
                "Du kan bruge 'buy' for at købe, og 'help' for at se andre tilgængelige commands i rummet!");
    }

    public HashMap<Integer, Upgrades> getAllUpgrades() {
        return allUpgrades;
    }

    public HashMap<Integer, Upgrades> getUpgrades(){
        return upgrades;
    }

    private void initUpgrades(HashMap<Integer, Upgrades> hm){
        hm.put(1, new Upgrades("Cykelsti", 120, 60, 1.5, "9 ud af 10 danskere ejer " +
                "en cykel. Cykelstier gør det lettere og mere sikkert for cykellister at bevæge sig rundt i din by. " +
                "Det opfordrer flere til at tage cyklen på arbejdet i stedet for at bruge deres bil, så de får " +
                "også lidt mere motion i hverdagen. En stor del af forurening kommer fra biler og cykelstier hjælper " +
                "derfor med at få mindre biler på vejen. De 6 grønneste byer i verdenen har alle sammen cykelstier.", 2));
        hm.put(2, new Upgrades("Motorvej", 100, 0, 1.5, "En almindelig personbil udleder" +
                " i gennemsnit 248 gram CO2 per kilometer. Biler er noget af det der forurener allermest i byer. En " +
                "motorvej kan gøre transport med varer mere effektiv, men det betyder at flere lasbiler nu kører " +
                "igennem din by. Ikke nok med at motorvejen har gjort din by mindre miljøvenlig, så er beboerne i " +
                "Villakvarteret nu generet af støj selv om natten.", 1));
        hm.put(3, new Upgrades("Billboards", 120, 0, 1.5, "Du har valgt at opsætte " +
                "billboards i Centrum på rådhuset og lave en mini version af Times Square. Det får selvfølgelig " +
                "flere turister til byen, men flere turister betyder mere skrald og beskidte gader. Det har også " +
                "en negativ bekostning på klimaet, for billboards bruger en del strøm. Times Square bruger så " +
                "meget strøm hver eneste dag, at det svarer til at kunne oplyse 1.6 millioner af lyspærer.", 5));
        hm.put(4, new Upgrades("Busstoppested", 180, 60, 1.5, "Offentlig transport betyder " +
                "at færre tager deres bil, hvilket hjælper med at reducere den negative miljøbelastning per indbygger. " +
                "FNs verdensmål for bæredygtige byer har et delmål, som handler om sikre, let tilgængelige og " +
                "bæredygtige oftenlige transport systemer. Det har du lige skabt for din by! Det hjælper også " +
                "dem som ikke kan køre bil eller bruge en cykel, som foreksempel ældre eller folk med handicap.", 10));
        hm.put(5, new Upgrades("Solceller", 140, 60, 1.5, "Solceller er en vedvarende " +
                "og grøn energi, som bruger solens stråler til at danne strøm. De er strøjfrie og lugter ikke. En " +
                "typisk dansk familie vil kunne bruge en solcelle til deres årlige el-forbrug og har tjent den " +
                "hjem inden for 10 år. Danmark har over 136000 solcelleanlæg! I oktober 2023 udgjorde vindmøller " +
                "og solceller 75% af vores energiforbrug. Centrum og det meste af din by er kører nu på solenergi, " +
                "hvilket har gjort din by grønnere. Folk nyder den friskere luft og et andepar er flyttet ind " +
                "i centrums springvand.", 3));
        hm.put(6, new Upgrades("Filter i parksøen", 160, 60, 1.5, "Du har valgt at få sat et " +
                "vandfilter op i parksøen, for at gøre den renere. Filteret har skabt mere ilt i vandet og et bedre miljø " +
                "for planter, som gavner vores luftkvalitet med deres fotosyntese. Ikke nok med det, men så har ænder slået " +
                "sig ned og folk vil gerne gå ture rundt om søen. De har også sat et lille picnik område op, så de kan " +
                "nyde dagen i parken med familie eller venner. ", 9));
        hm.put(7, new Upgrades("Isolerende vinduer", 200, 60, 1.5, "Isolerende vinduer virker " +
                "på den måde at solens stråler kommer igennem glasset og vinduerne holder på varmen. Ved brug af disse " +
                "vinduer bliver elforbruget reduceret en del, for nu har dine borger ikke problemer med kulde fra utætte " +
                "vinduer og solstrålerne fra tagvinduerne også gav varme. Flere af dem har også fjernet deres pejse, " +
                "hvilket også har hjulpet med at formindske luftforurening. Derudover blev deres levevilkår forbedret " +
                "af mere sollys og mindre trækgener fra de utætte vinduer.", 11));
        hm.put(8, new Upgrades("Legeplads", 220, 60, 1.5, "Et af delmålene af FNs verdensmål " +
                "for bæredygtige byer, handler om at skabe grønne oftenlige rum for alle borgere. De skal være sikre og " +
                "tilgængelige for alle aldre, især kvinder og børn, for ældre og mennesker med handicap. Din legeplads " +
                "har gjort parken mere brugbar for mange, der nu nyder den friske luft. Flere lufter deres hunde, går " +
                "tur og er glade for at rodet er væk.", 12));
        hm.put(9, new Upgrades("Farve i parksøen", 140, 0, 1.5, "Du har valgt at hælde farve " +
                "i søen, for at gøre den mindre grøn og se mindre forurenet ud. Vandet er blevet mere blåt, men på bekostning " +
                "af miljøet og specielt de fisk der levede i søen. Det er ikke altid en god idé at hoppe over hvor " +
                "gærdet er lettest og billigst. Den kemiske farve er sivet ned i jorden og der er kommet pletter rundt i " +
                "parken hvor græsset ikke længere kan gro.", 6));
        hm.put(10, new Upgrades("Parkeringshus", 160, 0, 1.5, "Biler er noget af det som " +
                "forurener allermest i byer og et parkeringshus vil tiltrække flere biler til din by. Flere byer i Danmark " +
                "har et talt om at indføre et forbud for bestemte typer biler, for at prøve på at formindske den skade " +
                "som bilerne gør på miljøet. Flere byer har en Miljøzone, som forbyder dieselkøretøjer uden et partikelfilter " +
                "at køre. Oslo i Norge er en af de byer, der har reduceret udledningen allermest per indbygger. " +
                "Norge har brugt mange penge på at hjælpe en stor del af deres befolkning med tilskud til elbiler " +
                "for at opnå dette.\n", 4));
        hm.put(11, new Upgrades("Varmeanlæg m. oliefyr", 180, 0, 1.5, "Et oliefyr kan hurtigt " +
                "varme et hus op, men denne effektivitet har konsekvenser i det længere løb. De udleder en del CO2, faktisk" +
                " helt op til 313 kg per MWh varme. Bare i Danmark udleder vi 5,7 tons CO2 om året på at opvarme huse " +
                "med oliefyre. I Danmark har regeringen bestemt at man ikke længere må opsætte oliefyre, hvis man " +
                "har mulighed for at bruge en anden energikilde. ", 7));
        hm.put(12, new Upgrades("Fodboldstadion", 200, 0, 1.5, "Et stadion er dyrt at lave, " +
                "men også dyrt at opholde. Det kræver meget energi at holde et stadion ved lige og stedet udleder en del CO2. " +
                "For ikke kun stadionet selv udleder CO2, men fodboldfans kommer nu med busser, de sviner parken til med " +
                "skrald efter fodboldkampe. Der ligger nu gamle billetter og merchandise på græsset. Fodboldfansene er glade, " +
                "men resten af befolkningen er kede af hvordan parken nu er mindre attraktiv at besøge.", 8));

    }

    // Metode til at hente pris baseret på en key
    public static int getUpgradePrice(int key) {
        if (upgrades.containsKey(key)) {
            return upgrades.get(key).getPrice();
        } else {
            return -1;
        }
    }

    // Metode til at hente xp baseret på en key
    public static int getUpgradeXp(int key) {
        if (upgrades.containsKey(key)) {
            return upgrades.get(key).getXP();
        } else {
            return -1;
        }
    }

    // Metode til at hente navn baseret på en key
    public static String getUpgradeName(int key) {
        if (upgrades.containsKey(key)) {
            return upgrades.get(key).getName();
        } else {
            return null;
        }
    }

    //henter et hint tilhørende en opgradering fra en key
    public static String getHints(int key){
        if (upgrades.containsKey(key)) {
            return upgrades.get(key).getHint();
        } else {
            return null;
        }
    }

    private void removeUpgrade(int key) {
        upgrades.remove(key);
    }


    void removeFromShop(Butik butik, Upgrades selectedUpgrade, int upgradeIndex){
        //bestem den anden opgradering der skal fjernes, baseret på den valgte opgradering
        Player player = Game.getContext().getPlayer();
        int secondUpgradeToRemove = selectedUpgrade.getRelatedUpgradeIndex();

        System.out.println("Du har købt upgraderingen " + selectedUpgrade.getName());

        butik.removeUpgrade(upgradeIndex);//fjern upgrade fra shop

        if (upgrades.containsKey(secondUpgradeToRemove)) {
            Upgrades relatedUpgrade = upgrades.get(secondUpgradeToRemove);
            butik.removeUpgrade(secondUpgradeToRemove); // fjern den anden opgradering
            System.out.println("Du har også fjernet " + relatedUpgrade.getName() + " fra butikken.");

        } else {
            System.out.println("Error: Related upgrade not found.");
        }

        System.out.println("\nDu har så mange mønter nu: " + player.getMoney());
        System.out.println("Du har så meget xp nu: " + player.getXP() + "\n");

    }
}
