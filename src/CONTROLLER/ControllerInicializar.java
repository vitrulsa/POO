package CONTROLLER;

import MODEL.mapa.*;
import MODEL.personagens.*;
import MODEL.Inicializar;
import MODEL.*;

public class ControllerInicializar {

    private static int NUM_INIMIGOSINICIAL = 10;
    private static int NUM_NPCINICIAL = 10;
    private static int NUM_ITEMINICIAL = 10;
    private static int NUM_MAGIAINICIAL = 10;
    private static  int NUM_SALAS = 1;
    private static Player meuPlayer;

    public static void Inicializar() throws Exception {
        Arquivo.salvarBancos(Inicializar.criarBancos());

        meuPlayer = Inicializar.criarPlayer();

        meuPlayer.setSalaAtual(Inicializar.mapaInicial(Inicializar.criarSalas(NUM_SALAS)));
        //mapainicial cria o mapa em si, dando ligações + dá de retorno a primeira sala de todas!

        //inventario já tá lá, é null
        //magias é a mesma coisa

    }

    public static void atualizarPlayer(String nome, String raca, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias){
        meuPlayer.setNome(nome);
        meuPlayer.setRaca(raca);
        meuPlayer.setHp(hp);
        meuPlayer.setDefesa(defesa);
        meuPlayer.setForca(forca);
        meuPlayer.setDest(dest);
        meuPlayer.setManaAtual(manaMax);
        meuPlayer.setManaMax(manaMax);
        for (Magia magia : magias){
            meuPlayer.setMagia(magia);
        }
    }

    public static void Salvar() throws Exception {

        MapaAtual.getJogador();

        Arquivo.salvarJogo();
        //tratar na view ok?
    }
}