package VIEW;

import CONTROLLER.ControllerAcao;
import MODEL.personagens.Item;

import java.util.ArrayList;

public class ViewAcao {

    public static void exibirInventario(ArrayList<Item> inventario) {
        System.out.println("--- Inventário ---");
        for (Item item : inventario) {
            System.out.println(item);
        }
    }
}
