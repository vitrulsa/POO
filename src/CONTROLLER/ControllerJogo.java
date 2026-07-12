package CONTROLLER;

import MODEL.Inicializar;
import MODEL.personagens.Player;
import VIEW.ViewJogo;

public class ControllerJogo {

    private static int NUM_INIMIGOSINICIAL = 10;
    private static int NUM_NPCINICIAL = 10;
    private static int NUM_ITEMINICIAL = 10;
    private static int NUM_MAGIAINICIAL = 10;
    private static int NUM_SALAS = 1;
    private static Player meuPlayer;

    public static void Inicializar() {
        //Inicializar.criarInimigo(NUM_INIMIGOSINICIAL);
        //Inicializar.criarNPC(NUM_NPCINICIAL);
        //Inicializar.criarItem(NUM_ITEMINICIAL);
        //Inicializar.criarMagia(NUM_MAGIAINICIAL);
        //p isso precisa de banco!

        meuPlayer = Inicializar.criarPlayer();

       // meuPlayer.setSalaAtual(Inicializar.mapaInicial(Inicializar.criarSalas(NUM_SALAS)));
        //mapainicial cria o mapa em si, dando ligações + dá de retorno a primeira sala de todas!

        //inventario já tá lá, é null
        //magias é a mesma coisa
    }

    public static void iniciarJogo(String nome, String raca, String classe){
        //Player player = new Player(nome, raca, ) terminar issaq
        ViewJogo.iniciarJogo();
    }

    public static void Salvar() {

    }

    public static Player getPlayer(){
        return meuPlayer;
    }
}