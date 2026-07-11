import MODEL.personagens.BancoItens;
import MODEL.personagens.Item;
import MODEL.personagens.TipoItem;
import VIEW.View;

void main() {
    BancoItens bancoItens = new BancoItens();

    bancoItens.adicionarItem(new Item("Poção de Vida",
            TipoItem.POCAO_VIDA, 2, 15, 1));

    bancoItens.adicionarItem(new Item("Poção de Mana",
            TipoItem.POCAO_MANA, 2, 10, 1));

    bancoItens.criarBancoItem();
}


