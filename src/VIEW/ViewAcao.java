package VIEW;

import CONTROLLER.ControllerAcao;
import CONTROLLER.ControllerJogo;
import MODEL.mapa.MapaAtual;
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

        try {
            Scanner s = new Scanner(System.in);
            int i = s.nextInt();

            ControllerAcao.usarItem(inventario.get(i));
        } catch (IncompatibleClassChangeError e) {
            throw new Exception(e);
        } catch (InputMismatchException e) {
            System.out.println("Insira um número de 1 à "+ quantidade);
            throw new Exception(e);
        }
    }

    public static void atacar(Personagem atacante, ArrayList<Inimigo> inimigoNaSala) throws Exception {

        int i = escolherAlvo(inimigoNaSala);
        if (i > 0)
            ControllerAcao.atacar(inimigoNaSala.get(i - 1));
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
            try {
                Scanner s = new Scanner(System.in);
                int entrada = s.nextInt();

                if (entrada > 0 && entrada <= i)
                    ControllerAcao.falar(NPCsNaSala.get(entrada));
                else
                    System.out.println("Insira um número de 1 à "+ i);
            } catch (IncompatibleClassChangeError e) {
                throw new Exception(e);
            } catch (InputMismatchException e) {
                System.out.println("Insira um número de 1 à "+ i);
                throw new Exception(e);
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
            try {
                Scanner s = new Scanner(System.in);
                int entrada = s.nextInt();

                if (entrada > 0 && entrada <= i)
                    ControllerAcao.usarMagia(magias.get(entrada - 1));
                else
                    System.out.println("Insira um número de 1 à "+ i);
            } catch (IncompatibleClassChangeError e) {
                throw new Exception(e);
            } catch (InputMismatchException e) {
                System.out.println("Insira um número de 1 à "+ i);
                throw new Exception(e);
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
            try {
                Scanner s = new Scanner(System.in);
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
}