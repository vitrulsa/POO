package CONTROLLER;

import MODEL.Inicializar;
import MODEL.mapa.MapaAtual;
import MODEL.mapa.Sala;
import MODEL.personagens.*;
import VIEW.ViewJogo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ControllerJogo {

    private static int NUM_INIMIGOSINICIAL = 10;
    private static int NUM_NPCINICIAL = 10;
    private static int NUM_ITEMINICIAL = 10;
    private static int NUM_MAGIAINICIAL = 10;
    private static int NUM_SALAS = 1;

    public static void setMeuPlayer(Player meuPlayer) {
        ControllerJogo.meuPlayer = meuPlayer;
    }

    private static Player meuPlayer;

    public static void iniciarJogo(String nome, String raca, String classe){

        /*
        |Raças    | Força | Destreza | Vida Inicial | Mana Inicial |
        |---------|-------|----------|--------------|--------------|
        |Anão     |  +3   |    -1    |      12      |      1       |
        |---------|-------|----------|--------------|--------------|
        |Elfo     |       |    +2    |       8      |      2       |
        |---------|-------|----------|--------------|--------------|
        |Halfling |  -3   |    +3    |       6      |      3       |
        |---------|-------|----------|--------------|--------------|
        |Humano   |  +1   |    +1    |      10      |      2       |
        |----------------------------------------------------------|
         */

        /*
        |Classes      | Corpo-a-corpo | À distância | Armadura |  Aprende magia? |
        |-------------|---------------|-------------|----------|-----------------|
        |Guerreiro    |       X       |             |    16    |                 |
        |-------------|---------------|-------------|----------|-----------------|
        |Ladino       |       X       |      X      |    14    |                 |
        |-------------|---------------|-------------|----------|-----------------|
        |Mago         |       X       |             |    10    |        X        |
        |-------------|---------------|-------------|----------|-----------------|
        |Patrulheiro  |               |      X      |    12    |        X        |
        |-------------|---------------|-------------|----------|-----------------|

         */
        int hp;
        int defesa;
        int forca;
        int dest;
        int manaMax;
        ArrayList<Item> inventario = new ArrayList<>();
        Arma arma = null;
        Magia[] magias;
        switch(raca){
            case "Anão":
                hp = 12;
                forca = 3;
                dest = -1;
                manaMax = 1;
                break;
            case "Elfo":
                hp = 8;
                forca = 0;
                dest = 2;
                manaMax = 2;
                break;
            case "Halfling":
                hp = 6;
                forca = -3;
                dest = 3;
                manaMax = 3;
                break;
            default: // case "Humano"
                hp = 10;
                forca = 1;
                dest = 1;
                manaMax = 2;
                break;
        }

        switch(classe){
            case "Guerreiro":
                defesa = 16;
                magias = new Magia[0];
                arma = ControllerInicializar.getBancoArmas().getArma("Espada Longa");
                break;
            case "Ladino":
                defesa = 14;
                magias = new Magia[0];
                arma = ControllerInicializar.getBancoArmas().getArma("Rapieira");
                break;
            case "Mago":
                defesa = 10;
                magias = new Magia[3];
                magias[0] = ControllerInicializar.getBancoMagias().getDado("Cura");
                magias[1] = ControllerInicializar.getBancoMagias().getDado("Estilhacar");
                magias[2] = ControllerInicializar.getBancoMagias().getDado("Bola de Fogo");
                inventario.add(ControllerInicializar.getBancoItens().getDado("Poção de Mana"));
                inventario.add(ControllerInicializar.getBancoItens().getDado("Poção de Mana"));
                inventario.add(ControllerInicializar.getBancoItens().getDado("Poção de Mana"));
                inventario.add(ControllerInicializar.getBancoItens().getDado("Poção de Mana"));
                inventario.add(ControllerInicializar.getBancoItens().getDado("Poção de Vida"));
                inventario.add(ControllerInicializar.getBancoItens().getDado("Poção de Vida"));
                break;
            default: // case "Patrulheiro"
                defesa = 12;
                magias = new Magia[1];
                arma = ControllerInicializar.getBancoArmas().getArma("Arco");
                magias[0] = ControllerInicializar.getBancoMagias().getDado("Raio Adoecente");
                inventario.add(ControllerInicializar.getBancoItens().getDado("Poção de Mana"));
                break;
        }
        meuPlayer = new Player(nome, raca, classe, hp, defesa, forca, dest, manaMax, magias);
        meuPlayer.setArmaEquipada(arma);
        meuPlayer.getInventario().addAll(inventario);

        MapaAtual.ligarSalas(meuPlayer);
        ViewJogo.iniciarJogo();
    }

    public static Player getPlayer(){
        return meuPlayer;
    }
}