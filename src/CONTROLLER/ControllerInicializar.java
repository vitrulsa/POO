package CONTROLLER;

import MODEL.bancodados.BancoArmas;
import MODEL.bancodados.BancoInimigo;
import MODEL.bancodados.BancoItens;
import MODEL.mapa.*;
import MODEL.personagens.*;
import MODEL.Inicializar;
import MODEL.*;

public class ControllerInicializar {
    private static BancoInimigo bancoInimigos;
    private static BancoItens bancoItens;
    private static BancoArmas bancoArmas;

    public static void Salvar() throws Exception {

        MapaAtual.getJogador();

        Arquivo.salvarJogo();
    }

    public static void inicializar() throws Exception{
        try{
            bancoInimigos = new BancoInimigo();
            bancoItens = new BancoItens();
            bancoArmas = new BancoArmas();
        } catch (Exception e){
            throw e;
        }
    }

    public static BancoInimigo getBancoInimigo(){
        return bancoInimigos;
    }
    public static BancoItens getBancoItens(){
        return bancoItens;
    }
}