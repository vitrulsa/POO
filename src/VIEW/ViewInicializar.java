package VIEW;

import CONTROLLER.ControllerJogo;
import CONTROLLER.ControllerTutorial;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ViewInicializar {
    // funcao utilizada para continuamente printar um texto e ja receber a resposta do usuario
    public String receberInput(String texto){
        System.out.print(texto);

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        return scanner.nextLine();
    }

    // primeira funcao do jogo, menu principal para criar o personagem
    public void mostrarMenuInicial(){
        String menu = """
                ---------------------------------------------------
                                    Bem Vindo!
                                  [nome do jogo]
                
                Digite seu nome:\s""";
        String nome = receberInput(menu);

        // mostrar racas e fazer player escolher a raca
        mostrarRacas();

        String raca;
        do{
            raca = escolherRaca();
        } while(!raca.equals("Anão") && !raca.equals("Elfo") && !raca.equals("Halfling") && !raca.equals("Humano"));


        // mostrar classes e fazer player escolher classe
        mostrarClasses();
        String classe;
        do{
            classe = escolherClasse();
        } while(!classe.equals("Guerreiro") && !classe.equals("Mago") && !classe.equals("Patrulheiro") && !classe.equals("Ladino"));

        menu = """
                Certo! Você gostaria de um tutorial sobre como funciona o jogo? [S/N]\s""";

        // tutorial
        String resposta;
        do{
            resposta = receberInput(menu).toLowerCase();

            if (!resposta.equals("n") && !resposta.equals("s") && !resposta.equals("sim") && !resposta.equals("nao") && !resposta.equals("não"))
                System.out.println("Responda com S (sim) ou N (não).");
        } while (!resposta.equals("n") && !resposta.equals("s") && !resposta.equals("sim") && !resposta.equals("nao") && !resposta.equals("não"));
        if (resposta.equals("s") || resposta.equals("sim"))
            ControllerTutorial.iniciarTutorial();


        // ControllerJogo controla tudo
        ControllerJogo.iniciarJogo(nome, raca, classe);
    }

    public void mostrarRacas(){
        String racas = """
                Os números de Força e Destreza são os bônus que você recebe ao ser
                daquela raça.
                O número de Mana é a quantidade de magias que você
                pode usar antes de ter que descansar.
                
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
                
                """;

        System.out.print(racas);
    }

    public void explicarRacas(String raca){

        String anao = """
                
                Anão     |
                --------------------------------------------------------------------------------------------
                Anões são conhecidos por suas barbas e cabelos ruivos, pequena estatura, e habilidade física
                surpreendente com seus Machados Grandes e Martelos de Guerra.
                
                Moradores de ambientes cavernosos, eles geralmente conhecem muito das terras subterrâneas e
                das técnicas de mineração. Porém, tão focados no físico, não possuem um desenvolvimento das
                técnicas arcanas tão avançado quanto as outras raças.
                --------------------------------------------------------------------------------------------
                """;

        String elfo = """
                
                Elfo     |
                --------------------------------------------------------------------------------------------
                Elfos são criaturas esbeltas e graciosas. Seus corpos geralmente permitem habilidades com
                pontaria e agilidade impressionantes, portanto comumente Elfos são vistos empunhando armas
                precisas e graciosas, como Arcos e Rapieiras.
                
                Moradores de ambientes de florestas, eles geralmente conhecem muito de terrenos mais
                dificeís e das técnicas de caça. Não são tão fortes quanto Anões, porém eles possuem uma
                conexão com o arcano tão boa quanto a de Humanos.
                --------------------------------------------------------------------------------------------
                """;

        String halfling = """
                
                Halfling |
                --------------------------------------------------------------------------------------------
                Halfling são a menor raça dentre as 4, com uma aparência inofensiva e até que bem semelhante
                com Humanos, menos o tamanho, é claro. Cabelos e olhos castanhos são uma combinação
                comum entre os Halflings, que geralmente também não possuem barba. Suas armas principalmente
                incluem Arcos e Bestas graças à sua habilidade de pontaria.
                
                Moradores de ambientes de campo aberto, eles geralmente conhecem muito das terras habitadas
                e das técnicas de exploração. São a raça mais fisicamente fraca, porém isso não lhes torna
                combatentes incapazes: por suas fraquezas físicas, eles desenvolveram grande conhecimento
                de magia e de pontaria, sendo a raça com melhor conexão arcana.
                --------------------------------------------------------------------------------------------
                """;

        String humano = """
                
                Humano     |
                --------------------------------------------------------------------------------------------
                Humanos são reconhecíveis através das suas diferenças com outras raças, e não por
                características comuns a maioria deles: Humanos possuem diversos tipos de cores de cabelo,
                olhos, pele, diversas alturas diferentes, estatura, entre outras divergências. Porém, há uma
                tendência à fisionomia humana ser mais próxima à de Elfos, ou talvez Elfos que são mais
                próximos à Humanos? Os estudos da história das raças não possuem uma resposta ainda. Por
                sua grande versatilidade, são vistos empunhandos basicamente qualquer tipo de arma.
                
                Moradores de qualquer ambiente, eles geralmente são capazes de adaptação a qualquer estilo
                de vida, localidade ou técnica. A raça que é conhecida por ser "boa em tudo, porém nunca a
                melhor", como dizem as outras raças. Humanos possuem um conhecimento arcano equiparável ao
                de Elfos.
                --------------------------------------------------------------------------------------------
                """;

        switch (raca) {
            case "Anão":
                System.out.print(anao);
                break;
            case "Elfo":
                System.out.print(elfo);
                break;
            case "Halfling":
                System.out.print(halfling);
                break;
            case "Humano":
                System.out.print(humano);
                break;
        }
    }

    public String escolherRaca(){
        String menu = """
               Digite sua raça:\s""";

        String escolha;
        while (true) {
            escolha = receberInput(menu);

            if (escolha.equals("Anão") || escolha.equals("Elfo") || escolha.equals("Halfling") || escolha.equals("Humano")){
                break;
            }else{
                System.out.println("Escolha uma das raças anteriores (digite o nome corretamente).");
            }
        }

        explicarRacas(escolha);

        String confirmar = """
                Deseja escolher a raça %s? [S/N]\s""".formatted(escolha);

        do{
            String resposta = receberInput(confirmar).toLowerCase();
            if (resposta.equals("s") || resposta.equals("sim"))
                return escolha;
            else if (resposta.equals("n") || resposta.equals("não") || resposta.equals("nao"))
                return "N";
            else
                System.out.println("Responda com S (sim) ou N (não).");
        } while(true);
    }

    public void mostrarClasses(){
        String classes = """
                A indicação "Corpo-a-corpo" e "À distância" significa o tipo de arma
                que a classe é capaz de usar.
                Exemplo: Um Guerreiro pode usar apenas armas corpo-a-corpo, enquanto um
                Patrulheiro pode apenas usar armas à distância.
                
                Armas corpo-a-corpo utilizam sua força, enquanto armas à distância
                utilizam sua destreza. Magias também utilizam destreza.
                
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
                
                """;

        System.out.print(classes);
    }

    public void explicarClasses(String classe){

        String guerreiro = """
                
                Guerreiro       |
                --------------------------------------------------------------------------------------------
                Guerreiros são conhecidos por sua força bruta e habilidade corpo-a-corpo incomparável.
                Existem muitos soldados e combatentes pelo mundo, porém poucos são caracterizados como
                verdadeiros Guerreiros. Guerreiros se orgulham de suas grandes armas e de seu conhecimento
                sobre o combate, levando-os a sua ignorância em relação ao arcanismo.
                --------------------------------------------------------------------------------------------
                """;

        String ladino = """
                
                Ladino          |
                --------------------------------------------------------------------------------------------
                Ladinos são traiçoeiros e versáteis. Geralmente relacionados com o cenário criminoso,
                por serem sorrateiros e habilidosos, mas eles não são necessariamente maus: alguns
                Ladinos utilizam suas técnicas para o bem, porém isso não nega a existência de muitos
                Ladinos que são ótimos ladrões. Ladinos são capazes de utilizar qualquer tipo de arma, mas
                lhes falta a capacidade de controlar o arcano.
                --------------------------------------------------------------------------------------------
                """;

        String mago = """
                
                Mago            |
                --------------------------------------------------------------------------------------------
                Raramente, ao visitar-se diversas cidades e vilas, é possível se deparar com um Mago. Magos
                são conhecidos por estudarem durante anos as técnicas arcanas, até finalmente serem capazes
                de lançar poderosos feitiços que alteram a realidade. Entretanto, esse foco único nos
                estudos arcanos geralmente faz com que Magos tenham pouco desenvolvimento físico e treino
                com armas complexas, levando-os a serem a classe mais fraca fisicamente dentre as 4.
                --------------------------------------------------------------------------------------------
                """;

        String patrulheiro = """
                
                Patrulheiro     |
                --------------------------------------------------------------------------------------------
                Patrulheiros são experientes caçadores e mentes táticas, possuidores de incríveis
                habilidades físicas e de precisão. Apesar de não serem os mais fortes ou robustos, eles
                compensam suas fraquezas com seus conhecimentos arcanos e vários anos de treinamento com
                armas à longa distância.
                --------------------------------------------------------------------------------------------
                """;

        switch (classe) {
            case "Guerreiro":
                System.out.print(guerreiro);
                break;
            case "Ladino":
                System.out.print(ladino);
                break;
            case "Mago":
                System.out.print(mago);
                break;
            case "Patrulheiro":
                System.out.print(patrulheiro);
                break;
        }
    }

    public String escolherClasse(){
        String menu = """
               Digite sua classe:\s""";

        String escolha;
        while (true) {
            escolha = receberInput(menu);

            if (escolha.equals("Guerreiro") || escolha.equals("Ladino") || escolha.equals("Mago") || escolha.equals("Patrulheiro")){
                break;
            }else{
                System.out.println("Escolha uma das classes anteriores (digite o nome corretamente).");
            }
        }

        explicarClasses(escolha);

        String confirmar = """
                Deseja escolher a classe %s? [S/N]\s""".formatted(escolha);

        do{
            String resposta = receberInput(confirmar).toLowerCase();
            if (resposta.equals("s") || resposta.equals("sim"))
                return escolha;
            else if (resposta.equals("n") || resposta.equals("não") || resposta.equals("nao"))
                return "N";
            else
                System.out.println("Responda com S (sim) ou N (não).");
        } while(true);
    }

}
