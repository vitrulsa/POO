package MODEL.mapa;
import MODEL.bancodados.Banco;
import MODEL.bancodados.BancoItens;
import MODEL.bancodados.BancoMagia;
import MODEL.personagens.*;

import java.util.ArrayList;
import java.util.Objects;

public class MapaAtual {
    //isso é pra jogar!!! ebaaa!!!
    private static Player jogador;

    public static Banco getBancoInimigo() {
        return bancoInimigo;
    }

    public static void setBancoInimigo(Banco bancoInimigo) {
        MapaAtual.bancoInimigo = bancoInimigo;
    }

    public static Banco getBancoItem() {
        return bancoItem;
    }

    public static void setBancoItem(Banco bancoItem) {
        MapaAtual.bancoItem = bancoItem;
    }

    public static Banco getBancoMagia() {
        return bancoMagia;
    }

    public static void setBancoMagia(Banco bancoMagia) {
        MapaAtual.bancoMagia = bancoMagia;
    }

    private static Banco bancoInimigo;
    private static Banco bancoItem;
    private static Banco bancoMagia;

    public static Player getJogador() {
        return jogador;
    }

    public static void setJogador(Player novoJogador) {
        jogador = novoJogador;
    }

    //tem mais alguma coisa?
}
