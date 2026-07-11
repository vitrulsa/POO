import CONTROLLER.ControllerAção;
import CONTROLLER.ControllerInicializar;
import MODEL.bancodados.BancoInimigo;
import MODEL.bancodados.BancoItens;
import MODEL.bancodados.BancoMagia;
import MODEL.personagens.Item;
import MODEL.personagens.Magia;
import MODEL.personagens.TipoItem;
import VIEW.View;

void main() throws Exception { //tm que ter try catch em algum luigar

    View iniciar = new View();

    ControllerInicializar.Inicializar();

    iniciar.mostrarMenuInicial();
}


