package MODEL.personagens;

public class NPC extends Personagem {
    private String descricao;

    public NPC(String nome, String raca, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias, String descricao) {
        super(nome, raca, hp, defesa, forca, dest, manaMax, magias);
        this.descricao = descricao; // descricao do NPC tambem eh o dialogo dele
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

    @Override
    public String getDescricao(){
        return descricao;
    }

    @Override
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

}
