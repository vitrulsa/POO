package MODEL;

import MODEL.mapa.*;
import MODEL.bancodados.*;
import MODEL.personagens.*;

import java.util.ArrayList;
import java.util.Random;

public class Inicializar {

    public static ArrayList<Object> criarBancos()
    {
        BancoInimigo bancoInimigo = new BancoInimigo();
        BancoItens bancoItens = new BancoItens();
        BancoMagia bancoMagia = new BancoMagia();
        ArrayList<Object> bancos = new ArrayList<>(3);
        bancos.add(bancoInimigo);
        bancos.add(bancoItens);
        bancos.add(bancoMagia);

        return bancos;
    }

    public static Player criarPlayer()
    {
        Player playerCriado = new Player("nda", "nda", 0, 0, 0, 0, 0, null);
        return playerCriado;
    }

    public static Sala[] criarSalas(int numSalas) {
        Sala[] salaCriadas = new Sala[numSalas];

        for (int i = 0; i < numSalas; i++) {
            salaCriadas[i] = new Sala();
        }

        return salaCriadas;
    }

    public static void mapaRandom(Sala[] sala){

        Random k = new Random();
        //fiz nada mas pode ter aki tbm
    }

    public static Sala mapaInicial(Sala[] sala){
        //ok, pensem em como criar o coiso pfv
        //usar ligacoes mapa aki
        return sala[0];
    }

}
