import MODEL.bancodados.*;
import MODEL.mapa.LigacoesMapa;
import MODEL.mapa.Sala;
import MODEL.mapa.SalaNode;
import MODEL.personagens.Item;
import MODEL.personagens.Magia;
import MODEL.personagens.NPC;
import MODEL.personagens.TipoItem;
import VIEW.View;
import java.util.ArrayList;

void main() {
    BancoItens bancoItens = new BancoItens();
    BancoMagia bancoMagia = new BancoMagia();
    BancoInimigo bancoInimigo = new BancoInimigo();
    BancoNPC bancoNPC = new BancoNPC();
    BancoSala bancoSala = new BancoSala();

    Sala clareira = new Sala("Clareira calma na floresta, há um caminho de flores a sua frente");

    Magia[] magJurandir = new Magia[0];
    NPC jurandir = new NPC("Jurandir", "Humano", 10, 5, 5, 5, 0, magJurandir);

    ArrayList<NPC> caras = new ArrayList<>();
    caras.add(jurandir);

    Sala cabana = new Sala("Cabana a frente da clareira, construção humilde com móveis artesanais de madeira da floresta");

    cabana.setNpcNaSala(caras);

    LigacoesMapa.ligarSalasDir(clareira, cabana);

    bancoSala.adicionarSala(clareira);
    bancoSala.adicionarSala(cabana);
    bancoSala.criarBanco();


//    Magia[] magias = new Magia[1];
//    magias[0] = bancoMagia.getMagia("Bola de fogo");
//    bancoInimigo.adicionarInimigo("Goblin", "Goblin", 5, 12, 10, 12, 1, magias);
//    bancoInimigo.criarBanco();
}


