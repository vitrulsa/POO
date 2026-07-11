package VIEW;

import CONTROLLER.ControllerAção;
import CONTROLLER.ControllerMover;
import MODEL.mapa.Sala;
import MODEL.personagens.Inimigo;
import MODEL.personagens.Item;
import MODEL.personagens.NPC;
import MODEL.personagens.iInfoBasica;

import java.util.ArrayList;
import java.util.Iterator;

public class ViewCenario {

    public static void mostrarDirecao(String direcao){
        System.out.println("Você foi para "+ direcao + ".");
    }

    public static void checarCenário(Sala sala){
        iInfoBasica[] visualizarNomes = ControllerAção.checarCenário(sala);

        for(int i = 0; i < visualizarNomes.length; i++){

            if(visualizarNomes[i].getClasseString().equals(Inimigo.class.toString())){
                System.out.println("Inimigo! " + visualizarNomes[i].getNome());
            }
            if(visualizarNomes[i].getClasseString().equals(NPC.class.toString())){
                System.out.println("NPC! " + visualizarNomes[i].getNome());
            }
            if(visualizarNomes[i].getClasseString().equals(Item.class.toString())){
                System.out.println("Item! " + visualizarNomes[i].getNome());
            }

        }

    }

}
