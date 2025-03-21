public class TestAscensore {
    public static void main(String[] args) {
        Ascensore ascensore = new Ascensore(5, 4); // L'ascensore parte dal piano 5 con capienza 4
        
        Persona p1 = new Persona(1, 8);
        Persona p2 = new Persona(2, 2);
        Persona p3 = new Persona(3, 10);

        System.out.println("\n== STATO INIZIALE ==");
        System.out.println(ascensore);

        System.out.println("\n== TEST: Apertura e chiusura porte ==");
        ascensore.apriPorte();
        System.out.println(ascensore);
        ascensore.chiudiPorte();
        System.out.println(ascensore);

        System.out.println("\n== TEST: Salita persone nell'ascensore ==");
        ascensore.apriPorte();
        ascensore.aggiungiPersona(p1);
        ascensore.aggiungiPersona(p2);
        System.out.println(ascensore);
        ascensore.chiudiPorte();
        System.out.println(ascensore);

        System.out.println("\n== TEST: Movimento e scarico persone ==");
        ascensore.salita();
        System.out.println(ascensore);
        ascensore.salita();
        System.out.println(ascensore);
        ascensore.apriPorte();
        ascensore.rimuoviPersoneArrivate();
        System.out.println(ascensore);
        ascensore.chiudiPorte();
        System.out.println(ascensore);

        System.out.println("\n== STATO FINALE DELL'ASCENSORE ==");
        System.out.println(ascensore);
    }
}

