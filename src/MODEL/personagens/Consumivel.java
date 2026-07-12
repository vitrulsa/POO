package MODEL.personagens;

public class Consumivel extends Item {
    private int quantidade;
    private int valorEfeito;
    private TipoItem tipo;
    private String descricao;

    public Consumivel(String nome, int peso, int valor, int quantidade, int valorEfeito, TipoItem tipo) {
        super(nome, peso, valor);
        this.quantidade = quantidade;
        this.valorEfeito = valorEfeito;
        this.tipo = tipo;
    }

    @Override
    public void usar(Personagem alvo) {
        if (this.quantidade <= 0) {
            System.out.println("Não tens mais " + getNome() + "!");
            return;
        }

        switch (this.tipo) {
            case POCAO_VIDA:
                alvo.setHp(alvo.getHp() + valorEfeito);
                System.out.println("Usou " + getNome() + ". Recuperou " + valorEfeito + " de Vida (HP).");
                break;
            case POCAO_MANA:
                alvo.setManaAtual(alvo.getManaAtual() + valorEfeito);
                System.out.println("Usou " + getNome() + ". Restaurou " + valorEfeito + " de Mana (MP).");
                break;
            case MUNICAO:
                System.out.println(getNome() + " não pode ser usada diretamente. Deve ser carregada numa arma.");
                return;
            default:
                System.out.println("Este item não tem efeito imediato.");
                return;
        }
        gastar();
    }

    private void gastar() {
        this.quantidade--;
    }

    public int getQuantidade() { return quantidade; }

    @Override
    public String getDescricao(){
        return descricao;
    }

    @Override
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}