package VIEW;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class View {
    public String receberInput(String texto){
        IO.print(texto);

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        return scanner.nextLine();
    }

    public void mostrarMenuInicial(){
        String menu = """
                ---------------------------------------------------
                                    Bem Vindo!
                                  [nome do jogo]
                
                Digite seu nome:\s""";
        String nome = receberInput(menu);

        mostrarRacas();

        String raca;
        do{
            raca = escolherRaca();
        } while(!raca.equals("Anão") && !raca.equals("Elfo") && !raca.equals("Halfling") && !raca.equals("Humano"));
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

        IO.print(racas);
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
            case "Anão" -> IO.print(anao);
            case "Elfo" -> IO.print(elfo);
            case "Halfling" -> IO.print(halfling);
            case "Humano" -> IO.print(humano);
        }
    }

    public String escolherRaca(){
        String menu = """
               Digite sua raça:\s""";

        String escolha = receberInput(menu);

        explicarRacas(escolha);

        String confirmar = """
                Deseja escolher a raça %s? [S/N]\s""".formatted(escolha);

        if (receberInput(confirmar).equals("S"))
            return escolha;
        else
            return "N";
    }
}
