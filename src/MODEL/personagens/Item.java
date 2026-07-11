package MODEL.personagens;

public  class Item implements iInfoBasica {
    private String nome;
    private TipoItem tipo;
    private int peso;
    private int valor;
    private int quantidade;

    public Item(String nome, TipoItem tipo, int peso, int valor, int quantidade){
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
        this.valor = valor;
        this.quantidade = quantidade; //era p ser assim mesmo?
        //é que tem this.quantidade ali
        //se nao for assim, altere!
    }

    public void usar() {
        if (this.quantidade <= 0) {
            System.out.println("Você não tem mais " + nome + "!");
            return;
        }

        switch (this.tipo) {
            case POCAO_VIDA:
                //System.out.println("Usou " + nome + ". Recuperou " + valorEfeito + " de Vida (HP).");
                gastar();
                break;
            case POCAO_MANA:
                //System.out.println("Usou " + nome + ". Restaurou " + valorEfeito + " de Mana (MP).");
                gastar();
                break;
            case MUNICAO:
                System.out.println(nome + " não pode ser usada diretamente. Deve ser carregada em uma arma.");
                break;
            default:
                System.out.println("Este item não tem efeito imediato.");
        }

    }
    @Override
    public String getNome() { return nome; }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoItem getTipo() { return tipo; }
    public int getPeso() { return peso; }
    public int getValor() { return valor; }

    public String getClasseString() {
        return Item.class.toString();
    }

    public void gastar(){

    }

}
