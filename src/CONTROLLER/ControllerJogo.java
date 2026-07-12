package CONTROLLER;

import MODEL.Inicializar;
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
                break;
            case "Ladino":
                defesa = 14;
                magias = new Magia[0];
                break;
            case "Mago":
                defesa = 10;
                magias = new Magia[3];
                break;
            default: // case "Patrulheiro"
                defesa = 12;
                magias = new Magia[1];
                break;
        }
        meuPlayer = new Player(nome, raca, classe, hp, defesa, forca, dest, manaMax, magias);
        Sala sala = new Sala("teste");
        ArrayList<Inimigo> inimigos = new ArrayList<>();
        inimigos.add(ControllerInicializar.getBancoInimigo().getDado("Slime"));
        ArrayList<Item> itens = new ArrayList<>();
        itens.add(ControllerInicializar.getBancoItens().getDado("Chave"));
        sala.setInimigoNaSala(inimigos);
        sala.setItemNaSala(itens);
        meuPlayer.setSalaAtual(sala);
        ViewJogo.iniciarJogo();
    }

    public static Player getPlayer(){
        return meuPlayer;
    }
}