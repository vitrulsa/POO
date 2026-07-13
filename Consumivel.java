package MODEL.bancodados;

import MODEL.personagens.Inimigo;
import MODEL.personagens.Magia;

import java.io.*;
import java.util.HashSet;

public class BancoInimigo extends Banco<Inimigo>{
    private HashSet<Inimigo> inimigos;
    private final String file = "inimigos.dat";

    public BancoInimigo() throws Exception{
        inimigos = new HashSet<>();
        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(file))){
            inimigos = (HashSet<Inimigo>) entrada.readObject();

            System.out.println("Inimigos carregados:");
            for (Inimigo inimigo : inimigos){
                System.out.println(inimigo.getNome());
            }
        } catch (IOException e){
            System.out.println("Falha abrindo arquivo para carregar inimigos.");
            throw e;
        } catch (ClassNotFoundException e){
            System.out.println("Falha lendo arquivo de inimigos.");
            throw e;
        }
    }

    @Override
    public void criarBanco(){
        try(ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(file))){
            saida.writeObject(inimigos);
        } catch(IOException e){
            System.out.println("Erro salvando no arquivo de inimigos");
        }
    }

    // use adicionarInimigo() para adicionar um inimigo ao banco e depois use criarBanco()
    // para salvar o arquivo
    @Override
    public void adicionarBanco(Inimigo inimigo){
        inimigos.add(inimigo);
        for (Inimigo p : inimigos){
                System.out.println(p.getNome());
            }
    }

    @Override
    public HashSet<Inimigo> getBanco(){ return inimigos;}

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
