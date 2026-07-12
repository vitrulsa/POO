package MODEL.personagens;

import java.io.Serializable;
import java.util.*;

public abstract class Personagem implements iInfoBasica, Serializable {
    protected String nome;
    protected String raca;
    protected int hp;
    protected int defesa; // numero que o inimigo tem que superar para causar o dano que nem no d&d
    protected int forca; // numero que soma na tentativa do player dar dano no inimigo e no dano dado que nem no d&d
    protected int dest; // numero que soma na tentativa do player dar dano no inimigo e no dano dado que nem no d&d
    protected int manaAtual; // numero de magias que ainda pode usar
    protected int manaMax; // numero de magias que pode usar no total
    protected Arma armaEquipada;
    protected ArrayList<Magia> magias;

    public abstract void atacar();

    public abstract void usarMagia();

    protected Personagem(String nome, String raca, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias) {
        this.nome = nome;
        this.raca = raca;
        this.hp = hp;
        this.defesa = defesa;
        this.forca = forca;
        this.dest = dest;
        this.manaMax = manaMax;
        this.manaAtual = manaMax;
        if (magias == null)
            this.magias = null;
        else
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

    public Arma getArmaEquipada() { return armaEquipada; }

    public void setArmaEquipada(Arma armaEquipada) { this.armaEquipada = armaEquipada; }

    public Magia getMagia(String nome) {
        for (Magia magia : magias) {
            if (magia.getNome().equals(nome)) {
                return magia;
            }
        }

        return null;
    }

    public void setMagia(Magia magia) {
        this.magias.add(magia);
    }

    public ArrayList<Magia> getMagias(){ return this.magias; }

}