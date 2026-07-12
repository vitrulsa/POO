package MODEL.mapa;

public class LigacoesMapa { //responsabilidade: sabe qual sala se liga c qual + liga elas
    //é pra formar mapa!!!

    public static Sala ligarSalasEsq(Sala sala, Sala esq){
        sala.salaEsquerda = esq;
        esq.salaDireita = sala;
        return sala.salaEsquerda;
    }
    public static Sala ligarSalasDir(Sala sala, Sala dir)
    {
        sala.salaDireita = dir;
        dir.salaEsquerda = sala;
        return sala.salaDireita;
    }
    public Sala ligarSalasCima(Sala sala, Sala cima)
    {
        sala.salaCima = cima;
        cima.salaBaixo = sala;
        return sala.salaCima;
    }
    public static Sala ligarSalasBaixo(Sala sala, Sala baixo)
    {
        sala.salaBaixo = baixo;
        baixo.salaCima = sala;
        return sala.salaBaixo;
    }

    //fiz um pra cada, motivo: fazer try catch em cada
    //tem como fazer em sala tbm, mas pensei nesse ser o Mapa, só copiar e colar
    public static Sala moverSalaEsq(Sala sala){
        return sala.salaEsquerda;
    }

    public static Sala moverSalaDir(Sala sala){
        return sala.salaDireita;
    }

    public static Sala moverSalaCima(Sala sala){
        return sala.salaCima;
    }

    public static Sala moverSalaBaixo(Sala sala){
        return sala.salaBaixo;
    }

}