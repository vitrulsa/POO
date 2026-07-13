package CONTROLLER;

import MODEL.mapa.LigacoesMapa;
import MODEL.mapa.MapaAtual;
import MODEL.mapa.Sala;

public class ControllerMover {

    public static void andarEsquerda() throws Exception{
        if (LigacoesMapa.moverSalaEsq(MapaAtual.getPlayer().getSalaAtual()) == null)
            throw new Exception();
        else
            ControllerJogo.getPlayer().setSalaAtual(LigacoesMapa.moverSalaEsq(MapaAtual.getPlayer().getSalaAtual()));
    }
    public static void andarDireita() throws Exception{
        if (LigacoesMapa.moverSalaDir(MapaAtual.getPlayer().getSalaAtual()) == null)
            throw new Exception();
        else
            ControllerJogo.getPlayer().setSalaAtual(LigacoesMapa.moverSalaDir(MapaAtual.getPlayer().getSalaAtual()));
    }
    public static void andarCima() throws Exception{
        if (LigacoesMapa.moverSalaCima(MapaAtual.getPlayer().getSalaAtual()) == null)
            throw new Exception();
        else
            ControllerJogo.getPlayer().setSalaAtual(LigacoesMapa.moverSalaCima(MapaAtual.getPlayer().getSalaAtual()));
    }
    public static void andarBaixo() throws Exception{
        if (LigacoesMapa.moverSalaBaixo(MapaAtual.getPlayer().getSalaAtual()) == null)
            throw new Exception();
        else
            ControllerJogo.getPlayer().setSalaAtual(LigacoesMapa.moverSalaBaixo(MapaAtual.getPlayer().getSalaAtual()));
    }

}