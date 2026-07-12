package MODEL.bancodados;

import java.io.*;
import java.util.HashSet;
import MODEL.personagens.Magia;

public class BancoMagia extends Banco{
    private HashSet<Magia> magias;

    // use adicionarMagia() para adicionar uma magia ao banco e depois use criarBanco()
    // para salvar o arquivo
    public void criarBanco(){
        try(ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(file))){
            saida.writeObject(magias);
        } catch(IOException e){
            System.out.println("Erro salvando no arquivo de magias");
        }
    }

    @Override
    public void adicionarBanco(Object obj) {

    }

    public void adicionarBanco(Magia magia){
        magias.add(magia);
        for (Magia p : magias){
                System.out.println(p.getNome());
            }
    }

    public HashSet<Magia> getBanco(){
        return magias;
    }



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
