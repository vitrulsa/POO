package CONTROLLER;

import MODEL.mapa.CombateAtual;
import MODEL.mapa.MapaAtual;
import MODEL.mapa.Sala;
import MODEL.personagens.*;
import VIEW.ViewAcao;

import javax.naming.ldap.Control;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

// responsavel pelas logicas dos comandos principais
public class ControllerAcao {

    public static ArrayList<iInfoBasica> checarCenario(Sala sala){
        return sala.listarObjetos();
    }

    public static void atacar(Personagem atacante, Personagem alvo, Magia magia) {
        CombateAtual.atacar(atacante, alvo, magia);

        if (alvo instanceof Inimigo && alvo.getHp() <= 0) {
            gerarDrop((Inimigo) alvo); // Gera o ouro e os itens

            // Remove o inimigo morto da sala para ele desaparecer do mapa
            ControllerJogo.getPlayer().getSalaAtual().getInimigoNaSala().remove(alvo);
        }
    }

    private static void gerarDrop(Inimigo inimigo) {
        java.util.Random rand = new java.util.Random();
        Player player = ControllerJogo.getPlayer();

        System.out.println("\n*** O inimigo " + inimigo.getNome() + " foi derrotado! ***");

        //  Drop de Ouro garantido (Sorteia entre 5 e 15 moedas)
        int ouroDrop = rand.nextInt(11) + 5;
        player.setOuro(player.getOuro() + ouroDrop);
        System.out.println("-> Saqueaste " + ouroDrop + " moedas de ouro do corpo!");

        // Chance de 30% de dropar um consumível (Poção de Vida)
        if (rand.nextInt(100) < 30) {
            Item pocao = ControllerInicializar.getBancoItens().getDado("Poção de Vida");
            if (pocao != null) {
                player.getInventario().add(pocao);
                System.out.println("-> O inimigo dropou " + pocao.getNome() + "! O item foi para o teu inventário.");
            }
        }

        // Chance de 20% do inimigo dropar a própria arma que tinhaa
        if (inimigo.getArmaEquipada() != null && rand.nextInt(100) < 20) {
            player.getInventario().add(inimigo.getArmaEquipada());
            System.out.println("-> O inimigo deixou cair: " + inimigo.getArmaEquipada().getNome() + "! Foi para o teu inventário.");
        }
    }

    // funcao chamada pelo ViewJogo para printar opcoes de ataque
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
                i = ViewAcao.escolherAlvo(player.getSalaAtual().getInimigoNaSala());
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

    // funcao chamada pelo ViewJogo para printar opcoes de magia
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
            MapaAtual.getPlayer().getInventario().remove(consumivel);
        }
    }
    // funcao chamada pelo ViewJogo para printar opcoes de itens
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
        if(npc.getNome().equals("Rainha Chiclete")){
            ControllerJogo.finalizarJogo();
            return " ";
        }
        return npc.getDescricao();
    }

    // funcao chamada pelo ViewJogo para ver opcoes de fala na sala
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

    // funcao chamada pelo ViewJogo para ver opcoes de armas do inventario para equipar
    public static void equipar() throws Exception{
        try{
            ViewAcao.equipar(ControllerJogo.getPlayer().getInventario());
        } catch (Exception e){
            throw e;
        }
    }

    // logica do turno dos inimigos
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
