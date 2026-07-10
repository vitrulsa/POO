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

        ArrayList<Inimigo> arrayInimigo = sala.getInimigoNaSala();
        Iterator<Inimigo> inimigoIterator = arrayInimigo.iterator();

        ArrayList<Item> arrayItem = sala.getItemNaSala();
        Iterator<Item> itemIterator = arrayItem.iterator();

        ArrayList<NPC> arrayNPC = sala.getNpcNaSala();
        Iterator<NPC> NPCIterator = arrayNPC.iterator();

        Object[] nome = new Object[arrayInimigo.size() + arrayItem.size() + arrayNPC.size()];

        int i = 0;
        if(arrayInimigo.isEmpty() == false) {
            while (inimigoIterator.hasNext()) {
                nome[i] = inimigoIterator.next().getNome();
                i++;
            }
        }

        if(arrayItem.isEmpty() == false) {
            while (itemIterator.hasNext()) {
                nome[i] = inimigoIterator.next().getNome();
                i++;
            }
        }

        if(arrayNPC.isEmpty() == false) {
            while (NPCIterator.hasNext()) {
                nome[i] = NPCIterator.next().getNome();
                i++;
            }
        }

        return nome;
        //sla, nao gostei... queria divisao entr nome p saber o q é item vs o q é inimigo...
    }
}
