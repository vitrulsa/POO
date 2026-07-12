package MODEL;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import MODEL.personagens.*;
import MODEL.bancodados.*;
import MODEL.mapa.*;

public class Arquivo {

    public static void salvarJogo() throws Exception {
        try {

            MapaAtual mapa = new MapaAtual();

            FileOutputStream arqv = new FileOutputStream("lindorpg.dat");
            //manda p construtor... p criar arqv com esse nome no final
            ObjectOutputStream arqvSalvar = new ObjectOutputStream(arqv);
            //manda p construtor de objectoutputstream
            arqvSalvar.writeObject(mapa.getJogador());

        } catch (IOException e) {
            throw new Exception("Algo deu errado salvando o jogo!");
        }
    }

    public static void salvarBancos(ArrayList<Object> bancos) throws Exception {
        //coloquei separado para ser feito só uma vez sla
        try {
            FileOutputStream arqv = new FileOutputStream("lindorpg.dat");
            //manda p construtor... p criar arqv com esse nome no final
            ObjectOutputStream arqvSalvar = new ObjectOutputStream(arqv);
            //manda p construtor de objectoutputstream
            arqvSalvar.writeObject(bancos);

        } catch (IOException e) {
            throw new Exception("Algo deu errado salvando bancos!");
        }

    }

    public static void carregarJogo() throws Exception {

        try {
            FileInputStream arqv = new FileInputStream("lindorpg.dat");
            //manda p construtor... p criar arqv com esse nome no final
            ObjectInputStream arqvCarregar = new ObjectInputStream(arqv);
            //manda p construtor de objectoutputstream

            ArrayList<Object> arrayElementos = (ArrayList<Object>) arqvCarregar.readObject();

            Iterator<Object> i = arrayElementos.iterator();

            while(i.hasNext()){
                Object k = i.next();

                if(k instanceof Player){
                    MapaAtual.setJogador((Player) k);
                }
                if(k instanceof BancoItens){
                    MapaAtual.setBancos(k);
                }
                if(k instanceof BancoMagia){
                    MapaAtual.setBancos(k);
                }
                if(k instanceof BancoInimigo){
                    MapaAtual.setBancos(k);
                }

            }

        } catch(IOException | ClassNotFoundException e){
            throw new Exception("Algum erro ocorreu recarregando o jogo!");
        }
    }

}