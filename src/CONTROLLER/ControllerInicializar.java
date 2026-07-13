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

    public static void setBancoSalas(BancoSala bancoSalas) {
        ControllerInicializar.bancoSalas = bancoSalas;
    }

    public static void setBancoMagias(BancoMagia bancoMagias) {
        ControllerInicializar.bancoMagias = bancoMagias;
    }

    public static void setBancoNPC(BancoNPC bancoNPC) {
        ControllerInicializar.bancoNPC = bancoNPC;
    }

    public static void setBancoArmas(BancoArmas bancoArmas) {
        ControllerInicializar.bancoArmas = bancoArmas;
    }

    public static void setBancoItens(BancoItens bancoItens) {
        ControllerInicializar.bancoItens = bancoItens;
    }

    public static void setBancoInimigos(BancoInimigo bancoInimigos) {
        ControllerInicializar.bancoInimigos = bancoInimigos;
    }

    private static BancoMagia bancoMagias;
    private static BancoSala bancoSalas;

    public static void inicializar() throws Exception{
        try{
            bancoInimigos = new BancoInimigo();
            bancoItens = new BancoItens();
            bancoArmas = new BancoArmas();
            bancoNPC = new BancoNPC();
            bancoMagias = new BancoMagia();
            bancoSalas = new BancoSala();
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
    public static BancoSala getBancoSalas(){
        return bancoSalas;
    }
}