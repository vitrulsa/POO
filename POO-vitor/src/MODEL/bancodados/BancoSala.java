package MODEL.bancodados;

import MODEL.mapa.Sala;

import java.io.*;
import java.util.ArrayList;

public class BancoSala extends Banco{

    private ArrayList<Sala> salas;

    public void criarBanco() {
        try (ObjectOutputStream saida =
                     new ObjectOutputStream(new FileOutputStream("salas.dat"))) {

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