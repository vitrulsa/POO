package VIEW;

import CONTROLLER.ControllerAcao;
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

    public static void checarCenario(Sala sala){
        ArrayList<iInfoBasica> visualizarNomes = ControllerAcao.checarCenario(sala);

        Iterator<iInfoBasica> i = visualizarNomes.iterator();
        while (i.hasNext()){

            iInfoBasica k = i.next();

            if(k.getClasseString().equals(Inimigo.class.toString())){
                System.out.println("Inimigo! " + k.getNome());
            }
            if(k.getClasseString().equals(NPC.class.toString())){
                System.out.println("NPC! " + k.getNome());
            }
            if(k.getClasseString().equals(Item.class.toString())){
                System.out.println("Item! " + k.getNome());
            }

        }

    }

}
