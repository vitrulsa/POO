package MODEL.personagens;

public class Arma extends Item {
    private int dano;
    private int alcance;
    private String descricao;

    public Arma(String nome, int peso, int valor, int dano, int alcance) {
        super(nome, peso, valor);
        this.dano = dano;
        this.alcance = alcance;
    }

    public int getDano() { return dano; }
    public int getAlcance() { return alcance; }

    @Override
    public void usar(Personagem alvo) {
        alvo.setArmaEquipada(this); // Equipa a arma no personagem
        System.out.println(alvo.getNome() + " equipou a arma " + getNome() + " com " + getDano() + " de dano.");
    }

    @Override
    public String toString() {
        return getNome() + " [dano: " + dano + ", alcance: " + alcance + ", peso: " + getPeso() + "]";
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