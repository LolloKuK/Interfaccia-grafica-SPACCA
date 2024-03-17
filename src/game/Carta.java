package game;

public abstract class Carta {

    public String nome;
    public String percorso_immagine;

    public Carta(String nome, String percorso_immagine){
        this.nome = nome;
        this.percorso_immagine = percorso_immagine;
    }

    public String getNome() {
        return nome;
    }
    public String getPercorso() {
        return percorso_immagine;
    };
}