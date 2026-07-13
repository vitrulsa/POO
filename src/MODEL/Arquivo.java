package MODEL;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import CONTROLLER.ControllerInicializar;
import CONTROLLER.ControllerJogo;
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
            arqvSalvar.writeObject(MapaAtual.getPlayer());

            FileOutputStream arqv2 = new FileOutputStream("local.dat");
            //manda p construtor... p criar arqv com esse nome no final
            ObjectOutputStream arqvSalvar2 = new ObjectOutputStream(arqv);
            //manda p construtor de objectoutputstream
            arqvSalvar2.writeObject(MapaAtual.getPlayer().getSalaAtual());


            FileOutputStream arqv3 = new FileOutputStream("inventario.dat");
            //manda p construtor... p criar arqv com esse nome no final
            ObjectOutputStream arqvSalvar3 = new ObjectOutputStream(arqv);
            //manda p construtor de objectoutputstream
            arqvSalvar3.writeObject(MapaAtual.getPlayer().getInventario());

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
            System.out.println("Jogador carregado! " + meuPlayer.getNome());
            //tudo pega daqui

            FileInputStream arqv2 = new FileInputStream("local.dat");
            //manda p construtor... p criar arqv com esse nome no final
            ObjectInputStream arqvSalvar2 = new ObjectInputStream(arqv);
            //manda p construtor de objectoutputstream
            Sala salaAtual = (Sala) arqvSalvar2.readObject();



            FileInputStream arqv3 = new FileInputStream("inventario.dat");
            //manda p construtor... p criar arqv com esse nome no final
            ObjectInputStream arqvSalvar3 = new ObjectInputStream(arqv);
            //manda p construtor de objectoutputstream
            ArrayList<Item> inventario = (ArrayList<Item>) arqvSalvar3.readObject();

            meuPlayer.setSalaAtual(salaAtual);
            meuPlayer.setInventario(inventario);
            MapaAtual.setPlayer(meuPlayer);

        } catch(IOException | ClassNotFoundException e){
            throw new Exception("Algum erro ocorreu recarregando o jogo.\nTem certeza que tem o arquivo do jogo?\n" + e);


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