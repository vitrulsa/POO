package VIEW;

import CONTROLLER.ControllerAcao;

import java.util.Scanner;

public class ViewJogo {
    public static void iniciarJogo(){

    }

    public static void interpretadorComandos(){
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("> ");

            String comando = scanner.nextLine().toLowerCase();
            String[] args = comando.split(" ");

            /*
            VER
            FALAR <alvo>
            ATACAR <alvo>
            INVENTARIO
            USAR <item>
            EQUIPAR
            MAGIAS
            USAR <magia> <alvo>
            TERMINAR
             */

            switch (args[0]) {
                case "ver":
                    ControllerAcao.ver();
                    break;
                case "falar":
                    if (args.length > 1){
                        ControllerAcao.falar(args[1]);
                    }
                    break;
                case "atacar":
                    ControllerAcao.atacar();
                    break;
                case "inventario":
                    ControllerAcao.inventario();
                    break;
                case "usar":
                    if (args.length < 3){
                        ControllerAcao.usarItem();
                    } else
                        ControllerAcao.usarMagia();
                    break;
                case "equipar":
                    if (args.length > 1){
                        ControllerAcao.falar(args[1]);
                    }
            }
        }
    }
}
