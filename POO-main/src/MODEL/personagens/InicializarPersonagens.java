package MODEL.personagens;

public class InicializarPersonagens {

    public static Inimigo[] criarInimigo(int numInimigos)
    {
        Inimigo[] inimigosCriados = new Inimigo[numInimigos];

        for(int i = 0; i < numInimigos; i++){
            inimigosCriados[i] = new Inimigo("nda", "nda", 0, 0, 0, 0, 0, null);
        }

        return inimigosCriados;
    }

    public static NPC[] criarNPC(int numNPC)
    {

        NPC[] NPCCriados = new NPC[numNPC];

        for(int i = 0; i < numNPC; i++){
            NPCCriados[i] = new NPC("nda", "nda", 0, 0, 0, 0, 0, null);
        }

        return NPCCriados;
    }

    public static Item[] criarItem(int numItem)
    {
        Item[] itemCriado = new Item[numItem];

        for(int i = 0; i < numItem; i++){
            itemCriado[i] = new Item("nda", null, 0, 0, 0);
        }

        return itemCriado;
    }

    public static Magia[] criarMagia(int numMagia)
    {
        Magia[] MagiaCriado = new Magia[numMagia];

        for(int i = 0; i < numMagia; i++){
            MagiaCriado[i] = new Magia("nda", 0, "nda", "nda");
        }

        return MagiaCriado;
    }


    public static Player criarPlayer()
    {
        Player playerCriado = new Player("nda", "nda", 0, 0, 0, 0, 0, null);
        return playerCriado;
    }

}
