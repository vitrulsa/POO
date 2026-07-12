package MODEL.bancodados;

import java.io.Serializable;
import java.util.HashSet;

public abstract class Banco<T> implements Serializable {
    public abstract void criarBanco();
    public abstract void adicionarBanco(T obj);
    public abstract HashSet<T> getBanco();
    public abstract T getDado(String nome);
}
