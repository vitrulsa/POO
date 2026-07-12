package MODEL.bancodados;

import MODEL.personagens.Arma;
import MODEL.personagens.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BancoArmas extends BancoItens {

    public BancoArmas() {
        super(); // Chama o construtor do BancoItens
    }

    // Procura um item pelo nome e converte diretamente para Arma
    public Arma getArma(String nome) {
        Item item = getDado(nome);

        if (item instanceof Arma) {
            return (Arma) item;
        }

        System.out.println("O item '" + nome + "' não foi encontrado ou não é uma Arma.");
        return null;
    }

    // Filtra o HashSet da classe mãe e devolve apenas uma lista com as Armas
    public List<Arma> getTodasAsArmas() {
        List<Arma> apenasArmas = new ArrayList<>();

        for (Item item : super.getItens()) {
            if (item instanceof Arma) {
                apenasArmas.add((Arma) item);
            }
        }

        return apenasArmas;
    }

    // Sorteia uma arma aleatória do banco
    public Arma sortearArmaAleatoria() {
        List<Arma> armas = getTodasAsArmas();

        if (armas.isEmpty()) {
            System.out.println("Não há armas cadastradas no banco de dados!");
            return null;
        }

        Random rand = new Random();
        int indiceSorteado = rand.nextInt(armas.size());
        return armas.get(indiceSorteado);
    }
}