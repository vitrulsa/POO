package VIEW;

public class ViewTutorial {
    public void iniciarTutorial(){
        System.out.println("Os comandos básicos do jogo:");

        System.out.println("VER: Utilizar o comando VER te dará uma descrição da sala atual em que você estiver.");
        System.out.println("FALAR <alvo>: Utilizar o comando FALAR te permite falar com um NPC na sala ao digitar o nome dele.");
        System.out.println("ATACAR <alvo>: Utilizar o comando ATACAR te permite atacar um alvo ao escrever o nome do alvo.");
        System.out.println("INVENTARIO: Utilizar o comando INVENTARIO te mostrará os itens e armas que você possui para usar.");
        System.out.println("USAR <item>: Utilizar o comando USAR te permite usar um item ao escrever o nome do item.");
        System.out.println("EQUIPAR <arma>: Utilizar o comando EQUIPAR te permite trocar ou equipar uma arma escrevendo o nome dela.");
        System.out.println("MAGIAS: Utilizar o comando MAGIAS te mostrará as magias que você pode usar.");
        System.out.println("USAR <magia> <alvo>: Utilizar o comando USAR te permite usar uma magia ao escrever o nome da magia em um alvo," +
                "você pode deixar o campo de alvo vazio para utilizar a magia em si mesmo se ela permitir isso.");
        System.out.println("Você pode andar pelo mapa digitando as direções cardinais \"N\", \"L\", \"S\" e \"O\"," +
                "você precisa usar o comando VER para saber para qual(is) direção(ões) você pode ir.");
    }
}
