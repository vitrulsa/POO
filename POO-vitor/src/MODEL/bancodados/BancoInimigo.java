package MODEL.bancodados;

import MODEL.personagens.Inimigo;
import MODEL.personagens.Magia;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class BancoInimigo extends Banco{
    private ArrayList<Inimigo> inimigos;
    private final String file = "inimigos.dat";

    @Override
    public void criarBanco(){
        try(ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(file))){
            saida.writeObject(inimigos);
        } catch(IOException e){
            System.out.println("Erro salvando no arquivo de inimigos");
        }
    }

    @Override
    public void adicionarBanco(Object obj) {
        if(obj instanceof Inimigo) {
            inimigos.add((Inimigo) obj);
        }
    }

    @Override
    public HashSet getBanco() {
        return null;
    }

    // use adicionarInimigo() para adicionar um inimigo ao banco e depois use criarBanco()
    // para salvar o arquivo
    @Override
    public void adicionarBanco(String nome, String raca, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias){
        Inimigo inimigo = new Inimigo(nome, raca, hp, defesa, forca, dest, manaMax, magias);

        inimigos.add(inimigo);
        for (Inimigo p : inimigos){
                System.out.println(p.getNome());
            }
    }

    @Override
    public Inimigo getDado(String nome){
        for (Inimigo inimigo : inimigos){
            if (inimigo.getNome().equals(nome)){
                return inimigo;
            }
        }

        System.out.println("Inimigo não encontrado no banco de dados");
        return null;
    }

}
