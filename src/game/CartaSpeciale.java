package game;

public class CartaSpeciale extends Carta {

    public String effetto;
    public CartaSpeciale(String nome, String percorso_immagine, String effetto) {
        super(nome, percorso_immagine);
        this.effetto = effetto;
    }

    public String getEffetto() {
        return effetto;
    }
}
