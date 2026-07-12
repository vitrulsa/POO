package VIEW;

import CONTROLLER.ControllerAcao;
import MODEL.mapa.MapaAtual;
import MODEL.personagens.Inimigo;
import MODEL.personagens.Item;
import MODEL.personagens.Personagem;

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

    public static void usarItemInventario(ArrayList<Item> inventario) throws Exception {

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

        System.out.println("Quem você vai atacar primeiro?");
        int quantidade = 0;
        for (Inimigo inimigo : inimigoNaSala) {
            System.out.println((inimigoNaSala.indexOf(inimigo) + 1) + ": " + inimigo.getNome());
            quantidade++;
        }

        try {
            Scanner s = new Scanner(System.in);
            int i = s.nextInt();

            ControllerAcao.atacar(atacante, inimigoNaSala.get(i));

        } catch (IncompatibleClassChangeError e) {
            throw new Exception(e);
        } catch (InputMismatchException e) {
            System.out.println("Insira um número de 1 à "+ quantidade);
            throw new Exception(e);
        }
    }

}
