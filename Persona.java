class Persona {
    private int id;
    private int pianoDestinazione;

    public Persona(int id, int pianoDestinazione) {
        this.id = id;
        this.pianoDestinazione = pianoDestinazione;
    }

    public int getId() {
        return id;
    }

    public int getPianoDestinazione() {
        return pianoDestinazione;
    }

    @Override
    public String toString() {
        return "Persona " + id + " -> Piano " + pianoDestinazione;
    }
}

