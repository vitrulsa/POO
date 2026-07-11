package MODEL.personagens;

public abstract class Item implements iInfoBasica {
    private String nome;
    private int peso;
    private int valor;

    public Item(String nome, int peso, int valor) {
        this.nome = nome;
        this.peso = peso;
        this.valor = valor;
    }

    public abstract void usar(Personagem alvo);

    @Override
    public String getNome() { return nome; }

    @Override
    public void setNome(String nome) { this.nome = nome; }

    public int getPeso() { return peso; }
    public int getValor() { return valor; }

    @Override
    public String getClasseString() {
        return Item.class.toString();
    }
}