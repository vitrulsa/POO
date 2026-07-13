package VIEW;

public class ViewTutorial {
    public void iniciarTutorial(){
        System.out.println("Os comandos básicos do jogo:");

        System.out.println("VER: Utilizar o comando VER te dará uma descrição da sala atual em que você estiver. Você pode pegar itens ao usar VER e escolher um item na sala.");
        System.out.println("FALAR <alvo>: Utilizar o comando FALAR te permite falar com um NPC na mesma sala que você.");
        System.out.println("ATACAR <alvo>: Utilizar o comando ATACAR te permite atacar um alvo.");
        System.out.println("INVENTARIO: Utilizar o comando INVENTARIO te mostrará os itens e armas que você possui para usar.");
        System.out.println("USAR <item>: Utilizar o comando USAR te permite usar um item que possuir.");
        System.out.println("USAR <magia> <alvo>: Utilizar o comando USAR te permite usar uma magia.");
        System.out.println("EQUIPAR <arma>: Utilizar o comando EQUIPAR te permite trocar ou equipar uma arma.");
        System.out.println("MAGIAS: Utilizar o comando MAGIAS te mostrará as magias que você pode usar.");
        System.out.println("TERMINAR: Fecha o jogo a qualquer momento.");
        System.out.println("Você pode andar pelo mapa digitando as direções cardinais \"D\" (direita), \"E\" (esquerda), \"C\" (cima) e \"B\" (baixo)," +
                "você precisa usar o comando VER para saber para qual(is) direção(ões) você pode ir.");
    }
}
