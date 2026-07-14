package MODEL.personagens;

import MODEL.mapa.Sala;

import java.util.ArrayList;

public class Player extends Personagem{
    private int max_hp;
    private ArrayList<Item> inventario = new ArrayList<Item>();
    private String classe;
    private Sala salaAtual;
    private String descricao;
    private int ouro;



    public Player(String nome, String raca, String classe, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias) {
        super(nome, raca, hp, defesa, forca, dest, manaMax, magias);
        this.classe = classe;
        this.max_hp = hp;
        this.ouro = 20;
    }

    public String getClasse() {
        return classe;
    }


    @Override
    public void atacar() {

    }

    @Override
    public void usarMagia() {

    }

    public ArrayList<Item> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Item> inventario){
        this.inventario = inventario;
    }

    @Override
    public String getClasseString() {
        return "";
    }

    public void setSalaAtual(Sala sala){
        salaAtual = sala;
    }

   

    public boolean possuiChave(){ // para abrir a porta
        for(Item item : inventario){
            if(item instanceof Consumivel consumivel){
                if(consumivel.getNome().equals("Chave"))
                    return true;
            }
        }
        return false;
    }

    public boolean possuiChocolate(){ // final secreto
        for(Item item : inventario){
            if(item instanceof Consumivel consumivel){
                if(consumivel.getNome().equals("Chocolate"))
                    return true;
            }
        }
        return false;
    }

    public Sala getSalaAtual(){
        return salaAtual;
    }

    @Override
    public String getDescricao(){
        return descricao;
    }

    @Override
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public int getOuro() { return ouro; }
    public void setOuro(int ouro) { this.ouro = ouro; }
    public int getMaxHp(){ return max_hp; }
}
