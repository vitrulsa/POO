package VIEW;

import CONTROLLER.ControllerJogo;
import CONTROLLER.ControllerLoja;
import MODEL.personagens.Item;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewLoja {

    public static void abrirLoja() {
        ControllerLoja.inicializarEstoque();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LOJA DO SILVIO =====");
            System.out.println("O teu Ouro: " + ControllerJogo.getPlayer().getOuro());
            System.out.println("[1] Comprar");
            System.out.println("[2] Vender");
            System.out.println("[3] Sair da Loja");
            System.out.print("> ");

            try {
                String entrada = s.nextLine();
                int opcao = Integer.parseInt(entrada.trim());

                if (opcao == 1) {
                    menuComprar(s);
                } else if (opcao == 2) {
                    menuVender(s);
                } else if (opcao == 3) {
                    System.out.println("Silvio: Volta sempre, eheh!");
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
            }
        }
    }

    private static void menuComprar(Scanner s) {
        ArrayList<Item> estoque = ControllerLoja.getEstoque();
        if (estoque.isEmpty()) {
            System.out.println("\nSilvio: Fiquei sem stock no momento! Mas compro os teus itens de volta se quiseres.");
            return;
        }

        System.out.println("\n--- COMPRAR ---");
        for (int i = 0; i < estoque.size(); i++) {
            Item item = estoque.get(i);
            System.out.println("[" + (i + 1) + "] " + item.getNome() + " - " + item.getValor() + " moedas");
        }
        System.out.println("[0] Voltar");
        System.out.print("> ");

        try {
            String entrada = s.nextLine();
            int escolha = Integer.parseInt(entrada.trim());
            if (escolha == 0) return;

            if (escolha > 0 && escolha <= estoque.size()) {
                Item itemEscolhido = estoque.get(escolha - 1);
                if (ControllerLoja.comprar(itemEscolhido)) {
                    System.out.println("Sucesso! Compraste " + itemEscolhido.getNome() + ".");
                } else {
                    System.out.println("Ouro insuficiente! O item custa " + itemEscolhido.getValor() + " moedas.");
                }
            } else {
                System.out.println("Opção inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }

    private static void menuVender(Scanner s) {
        ArrayList<Item> inventario = ControllerJogo.getPlayer().getInventario();
        if (inventario.isEmpty()) {
            System.out.println("\nNão tens itens no inventário para vender.");
            return;
        }

        System.out.println("\n--- VENDER (Recebes 50% do valor original) ---");
        for (int i = 0; i < inventario.size(); i++) {
            Item item = inventario.get(i);
            int valorRevenda = item.getValor() / 2;
            System.out.println("[" + (i + 1) + "] " + item.getNome() + " - Vender por " + valorRevenda + " moedas");
        }
        System.out.println("[0] Voltar");
        System.out.print("> ");

        try {
            String entrada = s.nextLine();
            int escolha = Integer.parseInt(entrada.trim());
            if (escolha == 0) return;

            if (escolha > 0 && escolha <= inventario.size()) {
                Item itemEscolhido = inventario.get(escolha - 1);
                ControllerLoja.vender(itemEscolhido);
                System.out.println("Vendeste " + itemEscolhido.getNome() + " por " + (itemEscolhido.getValor() / 2) + " moedas!");
            } else {
                System.out.println("Opção inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }
}