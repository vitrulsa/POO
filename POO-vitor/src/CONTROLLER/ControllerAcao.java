package CONTROLLER;

import MODEL.mapa.Sala;
import MODEL.personagens.*;
import VIEW.ViewAcao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ControllerAcao {


    public static ArrayList<iInfoBasica> checarCenario(Sala sala){
        return sala.listarObjetos();
        //sla, nao gostei... queria divisao entr nome p saber o q é item vs o q é inimigo...
    }

    public static void atacar(Personagem atacante, Personagem alvo, Magia magia) {
        Random rand = new Random();
        int tipoDano;
        Arma arma = atacante.getArmaEquipada();
        if (magia == null){
            if (arma != null)
                tipoDano = atacante.getArmaEquipada().getAlcance(); // 0 corpo-a-corpo, 1 a-distancia
            else
                tipoDano = 0;
        } else{
            tipoDano = 2;
        }

        int dado = 0;
        switch(tipoDano){
            case 1:
                dado = rand.nextInt(20) + atacante.getForca();
                break;
            case 2, 3:
                dado = rand.nextInt(20) + atacante.getDest();
                break;
        }

        if (dado >= alvo.getDefesa()){
            int dano = 0;
            switch (tipoDano){
                case 1:
                    if (arma != null)
                        dano = rand.nextInt(arma.getDano()) + atacante.getForca();
                    else
                        dano = atacante.getForca();
                    break;
                case 2:
                    dano = rand.nextInt(arma.getDano()) + atacante.getDest();
                    break;
                case 3:
                    dano = rand.nextInt(magia.getDano());
            }

            if (dano < 0)
                dano = 0;

            alvo.setHp(alvo.getHp() - dano);
            ViewAcao.dano(atacante, alvo, dano);

            if (alvo.getHp() <= 0){
                if (alvo instanceof Inimigo inimigo)
                    ControllerJogo.getPlayer().getSalaAtual().getInimigoNaSala().remove(inimigo);
            }
        } else{
            ViewAcao.dano(atacante, alvo, 0);
        }
    }
    public static void atacar() throws Exception{
        try{
            ViewAcao.atacar(ControllerJogo.getPlayer().getSalaAtual().getInimigoNaSala());
        } catch(Exception e){
            throw e;
        }
    }

    public static void usarMagia(Magia magia) {
        Player atacante = ControllerJogo.getPlayer();
        System.out.println("\n>>> " + atacante.getNome() + " invoca " + magia.getNome() + "! <<<");

        //  Gasta 1 ponto de Mana
        atacante.setManaAtual(atacante.getManaAtual() - 1);
        System.out.println("Mana restante de " + atacante.getNome() + ": " + atacante.getManaAtual() + "/" + atacante.getManaMax());

        if (!magia.getTipo().equals("cura")){
            int index = 0;
            while (true){
                try{
                    index = ViewAcao.escolherAlvo(atacante.getSalaAtual().getInimigoNaSala());
                    break;
                } catch(Exception e){
                    System.out.println("Tente novamente.");
                }
            }
            Inimigo alvo = atacante.getSalaAtual().getInimigoNaSala().get(index - 1);

            //  Calcula o dano (Dano da magia - Defesa do alvo)
            int danoCausado = magia.getDano() - alvo.getDefesa();

            //  Garante que o dano não é negativo
            if (danoCausado <= 0) {
                danoCausado = 0;
                System.out.println("A defesa de " + alvo.getNome() + " resistiu completamente ao tipo " + magia.getTipo() + "!");
            } else {
                // Tira o HP do alvo
                alvo.setHp(alvo.getHp() - danoCausado);
                System.out.println(alvo.getNome() + " sofreu " + danoCausado + " pontos de dano mágico!");
            }

            //  Verificar se o alvo morreu
            if (alvo.getHp() <= 0) {
                alvo.setHp(0);
                System.out.println(">>> " + alvo.getNome() + " caiu em combate! <<<");
                atacante.getSalaAtual().getInimigoNaSala().remove(index - 1);
            } else {
                System.out.println("HP restante de " + alvo.getNome() + ": " + alvo.getHp());
            }
        }
    }
    public static void usarMagia() throws Exception{
        try{
            ViewAcao.usarMagia(ControllerJogo.getPlayer().getMagias());
        } catch(Exception e){
            throw e;
        }
    }

    public static void inventario(){
        ViewAcao.exibirInventario(ControllerJogo.getPlayer().getInventario());
    }

    public static void usarItem(Item item){

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
    public static void falar() throws Exception{
        try {
            ViewAcao.falar(ControllerJogo.getPlayer().getSalaAtual().getNpcNaSala());
        } catch (Exception e) {
            throw e;
        }
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
                if (inimigo.getMagias().isEmpty())
                    atacar(inimigo, player, null);
                else{
                    Magia magia = null;
                    if(inimigo.getManaAtual() > 0){
                        magia = inimigo.getMagias().get(rand.nextInt(inimigo.getMagias().size()));
                    }

                    int chance = rand.nextInt(2);
                    if (chance == 0)
                        atacar(inimigo, player, magia);
                    else
                        atacar(inimigo, player, null);
                }
            }
        }

        return player.getHp() <= 0;
    }
}
