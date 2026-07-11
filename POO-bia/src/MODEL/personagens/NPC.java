package MODEL.personagens;

public class NPC extends Personagem {

    protected NPC(String nome, String raca, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias) {
        super(nome, raca, hp, defesa, forca, dest, manaMax, magias);
    }

    @Override
    public void atacar() {
        return; //npc nao ataca
    }

    @Override
    public void usarMagia() {
        return; //npc nao ataca
    }

    @Override
    public String getClasseString() {
        return NPC.class.toString();
    }

}
