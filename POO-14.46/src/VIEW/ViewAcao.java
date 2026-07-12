

import CONTROLLER.ControllerAcao;
import MODEL.mapa.MapaAtual;
import MODEL.mapa.Sala;
import MODEL.personagens.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ViewAcao {

    public static void exibirInventario(ArrayList<Item> inventario) {
        System.out.println("--- Inventário ---");
        for (Item item : inventario) {
            System.out.println(item.getNome());
        }
    }

    public static void usarItemInventario(ArrayList<Item> inventario) throws Exception {

        System.out.println("Escolha um item para utilizar:\n--- Inventário ---");
        for (Item item : inventario) {
            System.out.println((inventario.indexOf(item) + 1) + ": " + item.getNome());
        }

        try {
            Scanner s = new Scanner(System.in);
            int i = s.nextInt();

            ControllerAcao.usarItem(inventario.get(i));
        } catch (IncompatibleClassChangeError e) {
            throw new Exception(e);
        } catch (InputMismatchException e) {
            System.out.println("Insira um número de 1 à "+ inventario.size());
            throw new Exception(e);
        }
    }

    public static void atacar(Personagem atacante, ArrayList<Inimigo> inimigoNaSala) throws Exception {

        System.out.println("Quem você vai atacar primeiro?");
        for (Inimigo inimigo : inimigoNaSala) {
            System.out.println((inimigoNaSala.indexOf(inimigo) + 1) + ": " + inimigo.getNome());
        }

        try {
            Scanner s = new Scanner(System.in);
            int i = s.nextInt();

            ControllerAcao.atacar(atacante, inimigoNaSala.get(i));

        } catch (IncompatibleClassChangeError e) {
            throw new Exception(e);
        } catch (InputMismatchException e) {
            System.out.println("Insira um número de 1 à "+ inimigoNaSala.size() + "!");
            throw new Exception(e);
        }
    }

    public static void falarComNPC(ArrayList<NPC> NPCNaSala) throws Exception {

        System.out.println("Com quem você vai falar primeiro?");
        for (NPC npc : NPCNaSala) {
            System.out.println((NPCNaSala.indexOf(npc) + 1) + ": " + npc.getNome());
        }

        try {
            Scanner s = new Scanner(System.in);
            int i = s.nextInt();

            ControllerAcao.falar(NPCNaSala.get(i));

        } catch (IncompatibleClassChangeError e) {
            throw new Exception(e);
        } catch (InputMismatchException e) {
            System.out.println("Insira um número de 1 à "+ NPCNaSala.size() + "!");
            throw new Exception(e);
        }

    }

    public static void usarMagia(Personagem atacante, ArrayList<Magia> listaMagiaJogador, ArrayList<Inimigo> inimigoNaSala) throws Exception {

        System.out.println("Qual magia você vai usar?");
        for (Magia magia : listaMagiaJogador) {
            System.out.println((listaMagiaJogador.indexOf(magia) + 1) + ": " + magia.getNome());
        }

        try {
            Scanner s = new Scanner(System.in);
            int m = s.nextInt();

            System.out.println("Em quem você vai usar?");
            for (Inimigo inimigo : inimigoNaSala) {
                System.out.println((inimigoNaSala.indexOf(inimigo) + 1) + ": " + inimigo.getNome());
            }
            int i = s.nextInt();

            ControllerAcao.usarMagia(atacante, inimigoNaSala.get(m), listaMagiaJogador.get(i));

        } catch (IncompatibleClassChangeError e) {
            throw new Exception(e);
        } catch (InputMismatchException e) {
            System.out.println("Insira um número de 1 à "+ listaMagiaJogador.size() + "!");
            throw new Exception(e);
        }

    }

    public static void verCenario(Sala salaAtual) throws Exception {
        System.out.println(salaAtual.getDescricao());

        ArrayList<iInfoBasica> listaObjetos = ControllerAcao.checarCenario(salaAtual);
        System.out.println("Nessa sala, existem: ");

        for(iInfoBasica objetos : listaObjetos){
            System.out.println((listaObjetos.indexOf(objetos)+1) + ": " + objetos.getClasseString() + "! "+ objetos.getNome());
        }

        System.out.println("Você deseja ver alguma descrição?");

        try {
            Scanner s = new Scanner(System.in);
            int d = s.nextInt();
            System.out.println(listaObjetos.get(d).getNome() + ": " + listaObjetos.get(d).getDescricao());

        } catch (IncompatibleClassChangeError e) {
            throw new Exception(e);
        } catch (InputMismatchException e) {
            System.out.println("Insira um número de 1 à "+ listaObjetos.size() + "!");
            throw new Exception(e);
        }

    }

}
