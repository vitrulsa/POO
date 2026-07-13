import CONTROLLER.ControllerInicializar;
import CONTROLLER.ControllerJogo;
import MODEL.bancodados.*;
import MODEL.mapa.Sala;
import MODEL.personagens.*;
import VIEW.ViewInicializar;

void main() throws Exception { //A MAIN QUE CRIA TUDO DE TUDO

    ControllerInicializar.inicializar();

    BancoItens itens = new BancoItens();

    //Consumiveis(String nome, int peso, int valor, int quantidade, int valorEfeito, TipoItem tipo, String descricao)
    itens.adicionarBanco(new Consumivel("Chave", 1, "Chave rosa ornamentada. Claramente é importante.", 5, 1, 0, TipoItem.CHAVE));
    itens.adicionarBanco(new Consumivel("Pergaminho", 1, "Pergaminho de papel fechado com um selo real, deve ser entregue a Rainha.", 1, 1, 0, TipoItem.MISC));
    itens.adicionarBanco(new Consumivel("Chocolate", 2, "Bombom de licor sabor cereja. A única coisa boa nesse mundo!", 5, 1, 0, TipoItem.MISC));
    itens.adicionarBanco(new Consumivel("Poção de Vida", 2, "Frasco com um líquido vermelho e espesso. Tem cheiro de remédio, eca...", 5, 1, 10, TipoItem.POCAO_VIDA));
    itens.adicionarBanco(new Consumivel("Poção de Mana", 2, "Frasco com um líquido azul com cheiro de menta, mas apenas os que sabem disso são aqueles que já sentiram o cheiro de menta...\n...(o que é raro, infelizmente)...", 5, 1, 10, TipoItem.POCAO_MANA));
    itens.adicionarBanco(new Consumivel("Flechas", 5, "Flechas simples com ponta de ferro, preferencialmente usada com um arco, claro.", 5, 5, 0, TipoItem.MUNICAO));

    itens.criarBanco();

    BancoArmas armas = new BancoArmas();

    armas.adicionarBanco(new Arma("Espada Longa", 4, 15, 7, 0, "Espada Longa.\nÉ uma espada longa mesmo, daquelas medievais.\nArmas de fogo não existe mais, já que não existe ninguém para fabricá-las..."));
    armas.adicionarBanco(new Arma("Arco", 2, 10, 5, 1, "Arco.\nA 'arma de fogo' mais famosa do momento! Use flechas com ela!"));
    armas.adicionarBanco(new Arma("Rapieira", 3, 12, 6, 0, ""));
    armas.adicionarBanco(new Arma("Espada Curta", 3, 10, 6, 0, "Espada Curta.\nIdeal para ataques rápidos, a espada curta é para agilidade e simplicidade!\nTambém corta pão e frios facinho!"));
    armas.criarBanco();


    BancoInimigo inimigos = new BancoInimigo();

    //Inimigo(String nome, String raca, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias)
    inimigos.adicionarBanco(new Inimigo("Slime", "Slime", 4, 8, 0, 0, 0, null, null));
    inimigos.adicionarBanco(new Inimigo("Esquilo Vermelho", "Animal", 4, 6, -1, 0, 0, null, null));
    inimigos.adicionarBanco(new Inimigo("Esquilo Azul", "Animal", 4, 7, -2, 0, 0, null, null));
    inimigos.adicionarBanco(new Inimigo("Esquilo Verde", "Animal", 4, 10, -2, -2, 0, null, null));
    inimigos.adicionarBanco(new Inimigo("Lobo", "Animal", 5, 10, 2, 1, 0, null, null));
    inimigos.adicionarBanco(new Inimigo("Guarda Goblin Jeff", "Goblin", 6, 10, 0, -1, 0, null, armas.getArma("Espada Curta")));
    inimigos.adicionarBanco(new Inimigo("Guarda Goblin Ersson", "Goblin", 6, 10, 0, -1, 0, null, armas.getArma("Rapieira")));

    BancoMagia bancoMagia = new BancoMagia();

    Magia[] magias = new Magia[3];

    magias[0] = bancoMagia.getDado("Bola de Fogo");
    magias[1] = bancoMagia.getDado("Raio Adoecente");

    inimigos.adicionarBanco(new Inimigo("Mago Iam Quina", "Humano/Robo", 14, 14, 1, 3, 5, magias, armas.getArma("Espada Longa")));
    inimigos.criarBanco();

    BancoNPC npcs = new BancoNPC();

    //NPC(String nome, String raca, int hp, int defesa, int forca, int dest, int manaMax, Magia[] magias, String fala)
    npcs.adicionarBanco(new NPC("Nomade Diego", "Elfo", 7, 10, 0, 0, 0, null, "Olá viajante, pode me ajudar a encontrar uma flor roxa?"));
    npcs.adicionarBanco(new NPC("Aldeão", "Humano", 7, 10, 0, 0, 0, null, "Quem é você?!?! Sai da minha casa!!! Onde já se viu entrar na casa dos outros desse jeito!"));
    npcs.adicionarBanco(new NPC("Vendedor Silvio", "Humano", 7, 10, 0, 0, 0, null, "Vem pra cá, vem pra cá! Minha loja tem tudo que um aventureiro precisa, e tambem chocolates caso queira agradar a Rainha Chiclete!"));
    npcs.adicionarBanco(new NPC("Abravanelson", "Humano", 4, 10, 0, 0, 0, null, "Oba, um viajante! Veio ver a Rainha? Acho q ela tá ocupada agora com uns visitantes esquisitos, vai pra loja do meu pai em vez disso!"));
    npcs.adicionarBanco(new NPC("Máquina de Lavar Consciente Maligna", "Robo", 10, 10, 0, 0, 0, null, "Naaaaaaaaoooo meu robôzinho! Justo agora que eu estava obrigando essazinha ai a me passar o castelo."));
    npcs.adicionarBanco(new NPC("Rainha Chiclete", "Humano", 7, 10, 0, 0, 0, null, "Muito obrigada por acabar com essa máquina imprestável, veio me entregar algo??"));
    npcs.criarBanco();
///////////////////////////////////////////////////////////////////////////////////////////////////

    BancoSala salas = new BancoSala();

ControllerInicializar.setBancoArmas(armas);

    ControllerInicializar.setBancoMagias(bancoMagia);
    ControllerInicializar.setBancoItens(itens);
    ControllerInicializar.setBancoInimigos(inimigos);
    ControllerInicializar.setBancoNPC(npcs);
    ControllerInicializar.setBancoSalas(salas);
// =========================
// BOSQUE INICIAL
// =========================

    Sala salaBosqueInicial = new Sala("Bosque inicial", "Um bosque calmo e sem vida.\nTalvez não fosse tão silencioso séculos atrás...");

    ArrayList<Inimigo> inimigosBosqueInicial = new ArrayList<>();
    ArrayList<NPC> npcsBosqueInicial = new ArrayList<>();
    ArrayList<Item> itensBosqueInicial = new ArrayList<>();

    salaBosqueInicial.setInimigoNaSala(inimigosBosqueInicial);
    salaBosqueInicial.setNpcNaSala(npcsBosqueInicial);
    salaBosqueInicial.setItemNaSala(itensBosqueInicial);

    salas.adicionarSala(salaBosqueInicial);


// =========================
// CENTRO FLORESTA
// =========================

    Sala salaCentroFloresta = new Sala("Centro floresta", "O coração de uma floresta perigosa.\nAs árvores estão ocas, as cavernas vazias e o céu nublado.\nO som das folhas quebrando sobre seu peso é a única coisa animada aqui.");

    ArrayList<Inimigo> inimigosCentroFloresta = new ArrayList<>();
    ArrayList<NPC> npcsCentroFloresta = new ArrayList<>();
    ArrayList<Item> itensCentroFloresta = new ArrayList<>();

    salaCentroFloresta.setInimigoNaSala(inimigosCentroFloresta);
    salaCentroFloresta.setNpcNaSala(npcsCentroFloresta);
    salaCentroFloresta.setItemNaSala(itensCentroFloresta);

    salas.adicionarSala(salaCentroFloresta);


// =========================
// JARDIM DOS SLIMES
// =========================

    Sala salaJardimDosSlimes = new Sala("Jardim dos slimes", "Um campo agradável, menos a presença óbvia de vários slimes.\nAo mesmo tempo que são adoráveis, é melhor não chegar perto...\neles absorvem seu corpo e sugam os nutrientes, restando apenas suas roupas para elas usarem!");

    ArrayList<Inimigo> inimigosJardimDosSlimes = new ArrayList<>();
    ArrayList<NPC> npcsJardimDosSlimes = new ArrayList<>();
    ArrayList<Item> itensJardimDosSlimes = new ArrayList<>();

    inimigosJardimDosSlimes.add(
            ControllerInicializar.getBancoInimigo().getDado("Slime")
    );

    inimigosJardimDosSlimes.add(
            ControllerInicializar.getBancoInimigo().getDado("Slime")
    );

    inimigosJardimDosSlimes.add(
            ControllerInicializar.getBancoInimigo().getDado("Slime")
    );

    itensJardimDosSlimes.add(
            ControllerInicializar.getBancoItens().getDado("Flor roxa")
    );

    salaJardimDosSlimes.setInimigoNaSala(inimigosJardimDosSlimes);
    salaJardimDosSlimes.setNpcNaSala(npcsJardimDosSlimes);
    salaJardimDosSlimes.setItemNaSala(itensJardimDosSlimes);

    salas.adicionarSala(salaJardimDosSlimes);


// =========================
// ÁRVORE DOS ESQUILOS
// =========================

    Sala salaArvoreDosEsquilos = new Sala("Árvore dos esquilos", "Parece que você entrou no território DELES.\nEsquilos passaram por inúmeras transformações com o tempo.\nVários solos ficaram infectados e, com isso, tudo que vem deles!\nSe você comer as frutinhas daqui, pode ganhar membros, mudar de cor ou PIOR!");

    ArrayList<Inimigo> inimigosArvoreDosEsquilos = new ArrayList<>();
    ArrayList<NPC> npcsArvoreDosEsquilos = new ArrayList<>();
    ArrayList<Item> itensArvoreDosEsquilos = new ArrayList<>();

    inimigosArvoreDosEsquilos.add(
            ControllerInicializar.getBancoInimigo().getDado("Esquilo Vermelho")
    );

    inimigosArvoreDosEsquilos.add(
            ControllerInicializar.getBancoInimigo().getDado("Esquilo Verde")
    );

    inimigosArvoreDosEsquilos.add(
            ControllerInicializar.getBancoInimigo().getDado("Esquilo Azul")
    );

    salaArvoreDosEsquilos.setInimigoNaSala(inimigosArvoreDosEsquilos);
    salaArvoreDosEsquilos.setNpcNaSala(npcsArvoreDosEsquilos);
    salaArvoreDosEsquilos.setItemNaSala(itensArvoreDosEsquilos);

    salas.adicionarSala(salaArvoreDosEsquilos);


// =========================
// CLAREIRA
// =========================

    Sala salaClareira = new Sala("Clareira", "Um espaço sem árvores no meio da floresta, bem mais tranquilo que o resto.\nTem um cara de orelhas pontudas logo ali, observando a paisagem de cenho franzido.\nTalvez seja bom falar com ele?");

    ArrayList<Inimigo> inimigosClareira = new ArrayList<>();
    ArrayList<NPC> npcsClareira = new ArrayList<>();
    ArrayList<Item> itensClareira = new ArrayList<>();

    npcsClareira.add(
            ControllerInicializar.getBancoNPC().getDado("Nomade Diego")
    );

    salaClareira.setInimigoNaSala(inimigosClareira);
    salaClareira.setNpcNaSala(npcsClareira);
    salaClareira.setItemNaSala(itensClareira);

    salas.adicionarSala(salaClareira);


// =========================
// FIM DA FLORESTA
// =========================

    Sala salaFimDaFloresta = new Sala("Fim da floresta", "Aqui marca o fim das grandes árvores da pequena floresta de onde você veio.\nAs árvores rarefeitam, os montes se abrem nos horizontes, colorindo o mundo com ondas verdes!\n"
            + "AAAAAAAAAAUUUUUUUUUUUUUUUUUUU!!!");

    ArrayList<Inimigo> inimigosFimDaFloresta = new ArrayList<>();
    ArrayList<NPC> npcsFimDaFloresta = new ArrayList<>();
    ArrayList<Item> itensFimDaFloresta = new ArrayList<>();

    inimigosFimDaFloresta.add(
            ControllerInicializar.getBancoInimigo().getDado("Lobo")
    );
    inimigosFimDaFloresta.add(
            ControllerInicializar.getBancoInimigo().getDado("Lobo")
    );

    salaFimDaFloresta.setInimigoNaSala(inimigosFimDaFloresta);
    salaFimDaFloresta.setNpcNaSala(npcsFimDaFloresta);
    salaFimDaFloresta.setItemNaSala(itensFimDaFloresta);

    salas.adicionarSala(salaFimDaFloresta);


// =========================
// CENTRO DA VILA
// =========================

    Sala salaCentroDaVila = new Sala("Centro da vila", "O ponto de entrada de uma pequena vila, bem bonita por sinal.\nO letreiro está quase brilhando de tão limpo, 'Centro da Vila Linda'!\nQue bom que eles tem autoestima!");

    ArrayList<Inimigo> inimigosCentroDaVila = new ArrayList<>();
    ArrayList<NPC> npcsCentroDaVila = new ArrayList<>();
    ArrayList<Item> itensCentroDaVila = new ArrayList<>();

    npcsCentroDaVila.add(
            ControllerInicializar.getBancoNPC().getDado("Abravanelson")
    );

    salaCentroDaVila.setInimigoNaSala(inimigosCentroDaVila);
    salaCentroDaVila.setNpcNaSala(npcsCentroDaVila);
    salaCentroDaVila.setItemNaSala(itensCentroDaVila);

    salas.adicionarSala(salaCentroDaVila);


// =========================
// CASA: ALDEÃO
// =========================

    Sala salaCasaAldeao = new Sala("Casa", "Uma casa qualquer, talvez você não devesse ter entrado aqui.\n");

    ArrayList<Inimigo> inimigosCasaAldeao = new ArrayList<>();
    ArrayList<NPC> npcsCasaAldeao = new ArrayList<>();
    ArrayList<Item> itensCasaAldeao = new ArrayList<>();

    npcsCasaAldeao.add(
            ControllerInicializar.getBancoNPC().getDado("Aldeão")
    );

    salaCasaAldeao.setInimigoNaSala(inimigosCasaAldeao);
    salaCasaAldeao.setNpcNaSala(npcsCasaAldeao);
    salaCasaAldeao.setItemNaSala(itensCasaAldeao);

    salas.adicionarSala(salaCasaAldeao);


// =========================
// LOJA: SILVIO
// =========================

    Sala salaLojaSilvio = new Sala("Loja", "Uma lojinha! Uma pena você não ter dinheiro para comprar nada.\n");

    ArrayList<Inimigo> inimigosLojaSilvio = new ArrayList<>();
    ArrayList<NPC> npcsLojaSilvio = new ArrayList<>();
    ArrayList<Item> itensLojaSilvio = new ArrayList<>();

    npcsLojaSilvio.add(
            ControllerInicializar.getBancoNPC().getDado("Vendedor Silvio")
    );

    itensLojaSilvio.add(
            ControllerInicializar.getBancoItens().getDado("Chocolate")
    );

    itensLojaSilvio.add(
            ControllerInicializar.getBancoItens().getDado("Poção de Vida")
    );

    itensLojaSilvio.add(
            ControllerInicializar.getBancoItens().getDado("Poção de Mana")
    );

    salaLojaSilvio.setInimigoNaSala(inimigosLojaSilvio);
    salaLojaSilvio.setNpcNaSala(npcsLojaSilvio);
    salaLojaSilvio.setItemNaSala(itensLojaSilvio);

    salas.adicionarSala(salaLojaSilvio);


// =========================
// HALL DO CASTELO
// =========================

    Sala salaHallDoCastelo = new Sala("Hall do castelo", "Um lindo e maravilhoso hall de um castelo!\nO lustre acima te diz o suficiente: é caro e você NÃO DEVERIA QUEBRAR! Talvez nem pisar no tapete de urso também!");

    ArrayList<Inimigo> inimigosHallDoCastelo = new ArrayList<>();
    ArrayList<NPC> npcsHallDoCastelo = new ArrayList<>();
    ArrayList<Item> itensHallDoCastelo = new ArrayList<>();

    itensHallDoCastelo.add(
            ControllerInicializar.getBancoItens().getDado("Mensagem dos goblins")
    );

    salaHallDoCastelo.setInimigoNaSala(inimigosHallDoCastelo);
    salaHallDoCastelo.setNpcNaSala(npcsHallDoCastelo);
    salaHallDoCastelo.setItemNaSala(itensHallDoCastelo);

    salas.adicionarSala(salaHallDoCastelo);


// =========================
// QUARTO
// =========================

    Sala salaQuarto = new Sala("Quarto", "Um quarto digno da nobreza de um castelo, mas talvez há algo aqui mais interessante do que a mobília chique...\n...ou não...");

    ArrayList<Inimigo> inimigosQuarto = new ArrayList<>();
    ArrayList<NPC> npcsQuarto = new ArrayList<>();
    ArrayList<Item> itensQuarto = new ArrayList<>();

    inimigosQuarto.add(
            ControllerInicializar.getBancoInimigo().getDado("Mago Iam Quina")
    );

    salaQuarto.setInimigoNaSala(inimigosQuarto);
    salaQuarto.setNpcNaSala(npcsQuarto);
    salaQuarto.setItemNaSala(itensQuarto);

    salas.adicionarSala(salaQuarto);

    // =========================
// COZINHA
// =========================

    Sala salaCozinha = new Sala("Cozinha", "Uma cozinha, só que bem chique!\nVocê conseguia sentir o cheiro de porco assado do hall, só não imaginava que dois goblins estivessem dilacerando ele desse jeito.");

    ArrayList<Inimigo> inimigosCozinha = new ArrayList<>();
    ArrayList<NPC> npcsCozinha = new ArrayList<>();
    ArrayList<Item> itensCozinha = new ArrayList<>();

    itensCozinha.add(
            ControllerInicializar.getBancoItens().getDado("Chave")
    );

    inimigosCozinha.add(
            ControllerInicializar.getBancoInimigo().getDado("Guarda Goblin Jeff")
    );
    inimigosCozinha.add(
            ControllerInicializar.getBancoInimigo().getDado("Guarda Goblin Ersson")
    );


    salaCozinha.setInimigoNaSala(inimigosCozinha);
    salaCozinha.setNpcNaSala(npcsCozinha);
    salaCozinha.setItemNaSala(itensCozinha);

    salas.adicionarSala(salaCozinha);

// =========================
// CLOSET
// =========================

    Sala salaCloset = new Sala("Closet", "Um closet que é quase o equivalente a outro quarto, tem o mesmo tamanho!\nTem tantos vestidos aqui que o som é abafado por camadas de tecidos!\nMas espera, o que é aquilo?!");

    ArrayList<Inimigo> inimigosCloset = new ArrayList<>();
    ArrayList<NPC> npcsCloset = new ArrayList<>();
    ArrayList<Item> itensCloset = new ArrayList<>();

    npcsCloset.add(
            ControllerInicializar.getBancoNPC().getDado("Rainha Chiclete")
    );

    npcsCloset.add(
            ControllerInicializar.getBancoNPC().getDado("Máquina de Lavar Consciente Maligna")
    );

    salaCloset.setInimigoNaSala(inimigosCloset);
    salaCloset.setNpcNaSala(npcsCloset);
    salaCloset.setItemNaSala(itensCloset);

    salas.adicionarSala(salaCloset);

    salas.criarBanco();

}