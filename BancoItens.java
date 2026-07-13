package CONTROLLER;

import MODEL.mapa.LigacoesMapa;
import MODEL.mapa.MapaAtual;
import MODEL.mapa.Sala;

public class ControllerMover {

    static void andar(char direcao){
        LigacoesMapa.moverSalaEsq(MapaAtual.getPlayer().getSalaAtual());
    }
    static void andarDireita(){
        LigacoesMapa.moverSalaDir(MapaAtual.getPlayer().getSalaAtual());
    }
    static void andarCima(){
        LigacoesMapa.moverSalaCima(MapaAtual.getPlayer().getSalaAtual());
    }
    static void andarBaixo(){
        LigacoesMapa.moverSalaBaixo(MapaAtual.getPlayer().getSalaAtual());
    }

}