package VIEW;

import CONTROLLER.ControllerAcao;
import CONTROLLER.ControllerJogo;
import MODEL.mapa.MapaAtual;
import MODEL.mapa.Sala;
import MODEL.personagens.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewAcao {

    public static void exibirInventario(ArrayList<Item> inventario) {
        System.out.println("--- Inventário ---");
        for (Item item : inventario) {
            System.out.println(item.getNome());
        }
    }

    public static void usarItem(ArrayList<Item> inventario) throws Exception {

        System.out.println("Escolha um item para utilizar:\n--- Inventário ---");
        int quantidade = 0;
        for (Item item : inventario) {
            System.out.println((inventario.indexOf(item) + 1) + ": " + item.getNome());
            quantidade++;
        }

        if (quantidade > 0){
            Scanner s = new Scanner(System.in);
            while(true){
                try {
                    int i = s.nextInt();

                    if (i > 0 && i <= quantidade){
                        ControllerAcao.usarItem(inventario.get(i));
                        break;
                    } else{
                        System.out.println("Insira um número de 1 à "+ quantidade);
                    }
                } catch (IncompatibleClassChangeError e) {
                    throw new Exception(e);
                } catch (InputMismatchException e) {
                    System.out.println("Insira um número de 1 à "+ quantidade);
                    throw new Exception(e);
                }
            }
        }

    }

    public static void atacar(ArrayList<Inimigo> inimigoNaSala) throws Exception {

        int i = escolherAlvo(inimigoNaSala);
        if (i > 0)
            ControllerAcao.atacar(ControllerJogo.getPlayer(), inimigoNaSala.get(i - 1), null);
    }

    public static void falar(ArrayList<NPC> NPCsNaSala) throws Exception{
        // pega os NPCs na sala
        int i = 0;
        for (NPC npc : NPCsNaSala){
            i++;
            System.out.println("[" + i + "] " + npc.getNome());
        }
        // se houver NPCS na sala, escolhe NPC pra falar
        if (i > 0){
            Scanner s = new Scanner(System.in);
            while(true){
                try {
                    int entrada = s.nextInt();

                    if (entrada > 0 && entrada <= i){
                        System.out.println(ControllerAcao.falar(NPCsNaSala.get(entrada)));
                        break;
                    }
                    else
                        System.out.println("Insira um número de 1 à "+ i);
                } catch (IncompatibleClassChangeError e) {
                    throw new Exception(e);
                } catch (InputMismatchException e) {
                    System.out.println("Insira um número de 1 à "+ i);
                    throw new Exception(e);
                }
            }
        } else{
            // se nao houver NPCs na sala
            System.out.println("Não há NPCS na sala atual.");
        }
    }

    public static void usarMagia(ArrayList<Magia> magias) throws Exception {
        // se nao tiver mana
        if (ControllerJogo.getPlayer().getManaAtual() == 0) {
            System.out.println("Não possui mana!");
            return;
        }

        // mostrar as magias que o player possui
        int i = 0;
        for (Magia magia : magias){
            i++;
            System.out.println("[" + i + "] " + magia.getNome());
        }
        // se player possuir magias
        if (i > 0){
            Scanner s = new Scanner(System.in);
            while (true){
                try {
                    int entrada = s.nextInt();

                    if (entrada > 0 && entrada <= i){
                        ControllerAcao.usarMagia(magias.get(entrada - 1));
                        break;
                    }else
                        System.out.println("Insira um número de 1 à "+ i);
                } catch (IncompatibleClassChangeError e) {
                    throw new Exception(e);
                } catch (InputMismatchException e) {
                    System.out.println("Insira um número de 1 à "+ i);
                    throw new Exception(e);
                }
            }
        } else{
            // se nao houver magias
            System.out.println("Você não conhece magias.");
        }
    }

    public static int escolherAlvo(ArrayList<Inimigo> inimigoNaSala) throws Exception{
        int quantidade = 0;
        for (Inimigo inimigo : inimigoNaSala) {
            System.out.println((inimigoNaSala.indexOf(inimigo) + 1) + ": " + inimigo.getNome());
            quantidade++;
        }

        if (quantidade > 0){
            System.out.println("Quem você vai atacar primeiro?");
            Scanner s = new Scanner(System.in);
            try {
                int i = s.nextInt();

                if (i > 0 && i <= quantidade)
                    return i;
                else {
                    System.out.println("Insira um número de 1 à " + quantidade);
                    return 0;
                }
            } catch (IncompatibleClassChangeError e) {
                throw new Exception(e);
            } catch (InputMismatchException e) {
                System.out.println("Insira um número de 1 à "+ quantidade);
                throw new Exception(e);
            }
        } else{
            // se nao houver inimigos na sala
            System.out.println("Não há inimigos na sala atual.");
            return 0;
        }
    }

    public static void verCenario(Sala salaAtual) throws Exception {
        System.out.println(salaAtual.getDescricao());

        ArrayList<iInfoBasica> listaObjetos = ControllerAcao.checarCenario(salaAtual);
        System.out.println("Nessa sala, existem: ");

        int quantidade = 0;
        for(iInfoBasica objetos : listaObjetos){
            System.out.println((listaObjetos.indexOf(objetos)+1) + ": " + objetos.getClasseString() + "! "+ objetos.getNome());
            quantidade += 1;
        }

        if (quantidade == 0) {
            System.out.println("Nada");
            return;
        }

        System.out.println("Você deseja ver alguma descrição?");

        Scanner s = new Scanner(System.in);
        try {
            while (true){
                int d = s.nextInt();
                if (d > 0 && d <= quantidade){
                    System.out.println(listaObjetos.get(d).getNome() + ": " + listaObjetos.get(d).getDescricao());
                    break;
                } else{
                    System.out.println("Insira um número de 1 à " + quantidade + "!");
                }
            }
        } catch (IncompatibleClassChangeError e) {
            throw new Exception(e);
        } catch (InputMismatchException e) {
            System.out.println("Insira um número de 1 à "+ listaObjetos.size() + "!");
            throw new Exception(e);
        }

    }

    public static void exibirMagias(ArrayList<Magia> magias){
        if (magias.isEmpty()){
            System.out.println("Você não possui magias.");
        } else{
            System.out.println("---Magias---");
            for (Magia magia : magias){
                System.out.println(magia.getNome() + ":" + magia.getDescricao());
            }
        }
    }

    public static void equipar(ArrayList<Item> inventario) throws Exception{
        System.out.println("Escolha uma arma para equipar:\n--- Inventário ---");
        ArrayList<Arma> armas = new ArrayList<>();
        int quantidade = 0;
        for (Item item : inventario) {
            if (item instanceof Arma arma){
                System.out.println("[" + quantidade + "] " + arma.getNome());
                armas.add(arma);
                quantidade++;
            }
        }

        if (quantidade > 0){
            Scanner s = new Scanner(System.in);
            while (true){
                try {
                    int i = s.nextInt();

                    if (i >0 && i <= quantidade){
                        ControllerAcao.equipar(armas.get(i));
                        break;
                    }else{
                        System.out.println("Insira um número de 1 à "+ quantidade);
                    }
                } catch (IncompatibleClassChangeError e) {
                    throw new Exception(e);
                } catch (InputMismatchException e) {
                    System.out.println("Insira um número de 1 à "+ quantidade);
                    throw new Exception(e);
                }
            }
        }

    }

    public static void dano(Personagem atacante, Personagem alvo, int dano){
        if (dano > 0){
            System.out.println(">>> " + atacante.getNome() + " acerta " + alvo.getNome() + " e causa " + dano + " de dano! <<<");

            if (alvo.getHp() <= 0){
                System.out.println(">>> " + alvo.getNome() + " morreu! <<<");
            }
        } else if (dano == 0) {
            System.out.println(">>> " + atacante.getNome() + " errou! <<<");
        }
    }
}