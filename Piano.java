import java.util.ArrayList;

public class Piano {
    private int numeroPiano;
    private ArrayList<String> codaPersone;

    public Piano(int numeroPiano) {
        this.numeroPiano = numeroPiano;
        this.codaPersone = new ArrayList<>();
    }

    public void aggiungiPersonaCoda(String nome) {
        codaPersone.add(nome);
    }

    public String rimuoviPersonaCoda() {
        if (!codaPersone.isEmpty()) {
            return codaPersone.remove(0);
        }
        return null;
    }

    public boolean haPersoneInAttesa() {
        return !codaPersone.isEmpty();
    }

    public int getNumeroPiano() {
        return numeroPiano;
    }

    public ArrayList<String> getCoda() {
        return codaPersone;
    }

    @Override
    public String toString() {
        return "Piano " + numeroPiano + " -> Coda: " + codaPersone;
    }

    public static void main(String[] args) {
        Piano piano1 = new Piano(1);
        
        piano1.aggiungiPersonaCoda("Giovanni");
        piano1.aggiungiPersonaCoda("Maria");

        System.out.println(piano1);  

        piano1.rimuoviPersonaCoda();

        System.out.println(piano1);  
    }
}
