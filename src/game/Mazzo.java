package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Mazzo {

    public int carteMazzo;
    public Carta carta;
    public ArrayList<Carta> mazzo = new ArrayList <Carta>();

    public Mazzo() {
        carteMazzo = mazzo.size();
    }

    public int getCarte() {
        return carteMazzo;
    }

    public void addCarta(Carta nuovaCarta) {
        mazzo.add(nuovaCarta);
    }

    public void creaMazzo(String nomeFile) {
        String pathFile = "/Users/lorenzocuoco/Desktop/Cartelle/Programmazione/IntelliJ-workspace/Spacca/src/saved_data/" + nomeFile;
        //da cambiare nel caso si usi su un'altro pc

        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null && i < 13) {
                String[] parts = line.split(",");

                String nome= parts[0].trim();
                int numero = Integer.parseInt(parts[1].trim());
                String percorso= parts[2].trim();

                CartaBase carta = new CartaBase(nome, numero, percorso);
                mazzo.add(carta);

                i++;
            }
        }
        catch (IOException e) {
            System.out.println("File non trovato");
        }
    }

    public void mescolaMazzo() {
        Collections.shuffle(mazzo);
    }
}
