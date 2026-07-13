package MODEL.bancodados;

import MODEL.personagens.Item;
import MODEL.personagens.NPC;
import MODEL.personagens.Magia;

import java.io.*;
import java.util.HashSet;

public class BancoNPC extends Banco<NPC>{
    private HashSet<NPC> npcs;
    private final String file = "npcs.dat";

    public BancoNPC(){
        npcs = new HashSet<>();
//        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(file))){
//            npcs = (HashSet<NPC>) entrada.readObject();
//
////            System.out.println("NPCs carregados:");
////            for (NPC npc : npcs){
////                System.out.println(npc.getNome());
////            }
//        } catch (IOException e){
//            System.out.println("Falha abrindo arquivo para carregar NPCs.");
//        } catch (ClassNotFoundException e){
//            System.out.println("Falha lendo arquivo de NPCs.");
//        }
    }

    @Override
    public void criarBanco(){
        try(ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(file))){
            saida.writeObject(npcs);
        } catch(IOException e){
            System.out.println("Erro salvando no arquivo de NPCs");
        }
    }

    // use adicionarNPC() para adicionar um NPC ao banco e depois use criarBanco()
    // para salvar o arquivo
    @Override
    public void adicionarBanco(NPC npc){
        npcs.add(npc);
        for (NPC p : npcs){
            System.out.println(p.getNome());
        }
    }

    @Override
    public HashSet<NPC> getBanco(){ return npcs;}

    @Override
    public NPC getDado(String nome){
        for (NPC npc : npcs){
            if (npc.getNome().equals(nome)){
                return npc;
            }
        }

        System.out.println(nome + " não encontrado no banco de dados");
        return null;
    }
}
