import MODEL.bancodados.BancoInimigo;
import MODEL.bancodados.BancoItens;
import MODEL.bancodados.BancoMagia;
import MODEL.personagens.Item;
import MODEL.personagens.Magia;
import MODEL.personagens.TipoItem;
import VIEW.View;

void main() {
    BancoItens bancoItens = new BancoItens();
    BancoMagia bancoMagia = new BancoMagia();
    BancoInimigo bancoInimigo = new BancoInimigo();

//    Magia[] magias = new Magia[1];
//    magias[0] = bancoMagia.getMagia("Bola de fogo");
//    bancoInimigo.adicionarInimigo("Goblin", "Goblin", 5, 12, 10, 12, 1, magias);
//    bancoInimigo.criarBanco();

    View view = new View();

    view.mostrarMenuInicial();
}


