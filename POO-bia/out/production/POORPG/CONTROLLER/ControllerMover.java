package CONTROLLER;

import MODEL.mapa.MapaAtual;
import MODEL.mapa.Sala;
import MODEL.mapa.LigacoesMapa;

public class ControllerMover {

    static void andarEsquerda(){ //me dê sala atual e te digo pra onde tu irás
        LigacoesMapa.moverSalaEsq(MapaAtual.getJogador().getSalaAtual());
    }
    static void andarDireita(){
        Sala sala;
        LigacoesMapa.moverSalaDir(MapaAtual.getJogador().getSalaAtual());
    }
    static void andarCima(){
        Sala sala;
        LigacoesMapa.moverSalaCima(MapaAtual.getJogador().getSalaAtual());
    }
    static void andarBaixo(){
        Sala sala;
        LigacoesMapa.moverSalaBaixo(MapaAtual.getJogador().getSalaAtual());
    }

}