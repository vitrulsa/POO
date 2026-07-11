package MODEL.mapa;

import MODEL.personagens.Inimigo;
import MODEL.personagens.Item;
import MODEL.personagens.NPC;
import MODEL.personagens.iInfoBasica;

import java.util.ArrayList;
import java.util.Iterator;

public class Sala {
    //1 sala qual quer. tem ligação com outras, inimigos, itens ou npcs.
    private int MAX_INIMIGO = 3;
    private int MAX_NPC = 3;
    private int MAX_ITEM = 3;

    private ArrayList<Inimigo> inimigoNaSala = new ArrayList<>(MAX_INIMIGO);
    private ArrayList<NPC> npcNaSala = new ArrayList<>(MAX_NPC);
    private ArrayList<Item> itemNaSala = new ArrayList<>(MAX_ITEM);

    Sala salaDireita;
    Sala salaEsquerda;
    Sala salaCima;
    Sala salaBaixo;
    private String estadoSala; //se é possível chegar na sala ou se precisa de uma chave antes
    //dá pra tirar se quiserem

    public iInfoBasica[] listarObjetos(){

        ArrayList<Inimigo> arrayInimigo = getInimigoNaSala();
        Iterator<Inimigo> inimigoIterator = arrayInimigo.iterator();

        ArrayList<Item> arrayItem = getItemNaSala();
        Iterator<Item> itemIterator = arrayItem.iterator();

        ArrayList<NPC> arrayNPC = getNpcNaSala();
        Iterator<NPC> NPCIterator = arrayNPC.iterator();

        iInfoBasica[] ObjetosSala = new iInfoBasica[arrayInimigo.size() + arrayItem.size() + arrayNPC.size()];
        //interface pois talvez possamos usar p mais coisas almém de nomes!!!!
        int i = 0;
        if(arrayInimigo.isEmpty() == false) {
            while (inimigoIterator.hasNext()) {
                ObjetosSala[i] = inimigoIterator.next();
                i++;
            }
        }

        if(arrayItem.isEmpty() == false) {
            while (itemIterator.hasNext()) {
                ObjetosSala[i] = inimigoIterator.next();
                i++;
            }
        }

        if(arrayNPC.isEmpty() == false) {
            while (NPCIterator.hasNext()) {
                ObjetosSala[i] = NPCIterator.next();
                i++;
            }
        }

        return ObjetosSala;

    }

    public ArrayList<Inimigo> getInimigoNaSala(){//retorna todos os inimigos para poder atacar um deles
        return inimigoNaSala;
    }

    public ArrayList<NPC> getNpcNaSala() {
        return npcNaSala;
    }

    public ArrayList<Item> getItemNaSala() {
        return itemNaSala;
    }

    public String getEstadoSala(){
        return estadoSala;
    }

    public void setInimigoNaSala(ArrayList<Inimigo> inimigoNaSala) {
        this.inimigoNaSala = inimigoNaSala;
    }

    public void setItemNaSala(ArrayList<Item> itemNaSala) {
        this.itemNaSala = itemNaSala;
    }

    public void setEstadoSala(String estadoSala) {
        this.estadoSala = estadoSala;
    }

    public void setNpcNaSala(ArrayList<NPC> npcNaSala) {
        this.npcNaSala = npcNaSala;
    }

}
