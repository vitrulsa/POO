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
            MapaAtual.setPlayer(meuPlayer);
            ControllerJogo.setMeuPlayer(meuPlayer);

        } catch(IOException | ClassNotFoundException e){
            throw new Exception("Algum erro ocorreu recarregando o jogo.\nTem certeza que tem o arquivo do jogo?\n" + e);

        }

        new ControllerInicializar();

    }

}