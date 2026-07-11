package CONTROLLER;

import MODEL.personagens.InicializarPersonagens;

public class ControllerInicializar {

    private static int NUM_INIMIGOSINICIAL = 10;
    private static int NUM_NPCINICIAL = 10;
    private static int NUM_ITEMINICIAL = 10;
    private static int NUM_MAGIAINICIAL = 10;

    public static void ControllerInicializar() {
        InicializarPersonagens.criarInimigo(NUM_INIMIGOSINICIAL);
        InicializarPersonagens.criarNPC(NUM_NPCINICIAL);
        InicializarPersonagens.criarItem(NUM_ITEMINICIAL);
        InicializarPersonagens.criarMagia(NUM_MAGIAINICIAL);

        InicializarMapa
    }



}