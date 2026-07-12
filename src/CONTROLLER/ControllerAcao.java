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

    public static void atacar(Personagem atacante, Personagem alvo) {
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

    public static void usarMagia(Personagem atacante, Personagem alvo, Magia magia) {
        System.out.println("\n>>> " + atacante.getNome() + " invoca " + magia.getNome() + " contra " + alvo.getNome() + "! <<<");

        //  Verificar se o atacante tem Mana suficiente
        if (atacante.getManaAtual() <= 0) {
            System.out.println(atacante.getNome() + " está sem Mana! A magia falhou.");
            return;
        }

        //  Gasta 1 ponto de Mana (conforme as regras da tua View)
        atacante.setManaAtual(atacante.getManaAtual() - 1);
        System.out.println("Mana restante de " + atacante.getNome() + ": " + atacante.getManaAtual() + "/" + atacante.getManaMax());

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
        } else {
            System.out.println("HP restante de " + alvo.getNome() + ": " + alvo.getHp());
        }
    }

    public static void inventario(){
        ViewAcao.exibirInventario(ControllerJogo.getPlayer().getInventario());
    }

    public static void usarItem(String item){

    }

    public static void ver(){

    }

    public static void falar(NPC npc){

    }

    public static void magias(){
        ViewAcao.exibirMagias(ControllerJogo.getPlayer().getMagias());
    }

    public static boolean equipar(String nome){
        ArrayList<Item> inventario = ControllerJogo.getPlayer().getInventario();

        for (Item item : inventario){
            if (item.getNome().equals(nome) && item instanceof Arma arma){
                ControllerJogo.getPlayer().setArmaEquipada(arma);
                ViewAcao.equipou(arma);
                return true;
            }
        }

        ViewAcao.equipou(null);
        return false;
    }
}
