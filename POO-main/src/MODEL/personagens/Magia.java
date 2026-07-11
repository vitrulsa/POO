package MODEL.personagens;

public class Magia {
    private String nome;
    private int dano;
    private String tipo; // fogo, gelo, veneno, cura, etc. determina o que a magia faz
    private String descricao;

    public Magia(String nome, int dano, String tipo, String descricao){
        this.nome = nome;
        this.tipo = tipo;
        this.dano = dano;
        this.descricao = descricao;
    }

    public int getDano() {
        return dano;
    }
    public void setDano(int dano) {
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
