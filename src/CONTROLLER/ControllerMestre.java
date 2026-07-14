package CONTROLLER;

import MODEL.personagens.Magia;
import MODEL.personagens.Player;
import java.util.ArrayList;

// mestre arcano
public class ControllerMestre {

    public static ArrayList<Magia> getMagiasDisponiveis() {
        return new ArrayList<>(ControllerInicializar.getBancoMagias().getBanco());
    }

    public static boolean aprenderMagia(Magia magia, int preco) {
        Player p = ControllerJogo.getPlayer();
        if (p.getOuro() >= preco) {
            p.setOuro(p.getOuro() - preco);
            p.setMagia(magia); // Adiciona a magia no ArrayList do Player
            return true;
        }
        return false;
    }
}