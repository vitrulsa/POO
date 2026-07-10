public class View {
    public String receberInput(){
        return IO.readln();
    }

    public void mostrarMenuInicial(){
        String menu = """
                ---------------------------------------------------
                                    Bem Vindo!
                                  [nome do jogo]
                
                Digite seu nome:\s""";

        IO.print(menu);

        String nome = receberInput();

        menu = """
               [Raças disponíveis]
               Digite sua raça:\s""";

        IO.print(menu);

        String raca = receberInput();

        menu = """
               abobrinha
               """;

        IO.print(menu);
    }
}
