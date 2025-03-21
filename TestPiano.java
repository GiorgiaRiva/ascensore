public class TestPiano {
    public static void main(String[] args) {
        Piano piano = new Piano(3); // Creiamo un piano 3
        Persona p1 = new Persona(1, 7);
        Persona p2 = new Persona(2, 9);
        Persona p3 = new Persona(3, 5);

        System.out.println("\n== TEST: Aggiunta persone alla coda del piano ==");
        piano.aggiungiPersonaCoda(p1);
        piano.aggiungiPersonaCoda(p2);
        piano.aggiungiPersonaCoda(p3);
        System.out.println(piano);

        System.out.println("\n== TEST: Rimozione di una persona dalla coda ==");
        Persona primaPersona = piano.rimuoviPersonaCoda();
        System.out.println("👤 Persona " + primaPersona.getId() + " è stata rimossa dalla coda.");
        System.out.println(piano);

        System.out.println("\n== TEST: Rimozione di tutte le persone dalla coda ==");
        while (!piano.getCoda().isEmpty()) {
            Persona personaRimossa = piano.rimuoviPersonaCoda();
            System.out.println("👤 Persona " + personaRimossa.getId() + " è stata rimossa dalla coda.");
        }
        System.out.println("✅ La coda del piano è ora vuota.");
        System.out.println(piano);

        System.out.println("\n== STATO FINALE DEL PIANO ==");
        System.out.println(piano);
    }
}
