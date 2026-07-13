package MODEL.mapa;
import CONTROLLER.ControllerInicializar;
import MODEL.bancodados.BancoSala;
import MODEL.personagens.*;

public class MapaAtual {
    private static Player player;
    private static boolean emCombate;

    public static boolean isEmCombate() {
        return emCombate;
    }

    public static void setEmCombate() {
        if(!player.getSalaAtual().getInimigoNaSala().isEmpty()){
            emCombate = true;
        } else {
            emCombate = false;
        }
    }

    public static void setPlayer(Player p){
        player = p;
    }
    public static Player getPlayer(){
        return player;
    }

    public static void ligarSalas(Player p){
        Sala salaBosqueInicial = ControllerInicializar.getBancoSalas().getSala("Bosque inicial");

        Sala salaCentroFloresta = ControllerInicializar.getBancoSalas().getSala("Centro floresta");

        Sala salaJardimDosSlimes = ControllerInicializar.getBancoSalas().getSala("Jardim dos slimes");

        Sala salaArvoreDosEsquilos = ControllerInicializar.getBancoSalas().getSala("Árvore dos esquilos");

        Sala salaClareira = ControllerInicializar.getBancoSalas().getSala("Clareira");

        Sala salaFimDaFloresta = ControllerInicializar.getBancoSalas().getSala("Fim da floresta");

        Sala salaCentroDaVila = ControllerInicializar.getBancoSalas().getSala("Centro da vila");

        Sala salaCasaAldeao = ControllerInicializar.getBancoSalas().getSala("Casa");

        Sala salaLojaSilvio = ControllerInicializar.getBancoSalas().getSala("Loja");

        Sala salaHallDoCastelo = ControllerInicializar.getBancoSalas().getSala("Hall do castelo");

        Sala salaQuarto = ControllerInicializar.getBancoSalas().getSala("Quarto");

        Sala salaCozinha = ControllerInicializar.getBancoSalas().getSala("Cozinha");

        Sala salaCloset = ControllerInicializar.getBancoSalas().getSala("Closet");
        LigacoesMapa.ligarSalasDir(salaBosqueInicial, salaCentroFloresta);
        LigacoesMapa.ligarSalasBaixo(salaCentroFloresta, salaJardimDosSlimes);
        LigacoesMapa.ligarSalasDir(salaCentroFloresta, salaArvoreDosEsquilos);
        LigacoesMapa.ligarSalasCima(salaCentroFloresta, salaClareira);
        LigacoesMapa.ligarSalasCima(salaClareira, salaFimDaFloresta);
        LigacoesMapa.ligarSalasDir(salaFimDaFloresta, salaCentroDaVila);
        LigacoesMapa.ligarSalasBaixo(salaCentroDaVila, salaCasaAldeao);
        LigacoesMapa.ligarSalasCima(salaCentroDaVila, salaLojaSilvio);
        LigacoesMapa.ligarSalasDir(salaCentroDaVila, salaHallDoCastelo);
        LigacoesMapa.ligarSalasCima(salaHallDoCastelo, salaCozinha);
        LigacoesMapa.ligarSalasDir(salaHallDoCastelo, salaQuarto);
        LigacoesMapa.ligarSalasBaixo(salaQuarto, salaCloset);

        setPlayer(p);
        player.setSalaAtual(salaBosqueInicial);
    }
}
