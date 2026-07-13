package CONTROLLER;

import MODEL.bancodados.*;
import MODEL.mapa.*;
import MODEL.personagens.*;
import MODEL.Inicializar;
import MODEL.*;

public class ControllerInicializar {
    private static BancoInimigo bancoInimigos;
    private static BancoItens bancoItens;
    private static BancoArmas bancoArmas;
    private static BancoNPC bancoNPC;
    private static BancoMagia bancoMagias;

    public static void Salvar() throws Exception {

        MapaAtual.getPlayer();

        Arquivo.salvarJogo();
    }

    public static void inicializar() throws Exception{
        try{
            bancoInimigos = new BancoInimigo();
            bancoItens = new BancoItens();
            bancoArmas = new BancoArmas();
            bancoNPC = new BancoNPC();
            bancoMagias = new BancoMagia();
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
    public static BancoArmas getBancoArmas(){
        return bancoArmas;
    }
    public static BancoMagia getBancoMagias(){
        return bancoMagias;
    }
    public static BancoNPC getBancoNPC(){
        return bancoNPC;
    }
}