package MODEL.mapa;

import MODEL.personagens.Inimigo;
import MODEL.personagens.Item;
import MODEL.personagens.NPC;
import MODEL.personagens.iInfoBasica;

import java.io.Serializable;
import java.util.ArrayList;

public class Sala  implements Serializable {
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

        //interface pois talvez possamos usar p mais coisas almém de nomes!!!!

        ArrayList<iInfoBasica> ObjetosSala = new ArrayList<>();
        ObjetosSala.addAll(arrayInimigo);
        ObjetosSala.addAll(arrayItem);
        ObjetosSala.addAll(arrayNPC);

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

    public String getDescricao() { return descricao; }

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
