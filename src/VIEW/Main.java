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

    View iniciar = new View();

    iniciar.mostrarMenuInicial();
}


