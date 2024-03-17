package game;

public class CartaBase extends Carta {

    public int numero;

    public CartaBase(String nome, int numero, String percorso_immagine) {
        super(nome, percorso_immagine);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
