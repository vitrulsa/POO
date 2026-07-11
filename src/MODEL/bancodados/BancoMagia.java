package MODEL.bancodados;

import java.io.*;
import java.util.HashSet;
import MODEL.personagens.Magia;

public class BancoMagia{
    private HashSet<Magia> magias;
    private final String file = "magias.dat";

    public BancoMagia(){
        magias = new HashSet<>();
        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(file))){
            magias = (HashSet<Magia>) entrada.readObject();

            System.out.println("Magias carregadas:");
            for (Magia magia : magias){
                System.out.println(magia.getNome());
            }
        } catch (IOException e){
            System.out.println("Falha abrindo arquivo para carregar magias.");
        } catch (ClassNotFoundException e){
            System.out.println("Falha lendo arquivo.");
        }
    }

    public void criarBanco(){
        try(ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(file))){
            saida.writeObject(magias);
        } catch(IOException e){
            System.out.println("Erro salvando no arquivo: " + e.getMessage());
        }
    }

    public void adicionarMagia(String nome, int dano, String tipo, String descricao){
        Magia magia = new Magia(nome, dano, tipo, descricao);

        magias.add(magia);
        for (Magia p : magias){
                System.out.println(p.getNome());
            }
    }
}
