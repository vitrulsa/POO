public  class Item {
    private String nome;
    private TipoItem tipo;
    private int peso;
    private int valor;

    public Item(String nome, TipoItem tipo, int peso, int valor){
        this.nome = nome;
        this.tipo = tipo;
        this.peso = peso;
        this.valor = valor;
    }

    public void usar() {
        if (this.quantidade <= 0) {
            System.out.println("Você não tem mais " + nome + "!");
            return;
        }

        switch (this.tipo) {
            case POCAO_VIDA:
                System.out.println("Usou " + nome + ". Recuperou " + valorEfeito + " de Vida (HP).");
                gastar();
                break;
            case POCAO_MANA:
                System.out.println("Usou " + nome + ". Restaurou " + valorEfeito + " de Mana (MP).");
                gastar();
                break;
            case MUNICAO:
                System.out.println(nome + " não pode ser usada diretamente. Deve ser carregada em uma arma.");
                break;
            default:
                System.out.println("Este item não tem efeito imediato.");
        }

    }
    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public int getPeso() { return peso; }
    public int getValor() { return valor; }

}
