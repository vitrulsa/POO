
import CONTROLLER.ControllerInicializar;
import MODEL.bancodados.*;
import MODEL.mapa.Sala;
import MODEL.personagens.*;
import VIEW.ViewInicializar;

void main() {
//    ViewInicializar view = new ViewInicializar();
//
//    view.mostrarMenuInicial();
    try{
        ControllerInicializar.inicializar();
    } catch (Exception e){
        System.out.println("não cosneguir ler algum banco de daods");
    }

    BancoSala salas = new BancoSala();
    ArrayList<Inimigo> inimigos = new ArrayList<>();
    ArrayList<NPC> npcs = new ArrayList<>();
    ArrayList<Item> itens = new ArrayList<>();
//
    Sala sala = new Sala("salateste", "teste");
    inimigos.add(ControllerInicializar.getBancoInimigo().getDado("Slime"));
    sala.setInimigoNaSala(inimigos);
    salas.adicionarSala(sala);
    salas.criarBanco();

    inimigos.clear();
    npcs.clear();
    itens.clear();

    sala = new Sala("salateste2", "teste2");
    inimigos.add(ControllerInicializar.getBancoInimigo().getDado("Goblin"));
}


