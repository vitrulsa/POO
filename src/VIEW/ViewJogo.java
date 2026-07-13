package VIEW;

import CONTROLLER.ControllerAcao;
import CONTROLLER.ControllerJogo;
import MODEL.Arquivo;
import MODEL.mapa.MapaAtual;
import MODEL.personagens.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewJogo {
    public static void iniciarJogo(){
        interpretadorComandos();
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

    public static void mostrarStatus(){
        System.out.println("HP: " + ControllerJogo.getPlayer().getHp() + " / " + ControllerJogo.getPlayer().getMaxHp());
        System.out.println("Mana: " + ControllerJogo.getPlayer().getManaAtual() + " / " + ControllerJogo.getPlayer().getManaMax());
        System.out.println("Ouro: " + ControllerJogo.getPlayer().getOuro());
    }

    public static void interpretadorComandos(){
        while(true) {
            mostrarComandos();
            mostrarStatus();
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
                    try{
                        ControllerAcao.ver();
                    } catch(Exception e){
                        System.out.println("Erro tentando ver a sala. Tente novamente.");
                    }
                    break;

                case "2": // falar
                    try{
                        if(ControllerAcao.falar() == false){
                            System.out.println("Você está numa luta!\nVai falar com quem, o inimigo?!");
                        }

                        if (ControllerAcao.turnoInimigos()){
                            System.out.println("Você morreu.");
                            return;
                        }
                    } catch (Exception e) {
                        System.out.println("Erro tentando falar. Tente novamente.");
                    }
                    break;

                case "3": // atacar
                    try{
                        ControllerAcao.atacar();
                        ControllerJogo.setEstadoCombate();
                        if (ControllerAcao.turnoInimigos()){
                            System.out.println("Você morreu.");
                            return;
                        }
                    } catch(Exception e){
                        System.out.println("Erro tentando atacar. Tente novamente.");
                    }


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
                        try{
                            ControllerAcao.usarItem();
                            if (ControllerAcao.turnoInimigos()){
                                System.out.println("Você morreu.");
                                return;
                            }
                        } catch(Exception e){
                            System.out.println("Erro tentando usar item. Tente novamente.");
                        }
                    }
                    else if (opcao == 2){ // usar magia
                        try{
                            ControllerAcao.usarMagia();
                            ControllerJogo.setEstadoCombate();
                            if (ControllerAcao.turnoInimigos()){
                                System.out.println("Você morreu.");
                                return;
                            }
                        } catch(Exception e){
                            System.out.println("Erro tentando usar magia. Tente novamente.");
                        }
                    }
                    break;

                case "6":
                    try{
                        ControllerAcao.equipar();
                    } catch (Exception e) {
                        System.out.println("Erro tentando equipar arma. Tente novamente.");
                    }
                    break;

                case "7":
                    ControllerAcao.magias();
                    break;

                case "8":
                    System.out.println("Fechando jogo...");
                    try {
                        Arquivo.salvarJogo();
                        System.out.println("O jogo foi salvo...");
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    return;

                case "c", "b", "d", "e":
                    try{

                        ControllerJogo.setEstadoCombate();
                        if(ControllerAcao.mover(comando) == false){
                            System.out.println("Você está em combate!\nFugir é covardia!");
                            break;
                        }

                        switch (comando){
                            case "c":
                                System.out.println("Andando para cima...");
                                break;
                            case "e":
                                System.out.println("Andando para esquerda...");
                                break;
                            case "d":
                                System.out.println("Andando para direita...");
                                break;
                            case "b":
                                System.out.println("Andando para baixo...");
                                break;
                        }
                    } catch (Exception e){
                        System.out.println("Tentativa de movimento inválido!");
                    }
                    break;
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

}
