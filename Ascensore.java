import java.util.ArrayList;

class Ascensore {
    private int pianoCorrente;
    private int capienzaMassima;
    private ArrayList<Persona> personeDentro;
    private boolean porteAperte;
    private int direzione;

    public Ascensore(int capienzaMassima) {
        this.pianoCorrente = 0;
        this.capienzaMassima = capienzaMassima;
        this.personeDentro = new ArrayList<>();
        this.porteAperte = false;
        this.direzione = 0;
    }

    public void apriPorte() {
        porteAperte = true;
    }

    public void chiudiPorte() {
        porteAperte = false;
    }

    public void aggiungiPersona(Persona p) {
        if (porteAperte && personeDentro.size() < capienzaMassima) {
            personeDentro.add(p);
        }
    }

    public void rimuoviPersoneArrivate() {
        personeDentro.removeIf(p -> p.getPianoDestinazione() == pianoCorrente);
    }

    public void decidiDirezione(Piano[] piani) {
        boolean ciSonoPersoneDentro = !personeDentro.isEmpty();
        boolean ciSonoPersoneInAttesa = piani[pianoCorrente] != null && piani[pianoCorrente].haPersoneInAttesa();

        if (!ciSonoPersoneDentro && !ciSonoPersoneInAttesa) {
            direzione = 0;
        } else if (ciSonoPersoneDentro) {
            if (personeDentro.stream().anyMatch(p -> p.getPianoDestinazione() > pianoCorrente)) {
                direzione = 1;
            } else {
                direzione = -1;
            }
        } else {
            if (pianoCorrente < 9) {
                direzione = 1;
            } else {
                direzione = -1;
            }
        }
    }

    public void muoviAscensore(Piano[] piani) {
        if (direzione == 1 && pianoCorrente < 9) {
            pianoCorrente++;
        } else if (direzione == -1 && pianoCorrente > 0) {
            pianoCorrente--;
        }
    }

    public int getPianoCorrente() {
        return pianoCorrente;
    }

    @Override
    public String toString() {
        return "Ascensore al piano " + pianoCorrente + ", Persone dentro: " + personeDentro.size();
    }
}
