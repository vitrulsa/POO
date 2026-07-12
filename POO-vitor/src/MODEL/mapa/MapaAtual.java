package MODEL.mapa;
import MODEL.bancodados.Banco;
import MODEL.personagens.*;

import java.util.HashSet;

public class MapaAtual {
    //isso é pra jogar!!! ebaaa!!!
    private static Player jogador;

    private static HashSet<Banco> bancoMagia;
    private static HashSet<Banco> bancoNPC;
    private static HashSet<Banco> bancoItem;
    private static HashSet<Banco> bancoSala;
    private static HashSet<Banco> bancoInimigo;

    public static HashSet<Banco> getBancoInimigo() {
        return bancoInimigo;
    }

    public static void setBancoInimigo(HashSet<Banco> bancoInimigo) {
        MapaAtual.bancoInimigo = bancoInimigo;
    }

    public static Banco getBancoItem() {
        return bancoItem;
    }

    public static void setBancoItem(HashSet<Banco> bancoItem) {
        MapaAtual.bancoItem = bancoItem;
    }

    public static Banco getBancoNPC() {
        return bancoNPC;
    }

    public static void setBancoNPC(HashSet<Banco> bancoNPC) {
        MapaAtual.bancoNPC = bancoNPC;
    }

    public static Banco getBancoMagia() {
        return bancoMagia;
    }

    public static void setBancoMagia(HashSet<Banco> bancoMagia) {
        MapaAtual.bancoMagia = bancoMagia;
    }

    public static Player getJogador() {

        return jogador;
    }

    public static void setJogador(Player novoJogador) {
        jogador = novoJogador;
    }

    public static Banco getBancoSala() {
        return bancoSala;
    }

    public static void setBancoSala(HashSet<Banco> bancoSala) {
        MapaAtual.bancoSala = bancoSala;
    }

    //tem mais alguma coisa?
}
