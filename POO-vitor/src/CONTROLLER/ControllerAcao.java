package CONTROLLER;

import MODEL.mapa.Sala;
import MODEL.personagens.*;
import VIEW.ViewAcao;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ControllerAcao {


    public static ArrayList<iInfoBasica> checarCenario(Sala sala){
        return sala.listarObjetos();
        //sla, nao gostei... queria divisao entr nome p saber o q é item vs o q é inimigo...
    }

    public static void atacar(Inimigo alvo) {
        Player atacante = ControllerJogo.getPlayer();
        System.out.println("\n>>> " + atacante.getNome() + " ataca " + alvo.getNome() + " <<<");

        int danoCausado = atacante.getForca();

        if (atacante.getArmaEquipada() != null) {
            danoCausado += atacante.getArmaEquipada().getDano();
            System.out.println(atacante.getNome() + " ataca com a sua " + atacante.getArmaEquipada().getNome() + "!");
        }

        danoCausado = danoCausado - alvo.getDefesa();


        if (danoCausado <= 0) {
            danoCausado = 0;
            System.out.println("A armadura de " + alvo.getNome() + " bloqueou totalmente o ataque!");
        } else {

            alvo.setHp(alvo.getHp() - danoCausado);
            System.out.println(alvo.getNome() + " sofreu " + danoCausado + " pontos de dano!");
        }

        if (alvo.getHp() <= 0) {
            alvo.setHp(0);
            alvo.setEstado("Morto");
            System.out.println(">>> " + alvo.getNome() + " caiu em combate! <<<");
        } else {
            System.out.println("HP restante de " + alvo.getNome() + ": " + alvo.getHp());
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
                alvo.setEstado("Morto");
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

    public static void falar(NPC npc){

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
        ArrayList<Item> inventario = ControllerJogo.getPlayer().getInventario();

        for (Item item : inventario){
            if (item.getNome() && item instanceof Arma arma){
                ControllerJogo.getPlayer().setArmaEquipada(arma);
                ViewAcao.equipou(arma);
            }
        }

        ViewAcao.equipou(null);
    }

    public static void equipar() throws Exception{
        try{
            ViewAcao.equipar(ControllerJogo.getPlayer().getInventario());
        } catch (Exception e){
            throw e;
        }
    }
}
