package MODEL.personagens;

public class Consumivel extends Item {
    private int quantidade;
    private int valorEfeito;
    private TipoItem tipo;

    public Consumivel(String nome, int peso, String descricao, int valor, int quantidade, int valorEfeito, TipoItem tipo) {
        super(nome, peso, valor, descricao);
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
                if (alvo instanceof Player player && player.getMaxHp() < player.getHp())
                   alvo.setHp(player.getMaxHp());
                System.out.println("Usou " + getNome() + ". Recuperou " + (valorEfeito - 5) + " de Vida (HP).");
                break;
            case POCAO_MANA:
                alvo.setManaAtual(alvo.getManaAtual() + valorEfeito);
                if (alvo.getManaMax() < alvo.getManaAtual())
                    alvo.setManaAtual(alvo.getManaMax());
                System.out.println("Usou " + getNome() + ". Restaurou " + (valorEfeito - 8)+ " de Mana (MP).");
                break;
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