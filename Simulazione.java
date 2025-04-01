import java.util.Scanner;
import java.util.Random;

public class Simulazione {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Ascensore ascensore = new Ascensore(5);
        Piano[] piani = new Piano[10];
        
        for (int i = 0; i < 10; i++) {
            piani[i] = new Piano(i);
        }
        
        for (int i = 0; i < 20; i++) {
            int pianoPartenza = rand.nextInt(10);
            int pianoDestinazione;
            do {
                pianoDestinazione = rand.nextInt(10);
            } while (pianoDestinazione == pianoPartenza);
            piani[pianoPartenza].aggiungiPersonaCoda(new Persona(i, pianoDestinazione));
        }

        for (int t = 0; t < 100; t++) {
            System.out.println("Premi invio");
            scanner.nextLine();

            ascensore.apriPorte();
            ascensore.rimuoviPersoneArrivate();
            while (piani[ascensore.getPianoCorrente()].haPersoneInAttesa()) {
                ascensore.aggiungiPersona(piani[ascensore.getPianoCorrente()].rimuoviPersonaCoda());
            }
            ascensore.chiudiPorte();
            ascensore.decidiDirezione(piani);
            ascensore.muoviAscensore(piani);
            System.out.println(ascensore);
        }
        
        scanner.close();
    }
}


