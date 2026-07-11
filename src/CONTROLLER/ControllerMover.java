package CONTROLLER;

import MODEL.mapa.Sala;
import MODEL.mapa.LigacoesMapa;

public class ControllerMover {

    static void andarEsquerda(){ //me dê sala atual e te digo pra onde tu irás
        Sala sala; //preciso receber a sala atual de alguma forma!!!
        LigacoesMapa.moverSalaEsq(sala);
    }
    static void andarDireita(){
        Sala sala;
        LigacoesMapa.moverSalaDir(sala);
    }
    static void andarCima(){
        Sala sala;
        LigacoesMapa.moverSalaCima(sala);
    }
    static void andarBaixo(){
        Sala sala;
        LigacoesMapa.moverSalaBaixo(sala);
    }

}