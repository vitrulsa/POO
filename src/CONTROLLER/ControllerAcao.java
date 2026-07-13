package CONTROLLER;

import MODEL.mapa.CombateAtual;
import MODEL.mapa.Sala;
import MODEL.personagens.*;
import VIEW.ViewAcao;

import javax.naming.ldap.Control;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ControllerAcao {

    public static ArrayList<iInfoBasica> checarCenario(Sala sala){
        return sala.listarObjetos();
    }

    public static void atacar(Personagem atacante, Personagem alvo, Magia magia) {
        CombateAtual.atacar(atacante, alvo, magia);
    }

    public static void atacar() throws Exception{
        try{
            ViewAcao.atacar(ControllerJogo.getPlayer().getSalaAtual().getInimigoNaSala());
        } catch(Exception e){
            System.out.println("Erro no ControllerAcao");
            throw e;
        }
    }

    public static void usarMagia(Magia magia) throws Exception{
        Player player = ControllerJogo.getPlayer();

        if (player.getManaAtual() == 0){
            System.out.println("Sem mana! Use uma Poção de Mana ou um ataque normal!");
            return;
        }

        if (magia.getTipo() != "Cura"){
            int i = 0;
            try{
                ViewAcao.escolherAlvo(player.getSalaAtual().getInimigoNaSala());
            } catch (Exception e){
                System.out.println("Erro no ControllerAcao");
                throw e;
            }

            atacar(player, player.getSalaAtual().getInimigoNaSala().get(i - 1), magia);
        } else{
            player.setHp(player.getHp() + 15);
            if (player.getMaxHp() < player.getHp())
                    player.setHp(player.getMaxHp());
        }

        player.setManaAtual(player.getManaAtual() - 1);
    }

    public static void usarMagia() throws Exception{
        try{
            ViewAcao.usarMagia(ControllerJogo.getPlayer().getMagias());
        } catch(Exception e){
            throw e;
        }
    }

    public static void inventario(){
        ViewAcao.exibirInventario(ControllerJogo.getPlayer());
    }

    public static void usarItem(Item item){
        if (item instanceof Consumivel consumivel){
            consumivel.usar(ControllerJogo.getPlayer());
        }
    }
    public static void usarItem() throws Exception{
        try{
            ViewAcao.usarItem(ControllerJogo.getPlayer().getInventario());
        } catch(Exception e){
            throw e;
        }
    }

    public static void ver() throws Exception{
        try {
            ViewAcao.verCenario(ControllerJogo.getPlayer().getSalaAtual());
        } catch (Exception e) {
            throw e;
        }
    }

    public static String falar(NPC npc){
        return npc.getDescricao();
    }

    public static Boolean falar() throws Exception{

        if(ControllerJogo.getEstadoCombate() == true){
            return false;
        }

        try {
            ViewAcao.falar(ControllerJogo.getPlayer().getSalaAtual().getNpcNaSala());
        } catch (Exception e) {
            throw e;
        }

        return true;
    }

    public static void magias(){
        ViewAcao.exibirMagias(ControllerJogo.getPlayer().getMagias());
    }

    public static void equipar(Arma arma){
        Player player = ControllerJogo.getPlayer();
        Arma equipadaAtual = player.getArmaEquipada();
        int indexArma = 0, indexAtual = 0;
        for (Item item: player.getInventario()){
            if (item.getNome().equals(arma.getNome())){
                indexArma = indexAtual;
                break;
            }
            indexAtual++;
        }

        ArrayList<Item> inventario = player.getInventario();
        inventario.remove(indexArma);
        inventario.add(indexArma, equipadaAtual);
        player.setArmaEquipada(arma);
    }

    public static void equipar() throws Exception{
        try{
            ViewAcao.equipar(ControllerJogo.getPlayer().getInventario());
        } catch (Exception e){
            throw e;
        }
    }

    public static boolean turnoInimigos(){
        Player player = ControllerJogo.getPlayer();
        ArrayList<Inimigo> inimigos = player.getSalaAtual().getInimigoNaSala();

        if (!inimigos.isEmpty()){
            Random rand = new Random();
            for (Inimigo inimigo : inimigos){
                if (inimigo.getMagias() == null){
                    atacar(inimigo, player, null);
                }
                else{
                    Magia magia = null;
                    if(inimigo.getManaAtual() > 0){
                        magia = inimigo.getMagias().get(rand.nextInt(inimigo.getMagias().size()));
                    }

                    int chance = rand.nextInt(2);
                    if (chance == 0) {
                        atacar(inimigo, player, magia);
                        if (inimigo.getManaAtual() > 0){
                            inimigo.setManaAtual(inimigo.getManaAtual() - 1);
                        }
                    }else
                        atacar(inimigo, player, null);
                }
            }
        }

        return player.getHp() <= 0;
    }

    public static boolean mover(String comando) throws Exception{

        if(ControllerJogo.getEstadoCombate() == true){
            return false;
        }

        switch (comando){
            case "c":
                try{
                    ControllerMover.andarCima();
                } catch (Exception e) {
                    throw e;
                }
                break;
            case "b":
                try{
                    ControllerMover.andarBaixo();
                } catch (Exception e) {
                    throw e;
                }
                break;
            case "e":
                try{
                    ControllerMover.andarEsquerda();
                } catch (Exception e) {
                    throw e;
                }
                break;
            case "d":
                try{
                    if(ControllerJogo.getPortaTrancada()){
                        System.out.println("A porta está trancada! Talvez a chave esteja em algum lugar no castelo.");
                        break;
                    }
                    ControllerMover.andarDireita();
                } catch (Exception e) {
                    throw e;
                }
                break;
        }
        return true;
    }
}
