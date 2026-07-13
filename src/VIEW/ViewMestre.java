package VIEW;

import CONTROLLER.ControllerJogo;
import CONTROLLER.ControllerMestre;
import MODEL.personagens.Magia;
import MODEL.personagens.Player;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewMestre {

    public static void abrirMenu() {
        Player p = ControllerJogo.getPlayer();

        // Verifica se a classe possui permissão para aprender magias
        if (!p.getClasse().equals("Mago") && !p.getClasse().equals("Patrulheiro")) {
            System.out.println("\nMestre Arcano: Sinto muito, jovem. Sua classe (" + p.getClasse() + ") foca no físico e não possui a afinidade necessária para dominar o arcano.");
            return;
        }

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MESTRE ARCANO =====");
            System.out.println("Seu Ouro: " + p.getOuro());
            System.out.println("[1] Aprender nova Magia (Custo: 30 moedas)");
            System.out.println("[2] Sair");
            System.out.print("> ");

            try {
                String entrada = s.nextLine();
                int opcao = Integer.parseInt(entrada.trim());

                if (opcao == 1) {
                    menuAprender(s, p);
                } else if (opcao == 2) {
                    System.out.println("Mestre Arcano: Que o conhecimento ilumine seu caminho!");
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
            }
        }
    }

    private static void menuAprender(Scanner s, Player p) {
        ArrayList<Magia> magias = ControllerMestre.getMagiasDisponiveis();
        ArrayList<Magia> magiasParaAprender = new ArrayList<>();

        //  oferece apenas magias que o jogador ainda não sabe
        for (Magia m : magias) {
            if (p.getMagia(m.getNome()) == null) {
                magiasParaAprender.add(m);
            }
        }

        if (magiasParaAprender.isEmpty()) {
            System.out.println("\nMestre Arcano: Incrível! Você já domina todas as magias que eu posso ensinar.");
            return;
        }

        int preco = 30; // Preço fixo de uma magia

        System.out.println("\n--- MAGIAS DISPONÍVEIS (" + preco + " moedas cada) ---");
        for (int i = 0; i < magiasParaAprender.size(); i++) {
            Magia m = magiasParaAprender.get(i);
            System.out.println("[" + (i + 1) + "] " + m.getNome() + " (Tipo: " + m.getTipo() + ", Dano: " + m.getDano() + ")");
        }
        System.out.println("[0] Voltar");
        System.out.print("> ");

        try {
            String entrada = s.nextLine();
            int escolha = Integer.parseInt(entrada.trim());
            if (escolha == 0) return;

            if (escolha > 0 && escolha <= magiasParaAprender.size()) {
                Magia magiaEscolhida = magiasParaAprender.get(escolha - 1);

                if (p.getOuro() < preco) {
                    System.out.println("Ouro insuficiente! Estudar o arcano custa " + preco + " moedas.");
                } else {
                    ControllerMestre.aprenderMagia(magiaEscolhida, preco);
                    System.out.println("Sucesso! Você dominou a magia: " + magiaEscolhida.getNome() + "!");
                }
            } else {
                System.out.println("Opção inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
        }
    }
}