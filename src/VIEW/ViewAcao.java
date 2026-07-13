package VIEW;

import CONTROLLER.ControllerAcao;
import CONTROLLER.ControllerJogo;
import MODEL.mapa.MapaAtual;
import MODEL.mapa.Sala;
import MODEL.personagens.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewAcao {

    public static void exibirInventario(Player player) {
        System.out.println("--- Inventário ---");
        for (Item item : player.getInventario()) {
            System.out.println(item.getNome());
        }

        if (player.getArmaEquipada() != null)
            System.out.println("Arma equipada: " + player.getArmaEquipada().getNome());
        else
            System.out.println("Nenhuma arma equipada");
    }

    public static void usarItem(ArrayList<Item> inventario) throws Exception {

        System.out.println("Escolha um item para utilizar:\n--- Inventário ---");
        int quantidade = 0;
        for (Item item : inventario) {
            System.out.println("[" + quantidade + "] " + item.getNome());
            quantidade++;
        }

        if (quantidade > 0){
            Scanner s = new Scanner(System.in);
            while(true){
                try {
                    int i = s.nextInt();

                    if (i > 0 && i <= quantidade){
                        ControllerAcao.usarItem(inventario.get(i));
                        break;
                    } else{
                        System.out.println("Insira um número de 1 à "+ quantidade);
                    }
                } catch (IncompatibleClassChangeError e) {
                    throw new Exception(e);
                } catch (InputMismatchException e) {
                    System.out.println("Insira um número de 1 à "+ quantidade);
                    throw new Exception(e);
                }
            }
        }

    }

    public static void atacar(ArrayList<Inimigo> inimigoNaSala) throws Exception {
        try{
            int i = escolherAlvo(inimigoNaSala);
            if (i > 0)
                ControllerAcao.atacar(ControllerJogo.getPlayer(), inimigoNaSala.get(i - 1), null);
        } catch (Exception e){
            System.out.println("Erro no ViewAcao");
            throw e;
        }
    }

    public static void falar(ArrayList<NPC> NPCsNaSala) throws Exception{
        // pega os NPCs na sala
        int i = 0;
        for (NPC npc : NPCsNaSala){
            i++;
            System.out.println("[" + i + "] " + npc.getNome());
        }
        // se houver NPCS na sala, escolhe NPC pra falar
        if (i > 0){
            Scanner s = new Scanner(System.in);
            while(true){
                try {
                    int entrada = s.nextInt();

                    if (entrada > 0 && entrada <= i){
                        NPC npcEscolhido = NPCsNaSala.get(entrada - 1);

                        System.out.println(ControllerAcao.falar(npcEscolhido));

                        if (npcEscolhido.getNome().equals("Vendedor Silvio")) {
                            ViewLoja.abrirLoja(); // Abre o menu da Loja
                        } else if (npcEscolhido.getNome().equals("Mestre Arcano")) {
                            ViewMestre.abrirMenu(); // Abre o menu de magias
                        }

                        break;
                    }
                    else
                        System.out.println("Insira um número de 1 à "+ i);
                } catch (IncompatibleClassChangeError e) {
                    System.out.println("Erro no ViewAcao.");
                    throw new Exception(e);
                } catch (InputMismatchException e) {
                    System.out.println("Insira um número de 1 à "+ i);
                    throw new Exception(e);
                }
            }
        } else{
            // se nao houver NPCs na sala
            System.out.println("Não há NPCS na sala atual.");
        }
    }

    public static void usarMagia(ArrayList<Magia> magias) throws Exception {
        // se nao tiver mana
        if (ControllerJogo.getPlayer().getManaAtual() == 0) {
            System.out.println("Não possui mana!");
            return;
        }

        // mostrar as magias que o player possui
        int i = 0;
        for (Magia magia : magias){
            i++;
            System.out.println("[" + i + "] " + magia.getNome());
        }
        // se player possuir magias
        if (i > 0){
            Scanner s = new Scanner(System.in);
            while (true){
                try {
                    int entrada = s.nextInt();

                    if (entrada > 0 && entrada <= i){
                        ControllerAcao.usarMagia(magias.get(entrada - 1));
                        break;
                    }else
                        System.out.println("Insira um número de 1 à "+ i);
                } catch (IncompatibleClassChangeError e) {
                    throw new Exception(e);
                } catch (InputMismatchException e) {
                    System.out.println("Insira um número de 1 à "+ i);
                    throw new Exception(e);
                }
            }
        } else{
            // se nao houver magias
            System.out.println("Você não conhece magias.");
        }
    }

    public static int escolherAlvo(ArrayList<Inimigo> inimigoNaSala) throws Exception{
        int quantidade = 0;
        for (Inimigo inimigo : inimigoNaSala) {
            System.out.println((quantidade + 1) + ": " + inimigo.getNome());
            quantidade++;
        }

        if (quantidade > 0){
            System.out.println("Quem você vai atacar primeiro?");
            Scanner s = new Scanner(System.in);
            try {
                int i = s.nextInt();

                if (i > 0 && i <= quantidade)
                    return i;
                else {
                    System.out.println("Insira um número de 1 à " + quantidade);
                    return 0;
                }
            } catch (IncompatibleClassChangeError e) {
                System.out.println("Erro de classe");
                throw new Exception(e);
            } catch (InputMismatchException e) {
                System.out.println("Insira um número de 1 à "+ quantidade);
                throw new Exception(e);
            }
        } else{
            // se nao houver inimigos na sala
            System.out.println("Não há inimigos na sala atual.");
            return 0;
        }
    }

    public static void verCenario(Sala salaAtual) throws Exception {
        System.out.println(salaAtual.getDescricao());

        System.out.println("Você pode ir para: ");

        if(salaAtual.getSalaCima() != null) {
            System.out.println("Cima: " + salaAtual.getSalaCima().getNome());
        }
        if(salaAtual.getSalaDireita() != null){
            System.out.println("Direita: " + salaAtual.getSalaDireita().getNome());
        }
        if(salaAtual.getSalaBaixo() != null) {
            System.out.println("Baixo: " + salaAtual.getSalaBaixo().getNome());
        }
        if(salaAtual.getSalaEsquerda() != null) {
            System.out.println("Esquerda: " + salaAtual.getSalaEsquerda().getNome());
        }

        ArrayList<iInfoBasica> listaObjetos = ControllerAcao.checarCenario(salaAtual);
        System.out.println("Nessa sala, existem: ");

        int quantidade = 0;
        for(iInfoBasica objetos : listaObjetos){
            System.out.println((quantidade + 1) + ": " + objetos.getNome());
            quantidade += 1;
        }

        if (quantidade == 0) {
            System.out.println("Só você e o nada.");
            return;
        }

        System.out.println("Você deseja ver alguma descrição?");

        Scanner s = new Scanner(System.in);
        try {
            while (true){
                int d = s.nextInt();
                if (d > 0 && d <= quantidade){
                    if (listaObjetos.get(d - 1) instanceof Consumivel consumivel) {
                        System.out.println(consumivel.getNome() + ": " + consumivel.getDescricao());
                        ControllerJogo.getPlayer().getInventario().add(consumivel);
                        ControllerJogo.getPlayer().getSalaAtual().getItemNaSala().remove(consumivel);
                    }
                    else if (listaObjetos.get(d - 1) instanceof NPC npc)
                        System.out.println(npc.getNome() + " NPC " + npc.getRaca());
                    else if (listaObjetos.get(d - 1) instanceof Inimigo inimigo)
                        System.out.println("Inimigo " + inimigo.getNome() + "!");
                    break;
                } else{
                    System.out.println("Insira um número de 1 à " + quantidade + "!");
                }
            }
        } catch (IncompatibleClassChangeError e) {
            throw new Exception(e);
        } catch (InputMismatchException e) {
            System.out.println("Insira um número de 1 à "+ listaObjetos.size() + "!");
            throw new Exception(e);
        }

    }

    public static void exibirMagias(ArrayList<Magia> magias){
        if (magias.isEmpty()){
            System.out.println("Você não possui magias.");
        } else{
            System.out.println("---Magias---");
            for (Magia magia : magias){
                System.out.println(magia.getNome() + ":" + magia.getDescricao());
            }
        }
    }

    public static void equipar(ArrayList<Item> inventario) throws Exception{

        ArrayList<Arma> armas = new ArrayList<>();
        int quantidade = 0;
        for (Item item : inventario) {
            if (item instanceof Arma arma){
                System.out.println("[" + quantidade + "] " + arma.getNome());
                armas.add(arma);
                quantidade++;
            }
        }
        if (quantidade == 0){
            System.out.println("Sem armas para equipar");
        } else{
            System.out.println("Escolha uma arma para equipar.");
        }

        if (quantidade > 0){
            Scanner s = new Scanner(System.in);
            while (true){
                try {
                    int i = s.nextInt();

                    if (i >0 && i <= quantidade){
                        ControllerAcao.equipar(armas.get(i));
                        break;
                    }else{
                        System.out.println("Insira um número de 1 à "+ quantidade);
                    }
                } catch (IncompatibleClassChangeError e) {
                    throw new Exception(e);
                } catch (InputMismatchException e) {
                    System.out.println("Insira um número de 1 à "+ quantidade);
                    throw new Exception(e);
                }
            }
        }

    }

    public static void dano(Personagem atacante, Personagem alvo, int dano){
        if (dano > 0){
            System.out.println(">>> " + atacante.getNome() + " acerta " + alvo.getNome() + " e causa " + dano + " de dano! <<<");

            if (alvo.getHp() <= 0){
                System.out.println(">>> " + alvo.getNome() + " morreu! <<<");
            }
        } else if (dano == 0) {
            System.out.println(">>> " + atacante.getNome() + " errou! <<<");
        }
    }
}