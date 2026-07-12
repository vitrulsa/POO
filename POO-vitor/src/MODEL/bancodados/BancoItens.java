package MODEL.bancodados;

import java.io.*;
import java.util.HashSet;
import MODEL.personagens.*;

public class BancoItens extends Banco<Item>{
    private HashSet<Item> banco;
    private final String file = "itens.dat";

    public BancoItens() {
        this.banco = new HashSet<>();

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(file))) {
            this.banco = (HashSet<Item>) entrada.readObject();

            System.out.println("Itens carregados:");
            for (Item item : banco){
                System.out.println(item.getNome());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar itens");
        }
    }

    // use adicionarBanco() para adicionar um item ao banco e depois use criarBancoItem()
    // para salvar o arquivo
    @Override
    public void criarBanco(){
        try(ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(file))){
            saida.writeObject(banco);
        } catch(IOException e){
            System.out.println("Erro salvando no arquivo de itens!");
        }
    }

    @Override
    public void adicionarBanco(Item item) {
        if (item != null) {
            banco.add(item);
        }
    }

    @Override
    public HashSet<Item> getBanco(){
        return banco;
    }

    @Override
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
