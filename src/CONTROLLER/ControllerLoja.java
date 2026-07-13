package CONTROLLER;

import MODEL.personagens.Item;
import java.util.ArrayList;

public class ControllerLoja {
    private static ArrayList<Item> estoque = new ArrayList<>();
    private static boolean estoqueCarregado = false;

    public static void inicializarEstoque() {
        if(!estoqueCarregado) {
            Item pocaoVida = ControllerInicializar.getBancoItens().getDado("Poção de Vida");
            Item pocaoMana = ControllerInicializar.getBancoItens().getDado("Poção de Mana");
            Item chocolate = ControllerInicializar.getBancoItens().getDado("Chocolate");

            if (pocaoVida != null) estoque.add(pocaoVida);
            if (pocaoMana != null) estoque.add(pocaoMana);
            if (chocolate != null) estoque.add(chocolate);

            estoqueCarregado = true;
        }
    }

    public static ArrayList<Item> getEstoque() {
        return estoque;
    }

    public static boolean comprar(Item item) {
        if (ControllerJogo.getPlayer().getOuro() >= item.getValor()) {
            ControllerJogo.getPlayer().setOuro(ControllerJogo.getPlayer().getOuro() - item.getValor());
            ControllerJogo.getPlayer().getInventario().add(item);
            estoque.remove(item);
            return true;
        }
        return false;
    }

    public static void vender(Item item) {
        int valorVenda = item.getValor() / 2;
        ControllerJogo.getPlayer().setOuro(ControllerJogo.getPlayer().getOuro() + valorVenda);
        ControllerJogo.getPlayer().getInventario().remove(item);
        estoque.add(item);
    }
}