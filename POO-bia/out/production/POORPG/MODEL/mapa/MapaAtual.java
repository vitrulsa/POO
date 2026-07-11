package MODEL.mapa;
import MODEL.bancodados.BancoItens;
import MODEL.bancodados.BancoMagia;
import MODEL.personagens.*;

import java.util.ArrayList;
import java.util.Objects;

public class MapaAtual {
    //isso é pra jogar!!! ebaaa!!!
    private static Player jogador;

    private static ArrayList<Object> bancos;

    public static ArrayList<Object> getBancos() {
        return bancos;
    }

    public static <T> void setBancos(T bancos) { //pode ser de banco magia ou itm ou inimigo...
        //mas, no final, td vira object!
        //use instanceof
        //a gnt deveria ter feito eles herdarem de um banco grande :/ aí era mais simples
        MapaAtual.bancos.add((Object) bancos);
    }

    public static Player getJogador() {
        return jogador;
    }

    public static void setJogador(Player novoJogador) {
        jogador = novoJogador;
    }

    //tem mais alguma coisa?
}
