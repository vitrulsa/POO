package MODEL.mapa;
import CONTROLLER.ControllerJogo;
import MODEL.bancodados.BancoItens;
import MODEL.bancodados.BancoMagia;
import MODEL.bancodados.BancoSala;
import MODEL.personagens.*;

import java.util.ArrayList;
import java.util.Objects;

public class MapaAtual {
    private static BancoSala bancoSala;

    private static LigacoesMapa ligacoesMapa;

    private static Player player;

    public static void setPlayer(Player p){
        player = p;
    }
    public static Player getPlayer(){
        return player;
    }
}
