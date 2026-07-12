package CONTROLLER;

import MODEL.mapa.LigacoesMapa;
import MODEL.mapa.MapaAtual;
import MODEL.mapa.Sala;

public class ControllerMover {

    static void andar(char direcao){
        LigacoesMapa.moverSalaEsq(MapaAtual.getJogador().getSalaAtual());
    }
    static void andarDireita(){
        LigacoesMapa.moverSalaDir(MapaAtual.getJogador().getSalaAtual());
    }
    static void andarCima(){
        LigacoesMapa.moverSalaCima(MapaAtual.getJogador().getSalaAtual());
    }
    static void andarBaixo(){
        LigacoesMapa.moverSalaBaixo(MapaAtual.getJogador().getSalaAtual());
    }

}