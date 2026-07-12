package VIEW;

import CONTROLLER.ControllerAcao;
import MODEL.personagens.Arma;
import MODEL.personagens.Item;
import MODEL.personagens.Magia;

import java.util.ArrayList;

public class ViewAcao {

    public static void exibirInventario(ArrayList<Item> inventario) {
        System.out.println("--- Inventário ---");
        for (Item item : inventario) {
            System.out.println(item);
        }
    }

    public static void exibirMagias(ArrayList<Magia> magias){
        System.out.println("--- Magias ---");
        for (Magia magia : magias) {
            System.out.println(magia);
        }
    }

    public static void equipou(Arma arma){
        if (arma == null)
            System.out.println("Arma não encontrada.");
        else
            System.out.println(arma.getNome() + " equipada com sucesso!");
    }
}
