import java.util.*;

public abstract class Personagem {
    private String nome;
    private String raca;
    private int hp;
    private String estado; // morto, paralisado, incapacitado, etc
    private int defesa; // numero que o inimigo tem que superar para causar o dano que nem no d&d
    private int forca; // numero que soma na tentativa do player dar dano no inimigo e no dano dado que nem no d&d
    private int dest; // numero que soma na tentativa do player dar dano no inimigo e no dano dado que nem no d&d
    private int manaAtual; // numero de magias que ainda pode usar
    private int manaMax; // numero de magias que pode usar no total
    private final ArrayList<Magia> magias;

    public abstract void atacar();
    public abstract void usarMagia();

    protected Personagem(String nome, String raca, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias){
        this.nome = nome;
        this.raca = raca;
        this.hp = hp;
        this.defesa = defesa;
        this.forca = forca;
        this.dest = dest;
        this.manaMax = manaMax;
        this.manaAtual = manaMax;
        this.magias = new ArrayList<Magia>(Arrays.asList(magias));
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getDefesa() {
        return defesa;
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getForca() {
        return forca;
    }
    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDest() {
        return dest;
    }
    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getManaAtual() {
        return manaAtual;
    }
    public void setManaAtual(int manaAtual) {
        this.manaAtual = manaAtual;
    }

    public int getManaMax() {
        return manaMax;
    }
    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }

    public Magia getMagia(String nome){
        for (Magia magia : magias){
            if (magia.getNome().equals(nome)){
                return magia;
            }
        }

        return null;
    }
    public void setMagia(Magia magia) {
        this.magias.add(magia);
    }
}
