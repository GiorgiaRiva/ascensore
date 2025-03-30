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
        if (personeDentro.isEmpty() && !piani[pianoCorrente].haPersoneInAttesa()) {
            direzione = 0;
        } else {
            direzione = personeDentro.stream().anyMatch(p -> p.getPianoDestinazione() > pianoCorrente) ? 1 : -1;
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