package MODEL.mapa;

import CONTROLLER.ControllerJogo;
import MODEL.personagens.*;
import VIEW.ViewAcao;

import java.util.Random;

public class CombateAtual {

    public static void atacar(Personagem atacante, Personagem alvo, Magia magia) {

        Random rand = new Random();
        int tipoDano;
        Arma arma = atacante.getArmaEquipada();
        if (magia == null) {
            if (arma != null)
                tipoDano = atacante.getArmaEquipada().getAlcance(); // 0 corpo-a-corpo, 1 a-distancia
            else
                tipoDano = 0;
        } else {
            tipoDano = 2;
        }

        int dado = 0;
        switch (tipoDano) {
            case 0:
                dado = rand.nextInt(20) + atacante.getForca();
                break;
            case 1, 2:
                dado = rand.nextInt(20) + atacante.getDest();
                break;
        }

        if (dado >= alvo.getDefesa()) {
            int dano = 0;
            switch (tipoDano) {
                case 0:
                    if (arma != null)
                        dano = rand.nextInt(arma.getDano()) + atacante.getForca();
                    else
                        dano = rand.nextInt(4) + atacante.getForca();
                    break;
                case 1:
                    dano = rand.nextInt(arma.getDano()) + atacante.getDest();
                    break;
                case 2:
                    dano = rand.nextInt(magia.getDano());
            }

            if (dano < 0)
                dano = 0;

            alvo.setHp(alvo.getHp() - dano);
            ViewAcao.dano(atacante, alvo, dano);

            if (alvo.getHp() <= 0) {
                if (alvo instanceof Inimigo inimigo)
                    ControllerJogo.getPlayer().getSalaAtual().getInimigoNaSala().remove(inimigo);
            }
        } else {
            ViewAcao.dano(atacante, alvo, 0);
        }
    }

}