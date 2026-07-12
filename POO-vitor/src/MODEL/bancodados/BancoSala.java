package MODEL.bancodados;

import MODEL.mapa.Sala;

import java.io.*;
import java.util.ArrayList;

public class BancoSala extends Banco{

    private ArrayList<Sala> salas;
    private final String file = "salas.dat";

    public BancoSala() {
        salas = new ArrayList<>();

        try (ObjectInputStream entrada =
                     new ObjectInputStream(new FileInputStream(file))) {

            salas = (ArrayList<Sala>) entrada.readObject();

            System.out.println("Salas carregadas:");
            for (Sala s : salas) {
                System.out.println(s.getDescricao());
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Falha abrindo arquivo de salas.");
        }
    }

    public void criarBanco() {
        try (ObjectOutputStream saida =
                     new ObjectOutputStream(new FileOutputStream(file))) {

            saida.writeObject(salas);

        } catch (IOException e) {
            System.out.println("Erro salvando salas.");
        }
    }

    public void adicionarSala(Sala sala) {
        salas.add(sala);
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public Sala getSala(int indice) {
        if (indice >= 0 && indice < salas.size())
            return salas.get(indice);

        return null;
    }
}