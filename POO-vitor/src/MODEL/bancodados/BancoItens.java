package MODEL.bancodados;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import MODEL.personagens.*;

public class BancoItens extends Banco{
    private ArrayList<Item> itens;
    private final String file = "itens.dat";

    // use adicionarBanco() para adicionar um item ao banco e depois use criarBancoItem()
    // para salvar o arquivo
    public void criarBanco(){
        try(ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(file))){
            saida.writeObject(itens);
        } catch(IOException e){
            System.out.println("Erro salvando no arquivo de itens!");
        }
    }

    @Override
    public void adicionarBanco(Object obj) {
        if(obj instanceof Item) {
            itens.add((Item) obj);
        }
    }

    public void adicionarBanco(Item item) {
        if (item != null) {
            itens.add(item);
        }
    }

    public HashSet<Item> getBanco(){
        return banco;
    }

    public Item getDado(String nome){
        for (Item item : banco){
            if (item.getNome().equals(nome)){
                return item;
            }
        }

        System.out.println("Item não encontrado no banco de dados");
        return null;
    }


}
