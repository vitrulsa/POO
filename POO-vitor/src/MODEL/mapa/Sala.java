package MODEL.mapa;

import MODEL.personagens.Inimigo;
import MODEL.personagens.Item;
import MODEL.personagens.NPC;
import MODEL.personagens.iInfoBasica;

import java.io.Serializable;
import java.util.ArrayList;

public class Sala implements Serializable {
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
    private String descricao;

    public Sala(String desc){
        this.descricao = desc;
    }

    public ArrayList<iInfoBasica> listarObjetos(){

        ArrayList<Inimigo> arrayInimigo = getInimigoNaSala();

        ArrayList<Item> arrayItem = getItemNaSala();

        ArrayList<NPC> arrayNPC = getNpcNaSala();

        ArrayList<iInfoBasica> ObjetosSala = new ArrayList<>();

        for(Inimigo i : arrayInimigo){
            ObjetosSala.add((iInfoBasica) i);
        }

        for(Item i : arrayItem){
            ObjetosSala.add((iInfoBasica) i);
        }

        for(NPC i : arrayNPC){
            ObjetosSala.add((iInfoBasica) i);
        }

        return ObjetosSala;

    }

    public String getDescricao() { return descricao; }

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

    public void setInimigoNaSala(Inimigo inimigo) {
        if(inimigoNaSala.size() < MAX_INIMIGO) inimigoNaSala.add(inimigo);
    }

    public void setItemNaSala(Item item) {

        if(itemNaSala.size() < MAX_ITEM) itemNaSala.add(item);
    }

    public void setEstadoSala(String estadoSala) {
        this.estadoSala = estadoSala;
    }

    public void setNpcNaSala(NPC npc) {

        if(npcNaSala.size() < MAX_NPC) npcNaSala.add(npc);
    }

}