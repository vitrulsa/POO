package MODEL.bancodados;

import MODEL.personagens.Inimigo;
import MODEL.personagens.Magia;

import java.io.*;
import java.util.HashSet;

public class BancoInimigo {
    private HashSet<Inimigo> inimigos;
    private final String file = "inimigos.dat";

    public BancoInimigo(){
        inimigos = new HashSet<>();
        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(file))){
            inimigos = (HashSet<Inimigo>) entrada.readObject();

            System.out.println("Inimigos carregados:");
            for (Inimigo inimigo : inimigos){
                System.out.println(inimigo.getNome());
            }
        } catch (IOException e){
            System.out.println("Falha abrindo arquivo para carregar inimigos.");
        } catch (ClassNotFoundException e){
            System.out.println("Falha lendo arquivo de inimigos.");
        }
    }

    public void criarBanco(){
        try(ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(file))){
            saida.writeObject(inimigos);
        } catch(IOException e){
            System.out.println("Erro salvando no arquivo de inimigos");
        }
    }

    // use adicionarInimigo() para adicionar um inimigo ao banco e depois use criarBanco()
    // para salvar o arquivo
    public void adicionarInimigo(String nome, String raca, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias){
        Inimigo inimigo = new Inimigo(nome, raca, hp, defesa, forca, dest, manaMax, magias);

        inimigos.add(inimigo);
        for (Inimigo p : inimigos){
                System.out.println(p.getNome());
            }
    }
}
