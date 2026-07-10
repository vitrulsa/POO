package CONTROLLER;

import MODEL.mapa.Sala;
import MODEL.mapa.SalaNode;
import VIEW.ViewCenario;

import java.util.Iterator;

public class ControllerMover {

    static void andarEsquerda(){ //me dê sala atual e te digo pra onde tu irás
        Sala sala; //preciso receber a sala atual de alguma forma!!!
        SalaNode.moverSalaEsq(sala);
    }
    static void andarDireita(){
        Sala sala;
        SalaNode.moverSalaDir(sala);
    }
    static void andarCima(){
        Sala sala;
        SalaNode.moverSalaCima(sala);
    }
    static void andarBaixo(){
        Sala sala;
        SalaNode.moverSalaBaixo(sala);
    }

}

