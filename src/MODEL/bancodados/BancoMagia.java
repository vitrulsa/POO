package MODEL.bancodados;

import java.io.*;
import java.util.HashSet;
import MODEL.personagens.Magia;

public class BancoMagia extends Banco<Magia>{
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
            System.out.println("Falha lendo arquivo de magias.");
        }
    }

    // use adicionarMagia() para adicionar uma magia ao banco e depois use criarBanco()
    // para salvar o arquivo
    @Override
    public void criarBanco(){
        try(ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(file))){
            saida.writeObject(magias);
        } catch(IOException e){
            System.out.println("Erro salvando no arquivo de magias");
        }
    }

    @Override
    public void adicionarBanco(Magia magia){
        magias.add(magia);
        for (Magia p : magias){
                System.out.println(p.getNome());
            }
    }

    @Override
    public HashSet<Magia> getBanco(){
        return magias;
    }

    @Override
    public Magia getDado(String nome){
        for (Magia magia : magias){
            if (magia.getNome().equals(nome)){
                return magia;
            }
        }

        System.out.println("Magia não encontrada no banco de dados");
        return null;
    }
}
