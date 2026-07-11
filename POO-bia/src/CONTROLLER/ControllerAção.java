package CONTROLLER;

import MODEL.mapa.Sala;
import MODEL.personagens.iInfoBasica;

import java.util.ArrayList;

public class ControllerAção {

    public static void atacar(){
        //cansei
    }

    public static ArrayList<iInfoBasica> checarCenário(Sala sala){
        return sala.listarObjetos();
        //sla, nao gostei... queria divisao entr nome p saber o q é item vs o q é inimigo...
    }
}
