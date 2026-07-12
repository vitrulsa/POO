package MODEL.personagens;

import MODEL.mapa.Sala;

import java.util.ArrayList;

public class Player extends Personagem{

    private ArrayList<Item> inventario = new ArrayList<Item>();
    private String classe;
    private Sala salaAtual;

    public Player(String nome, String raca, String classe, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias) {
        super(nome, raca, hp, defesa, forca, dest, manaMax, magias);
        this.classe = classe;
    }


    @Override
    public void atacar() {

    }

    @Override
    public void usarMagia() {

    }


    public void exibirStatus() {
        System.out.println("--- Status de "+ this.getNome() + "---");
        System.out.println("HP: " + this.getHp());
        System.out.println("Estado: " + this.getEstado());
        System.out.println("Defesa: " + this.getDefesa());
        System.out.println("Força: " + this.getForca());
        System.out.println("Destreza: " + this.getDest());
        System.out.println("Mana: " + this.getManaAtual() + "/" + this.getManaMax());
    }

    public ArrayList<Item> getInventario() {
        return inventario;
    }

    @Override
    public String getClasseString() {
        return "";
    }

    public void setSalaAtual(Sala sala){
        salaAtual = sala;
    }
    public Sala getSalaAtual(){
        return salaAtual;
    }
}
