package MODEL.mapa;

public class SalaNode { //responsabilidade: sabe qual sala se liga c qual + liga elas

    public static Sala criarSala(){
        Sala s = new Sala();
        return s;
    }

    public static Sala ligarSalasEsq(Sala sala, Sala esq){
        sala.salaEsquerda = esq;
        return sala.salaEsquerda;
    }
    public static Sala ligarSalasDir(Sala sala, Sala dir)
    {
        sala.salaDireita = dir;
        return sala.salaDireita;
    }
    public Sala ligarSalasCima(Sala sala, Sala cima)
    {
        sala.salaCima = cima;
        return sala.salaCima;
    }
    public static Sala ligarSalasBaixo(Sala sala, Sala baixo)
    {
        sala.salaBaixo = baixo;
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
