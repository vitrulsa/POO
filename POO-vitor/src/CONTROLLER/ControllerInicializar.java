package CONTROLLER;

import MODEL.mapa.*;
import MODEL.personagens.*;
import MODEL.Inicializar;
import MODEL.*;

public class ControllerInicializar {

    public static void Salvar() throws Exception {

        MapaAtual.getJogador();

        Arquivo.salvarJogo();
    }
}