package CONTROLLER;

import MODEL.mapa.Sala;
import MODEL.personagens.Inimigo;
import MODEL.personagens.Item;
import MODEL.personagens.NPC;

import java.util.ArrayList;
import java.util.Iterator;

public class ControllerAção {

    static void atacar(){
        //cansei
    }

    static Object[] checarCenário(Sala sala){
        return sala.listarObjetos();
        //sla, nao gostei... queria divisao entr nome p saber o q é item vs o q é inimigo...
    }
}
