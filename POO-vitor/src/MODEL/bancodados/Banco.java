package MODEL.bancodados;

import MODEL.personagens.Magia;

import java.io.Serializable;
import java.util.HashSet;

public abstract class Banco<T> implements Serializable {
    public abstract void criarBanco();
    public abstract void adicionarBanco(T obj);
    public abstract HashSet<T> getBanco();

    // use adicionarInimigo() para adicionar um inimigo ao banco e depois use criarBanco()
    // para salvar o arquivo
    public abstract void adicionarBanco(String nome, String raca, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias);

    public abstract T getDado(String nome);
}
