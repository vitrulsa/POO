package VIEW;

import CONTROLLER.ControllerAcao;
import CONTROLLER.ControllerJogo;
import MODEL.personagens.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewJogo {
    public static void iniciarJogo(){

    }

    public static void mostrarComandos(){
        String comandos= """
        [1] VER.
        [2] FALAR.
        [3] ATACAR.
        [4] INVENTARIO.
        [5] USAR.
        [6] EQUIPAR.
        [7] MAGIAS.
        [8] TERMINAR.
        """;

        System.out.print(comandos);
    }

    public static void interpretadorComandos(){
        while(true) {
            mostrarComandos();
            Scanner scanner = new Scanner(System.in);
            System.out.print("> ");

            String comando = scanner.nextLine().toLowerCase();
            /*
            1 VER
            2 FALAR <alvo>
            3 ATACAR <alvo>
            4 INVENTARIO
            5 USAR <item>
            5 USAR <magia> <alvo>
            6 EQUIPAR
            7 MAGIAS
            8 TERMINAR
             */

            switch (comando) {
                case "1": // ver
                    ControllerAcao.ver();
                    break;

                case "2": // falar

                    break;

                case "3": // atacar
                    ControllerAcao.atacar();
                    break;

                case "4": // inventario
                    ControllerAcao.inventario();
                    break;

                case "5": // usar
                    System.out.println("Você deseja usar um item ou magia? Digite o número da sua escolha.");
                    System.out.println("[1] Item.");
                    System.out.println("[2] Magia.");
                    int opcao = 0;
                    while (true) {
                        System.out.println("Digite o numero correspondente a opção que deseje.");
                        opcao = lerVariasOpcoes(comando, scanner, 2);
                        if (opcao != 0)
                            break;
                    }

                    if (opcao == 1){ // usar item
                        ControllerAcao.usarItem();
                    }
                    else if (opcao == 2){ // usar magia
                        ControllerAcao.usarMagia();
                    }
                    break;

                case "6":
                    if (args.length > 1){
                        ControllerAcao.equipar(args[1]);
                    } else{
                        System.out.println("Digite o nome da ARMA que deseja equipar.");
                    }
                    break;

                case "7":
                    ControllerAcao.magias();
                    break;

                case "8":
                    System.out.println("Fechando jogo...");
                    return;

                case "n", "s", "l", "o":
                    ControllerAcao.mover(comando);

                default:
                    System.out.println("Comando não reconhecido. Tente novamente.");
                    break;
            }
        }
    }

    public static int lerVariasOpcoes(String comando, Scanner scanner, int i){
        int x;
        System.out.print("> ");
        comando = scanner.nextLine().toLowerCase();
        try {
            x = Integer.parseInt(comando);
            if (x > 0 && x <= i)
                return x;
            else{
                System.out.println("Opção inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida.");
        }

        return 0;
    }

    public static int atacar(String comando, Scanner scanner){
        // pega os inimigos na sala
        ArrayList<Inimigo> inimigos = ControllerJogo.InimigosNaSala();
        int i = 0;
        for (Inimigo inimigo : inimigos){
            i++;
            System.out.println("[" + i + "] " + inimigo.getNome());
        }
        // se houver inimigos na sala, escolhe inimigo pra atacar
        if (i > 0){
            int opcao = 0;
            while (true) {
                System.out.println("Digite o numero correspondente ao inimigo que deseje atacar.");
                opcao = lerVariasOpcoes(comando, scanner, i);
                if (opcao != 0)
                    return opcao;
            }
        } else{
            // se nao houver inimigos na sala
            System.out.println("Não há inimigos na sala atual.");
            return 0;
        }
    }

}
