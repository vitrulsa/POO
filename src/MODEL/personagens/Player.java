package MODEL.personagens;

import java.util.ArrayList;

public class Player extends Personagem{

    private ArrayList<Item> inventario = new ArrayList<Item>();

    public Player(String nome, String raca, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias) {
        super(nome, raca, hp, defesa, forca, dest, manaMax, magias);
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

    public void exibirInventario() {
        System.out.println("--- Inventário ---");
        for (Item item : inventario) {
            System.out.println(item);
        }
    }

    @Override
    public String getClasseString() {
        return "";
    }

}
