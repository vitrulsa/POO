package MODEL.personagens;
import CONTROLLER.ControllerAção;

import java.io.Serializable;

public class Inimigo extends Personagem implements Serializable {

    public Inimigo(String nome, String raca, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias) {
        super(nome, raca, hp, defesa, forca, dest, manaMax, magias);
    }

    @Override
    public void setMagia(Magia magia) {
        super.setMagia(magia);
    }

    @Override
    public void atacar() {
        ControllerAção.atacar();
    }

    @Override
    public void usarMagia() {

    }

    @Override
    public String getClasseString() {
        return Inimigo.class.toString();
    }
}
