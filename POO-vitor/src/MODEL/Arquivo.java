package MODEL;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import MODEL.personagens.*;
import MODEL.bancodados.*;
import MODEL.mapa.*;

public class Arquivo {

    public static void salvarJogo() throws Exception {
        try {
            FileOutputStream arqv = new FileOutputStream("lindorpg.dat");
            //manda p construtor... p criar arqv com esse nome no final
            ObjectOutputStream arqvSalvar = new ObjectOutputStream(arqv);
            //manda p construtor de objectoutputstream
            arqvSalvar.writeObject(MapaAtual.getJogador());

        } catch (IOException e) {
            throw new Exception("Algo deu errado salvando o jogo!");
        }
    }

    public static void carregarJogo() throws Exception {

        try {
            FileInputStream arqv = new FileInputStream("lindorpg.dat");
            //manda p construtor... p criar arqv com esse nome no final
            ObjectInputStream arqvCarregar = new ObjectInputStream(arqv);
            //manda p construtor de objectoutputstream

            Player meuPlayer = (Player) arqvCarregar.readObject();
            System.out.println("Jogador carregado!");
            MapaAtual.setJogador(meuPlayer);

        } catch(IOException | ClassNotFoundException e){
            throw new Exception("Algum erro ocorreu recarregando o jogo!");
        }

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("itens.dat"))) {

            ArrayList<Item> itens = (ArrayList<Item>) entrada.readObject();

            System.out.println("Itens carregados:");
            for (Item s : itens) {
                //System.out.println(s.getDescricao());
                //item sem descrição?
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Falha abrindo arquivo de salas.");
        }

        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("inimigos.dat"))){
            ArrayList<Inimigo> inimigos = (ArrayList<Inimigo>) entrada.readObject();

            System.out.println("Inimigos carregados:");
            for (Inimigo inimigo : inimigos){
                System.out.println(inimigo.getNome());
            }

        } catch (IOException e){
            System.out.println("Falha abrindo arquivo para carregar inimigos.");
        } catch (ClassNotFoundException e){
            System.out.println("Falha lendo arquivo de inimigos.");
        }

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("salas.dat"))) {

            ArrayList<Sala> salas = (ArrayList<Sala>) entrada.readObject();

            System.out.println("Salas carregadas:");
            for (Sala s : salas) {
                System.out.println(s.getDescricao());
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Falha abrindo arquivo de salas.");
        }

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("npcs.dat"))) {
            ArrayList<NPC> npcs = (ArrayList<NPC>) entrada.readObject();

            System.out.println("NPCs carregados:");
            for (NPC npc : npcs) {
                System.out.println(npc.getNome());
            }
        } catch (IOException e) {
            System.out.println("Falha abrindo arquivo para carregar NPCs.");
        } catch (ClassNotFoundException e) {
            System.out.println("Falha lendo arquivo de NPCs.");
        }


    }

}