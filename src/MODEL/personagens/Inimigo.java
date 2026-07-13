package MODEL.personagens;
import CONTROLLER.ControllerAcao;

import java.io.Serializable;

public class Inimigo extends Personagem implements Serializable {
    private String descricao;
    private Arma armaEquipada;

    public Inimigo(String nome, String raca, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias, Arma arma) {
        super(nome, raca, hp, defesa, forca, dest, manaMax, magias);
        this.armaEquipada = arma;
    }

    @Override
    public void setMagia(Magia magia) {
        super.setMagia(magia);
    }

    @Override
    public void atacar() {
        //
    }

    @Override
    public void usarMagia() {

    }

    @Override
    public String getClasseString() {
        return Inimigo.class.toString();
    }

    @Override
    public String getDescricao(){
        return descricao;
    }

    @Override
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}
