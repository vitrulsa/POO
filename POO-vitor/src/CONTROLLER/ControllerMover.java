package CONTROLLER;

import MODEL.mapa.LigacoesMapa;
import MODEL.mapa.MapaAtual;
import MODEL.mapa.Sala;

public class ControllerMover {

    static void andarEsquerda(){ //me dê sala atual e te digo pra onde tu irás
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

