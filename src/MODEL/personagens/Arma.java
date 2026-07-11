package MODEL.personagens;

public class Arma extends Item {
    private int dano;
    private int alcance;

    public Arma(String nome, int peso, int valor, int dano, int alcance) {
        super(nome, peso, valor);
        this.dano = dano;
        this.alcance = alcance;
    }

    public int getDano() { return dano; }
    public int getAlcance() { return alcance; }

    @Override
    public void usar(Personagem alvo) {
        System.out.println(alvo.getNome() + " equipou a arma " + getNome() + " com " + dano + " de dano.");
    }

    @Override
    public String toString() {
        return getNome() + " [dano: " + dano + ", alcance: " + alcance + ", peso: " + getPeso() + "]";
    }
}