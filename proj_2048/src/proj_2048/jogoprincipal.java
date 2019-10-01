package proj_2048;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wagner
 */
//Classe que executa a logica do jogo
import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.border.EtchedBorder;

//Instancia as labels, botões, Imagens e cores usadas
public class jogoprincipal extends JFrame implements KeyListener {
                                                //Declaracoes
    JLabel[][] texto = new JLabel[4][4];
    JLabel pontuacao = new JLabel();            //label do texto pontucao
    JLabel numero_pontuacao = new JLabel();     //label do numero da pontuacao
    JLabel secreto = new JLabel();              //label do easteregg 
    JLabel setas = new JLabel();                //label das setas
    JLabel cima = new JLabel();                 //label
    JLabel esq = new JLabel();
    JLabel dir = new JLabel();
    JLabel baixo = new JLabel();
    JLabel explosao = new JLabel();             //label para a explosao
    JLabel mago = new JLabel();                 //label para o mago
    jogo jogo = new jogo();                    // intancia o jogo
    JButton reiniciar = new JButton();          //instancia o botao reiniciar
    int matriz[][] = new int[4][4];             // a matriz 4x4
    Icon staff = new ImageIcon("Aqua Staff (2).png");       //imagem do cedro do mago
    Icon explosoes = new ImageIcon("explosao.gif");         //gif da explosao
    Icon seta = new ImageIcon("seta.png");                  //imagem da seta
    Icon wizard = new ImageIcon("wizard.gif");              //gif do mago
    Icon zero = new ImageIcon("0.png");                     //imagem dos blocos 2,4,8,16,32,64,128,256,512,1024 e 2048
    Icon dois = new ImageIcon("2.png");
    Icon quatro = new ImageIcon("4.png");
    Icon oito = new ImageIcon("8.png");
    Icon dezesseis = new ImageIcon("16.png");
    Icon trintaedois = new ImageIcon("32.png");
    Icon sessentaequatro = new ImageIcon("64.png");
    Icon centoevintoeoito = new ImageIcon("128.png");
    Icon duzentosecinquentaeseis = new ImageIcon("256.png");
    Icon quinhetosedoze = new ImageIcon("512.png");
    Icon milevinteequatro = new ImageIcon("1024.png");
    Icon doismilequarentaeoitro = new ImageIcon("2048.png");
    Color fundo = new Color(135, 206, 235);                             //instancia cores da paleta rgb
    Color fundo2 = new Color(000, 142, 144);
    Icon friccao2 = new ImageIcon("2_friccao.gif");                     //gifs de friccao entre os blocos
    Icon friccao4 = new ImageIcon("4_friccao.gif");
    Icon friccao8 = new ImageIcon("8_friccao.gif");
    Icon friccao16 = new ImageIcon("16_friccao.gif");
    Icon friccao32 = new ImageIcon("32_friccao.gif");
    Icon friccao64 = new ImageIcon("64_friccao.gif");
    Icon friccao128 = new ImageIcon("128_friccao.gif");
    Icon friccao256 = new ImageIcon("256_friccao.gif");
    Icon friccao512 = new ImageIcon("512_friccao.gif");
    Icon friccao1024 = new ImageIcon("1024_friccao.gif");
    Icon juncao4 = new ImageIcon("4_juncao.gif");
    Icon juncao8 = new ImageIcon("8_juncao.gif");
    Icon juncao16 = new ImageIcon("16_juncao.gif");
    Icon juncao32 = new ImageIcon("32_juncao.gif");
    Icon juncao64 = new ImageIcon("64_juncao.gif");
    Icon juncao128 = new ImageIcon("128_juncao.gif");
    Icon juncao256 = new ImageIcon("256_juncao.gif");
    Icon juncao512 = new ImageIcon("512_juncao.gif");
    Icon juncao1024 = new ImageIcon("1024_juncao.gif");
    

    som home = new som();                                                   //instancia a musica
    som p = new som();

    public jogoprincipal() {
        int tamx = 175, tamy = 100;                     
        setResizable(false);

        explosao.setSize(500, 500);                     //configura a explosao
        explosao.setLocation(130, 50);
        add(explosao);

        home.executaSom("10convert.com_8-Bit-RPG-Music-Royal-Castle-Original-Composition_YKKUEVcMdEU (online-audio-converter.com).wav");      //inicializa a musica
        
        pontuacao.setText("Pontuação:");                                        //Configura o texto pontucao
        pontuacao.setSize(140, 80);                                             //seta o tamanho da label
        pontuacao.setLocation(190, 10);                                         //seta a posicao da label
        pontuacao.setFont(new Font("Courier New", Font.BOLD, 24));              //seta a fonte utilizada no texto e o tamnho 
        pontuacao.setForeground(Color.white);                                   //seta a cor do texto  
        add(pontuacao);                                                         //adiciona a label a classe

        numero_pontuacao.setText("0");                                          //Configura o numero da pontuacao
        numero_pontuacao.setSize(150, 80);
        numero_pontuacao.setLocation(340, 10);
        numero_pontuacao.setFont(new Font("Courier New", Font.BOLD, 24));
        numero_pontuacao.setForeground(Color.white);
        add(numero_pontuacao);

        reiniciar.setSize(150, 40);                                             //Configura o botao reinicar
        reiniciar.setLocation(320, 512);
        reiniciar.setFont(new Font("Courier New", 0, 16));
        reiniciar.setText("Reiniciar");
        reiniciar.setFocusable(false);
        reiniciar.setBorderPainted(false);
        reiniciar.setBackground(fundo2);
        reiniciar.setForeground(Color.white);
        add(reiniciar);

        secreto.setSize(50, 50);                                                //Configura o easteregg
        secreto.setLocation(650, 440);
        secreto.setIcon(staff);
        add(secreto);

        setas.setSize(100, 100);                                                //Configura setas
        setas.setLocation(40, 400);
        setas.setIcon(seta);
        add(setas);

        cima.setSize(30, 20);                                                   //Configura seta ~cima~
        cima.setLocation(80, 400);
        add(cima);

        esq.setSize(30, 20);                                                    //Configura  seta ~esquerda~ 
        esq.setLocation(40, 440);
        add(esq);

        dir.setSize(30, 20);                                                    //Configura seta ~direita~
        dir.setLocation(120, 440);
        add(dir);

        baixo.setSize(30, 20);                                                  //Configura seta ~baixo~
        baixo.setLocation(80, 480);
        add(baixo);

        cima.addMouseListener(new MouseAdapter() {                              //Evento do click do mouse para seta cima 
            public void mouseClicked(MouseEvent e) {
                int aux;
                int score = jogo.score;                                         //atualiza score
                aux = jogo.movimento_possivel(matriz, 1);                       //verifica se  possivel o movimento para cima 
                if (aux != 1) {
                    jogo.score = score;                                         //atualiza o score
                    mover_cima(matriz);                                         //faz o movimento para cima

                }
            }
        });

        baixo.addMouseListener(new MouseAdapter() {                             //Evento do click do mouse para seta baixo
            public void mouseClicked(MouseEvent e) {
                int aux;
                int score = jogo.score;                                         //atualiza score
                aux = jogo.movimento_possivel(matriz, 2);                       //verifica se  possivel o movimento para baixo
                if (aux != 1) {                                                 
                    jogo.score = score;                                         //atualiza score
                    mover_baixo(matriz);                                        //faz o movimento para baixo

                }

            }
        });

        esq.addMouseListener(new MouseAdapter() {                               //Evento do click do mouse para seta esquerda
            public void mouseClicked(MouseEvent e) {
                int aux;
                int score = jogo.score;                                         //atualiza score
                aux = jogo.movimento_possivel(matriz, 4);                       //verifica se  possivel o movimento para esquerda
                if (aux != 1) {
                    jogo.score = score;                                         //atualiza score
                    mover_dir(matriz);                                          //faz o movimento para esquerda

                }
            }
        });

        dir.addMouseListener(new MouseAdapter() {                               //Evento do click do mouse para seta direita
            public void mouseClicked(MouseEvent e) {
                int aux;
                int score = jogo.score;                                         //atualiza score
                aux = jogo.movimento_possivel(matriz, 3);                       //verifica se  possivel o movimento para direita
                if (aux != 1) {
                    jogo.score = score;                                         //atualiza score
                    mover_esq(matriz);                                          //faz o movimento para direita
     
                }

            }
        });

        mago.setSize(250, 250);                 
        mago.setLocation(500, 350);
        add(mago);

        reiniciar.addActionListener(new ActionListener() {                      //Evento do botao reiniciar para comecar o jogo de novo
            public void actionPerformed(ActionEvent e) {
                jogo.inicializar(matriz);
                jogo.score = 0;
                jogo.vitoria = 0;
                jogo.derrota = 0;
                numero_pontuacao.setForeground(Color.white);
                atualizar();

            }
        });

        secreto.addMouseListener(new MouseAdapter() {                           //Evento do mouse para o easteregg
            public void mouseClicked(MouseEvent e) {
                secreto.setIcon(null);                                          //cedro desaparece
                mago.setIcon(wizard);                                           //aparece o gif mago
                p.executaSom("rocketflame1.wav");                               //som do fogo
                explodir();                                                     //funcao da explosao

            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 600);
        setLocationRelativeTo(null);
        addKeyListener(this);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                texto[i][j] = new JLabel();
                texto[i][j].setSize(80, 80);
                texto[i][j].setLocation(tamx + 30, tamy);
                texto[i][j].setIcon(zero);
                add(texto[i][j]);

                tamx += 100;

            }
            tamx -= 400;
            tamy += 100;

        }

        JPanel Fundo2 = new JPanel();
        Fundo2.setLayout(null);
        Fundo2.setSize(410, 410);
        Fundo2.setLocation(190, 85);
        Fundo2.setBackground(Color.gray);
        Fundo2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        add(Fundo2);

        JPanel Fundo = new JPanel();
        Fundo.setLayout(null);
        Fundo.setBackground(fundo);
        Fundo.setSize(800, 600);
        add(Fundo);

        jogo.inicializar(matriz);
        atualizar();
    }
    //Funcao que verifica se ja ganhou ou perdeu o jogo, e chama a funcao que atualiza as cores dos blocos
    void atualizar() {
        int score = jogo.score;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                atualizar_cores(matriz[i][j], i, j);
            }
        }
        jogo.vitoria(matriz);                                                   //verifica se ganhou o jogo
        jogo.derrota(matriz);                                                   //verifica se perdeu
        jogo.score = score;
        numero_pontuacao.setText(Integer.toString(jogo.score));
        if (jogo.derrota == 1) {
            this.dispose(); 
                                                               //se perdeu fecha o jogo
            derrota derrota = new derrota();                                    //e da inicio a derrota
            jogo.inicializar(matriz);
            jogo.score = 0;
            jogo.vitoria = 0;
             jogo.derrota = 0;
            try {
                home.parar();
            } catch (Exception e) {

            }
            atualizar();

        }

        if (jogo.vitoria == 1) {                                                //Se ganhou fecha o jogo
            this.dispose();                                                     //e chama e da inicia a vitoria
            vitoria vitoria = new vitoria();
            jogo.inicializar(matriz);
            jogo.score = 0;
            jogo.vitoria = 0;
            jogo.derrota = 0;
            try {
                home.parar();
            } catch (Exception e) {

            }
            atualizar();

        }

    }
    //Funcao explosao que soluciona o jogo
    public void explodir() {
        Runnable kaboom = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1200);
                } catch (Exception e) {

                }
                try {
                    p.parar();                                                  //para o som
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                p.executaSom("explosion-01.wav");                               //executa som de explosao
                explosao.setIcon(explosoes);                                    //gif da explosao
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                for (int i = 0; i < 4; i++) {                                   //zera a matriz
                    for (int j = 0; j < 4; j++) {
                        matriz[i][j] = 0;
                    }
                }
                jogo.score = 999999999;                                         //seta o score com 999999999
                numero_pontuacao.setForeground(Color.red);

                matriz[2][2] = 1024;                                            //aparece o bloco 1024
                matriz[3][2] = 1024;                                            //aparece o bloco 1024
                atualizar();                                                    //chama a funcao atualizar
                try {
                    p.parar();                                          
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                explosao.setIcon(null);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                }
                mago.setIcon(null);
                secreto.setIcon(staff);
            }

        };
        Thread magica = new Thread(kaboom);
        magica.start();

    }

    //Seta a imagem dos blocos com o valor recebido da matriz
    void atualizar_cores(int valor, int i, int j) {
        switch (valor) {
            case 0:
                texto[i][j].setIcon(zero);
                break;
            case 2:
                texto[i][j].setIcon(dois);
                break;
            case 4:
                texto[i][j].setIcon(quatro);
                break;
            case 8:
                texto[i][j].setIcon(oito);
                break;
            case 16:
                texto[i][j].setIcon(dezesseis);
                break;
            case 32:
                texto[i][j].setIcon(trintaedois);
                break;
            case 64:
                texto[i][j].setIcon(sessentaequatro);
                break;
            case 128:
                texto[i][j].setIcon(centoevintoeoito);
                break;
            case 256:
                texto[i][j].setIcon(duzentosecinquentaeseis);
                break;
            case 512:
                texto[i][j].setIcon(quinhetosedoze);
                break;
            case 1024:
                texto[i][j].setIcon(milevinteequatro);

                break;
            case 2048:
                texto[i][j].setIcon(doismilequarentaeoitro);
                break;

        }
    }

     //Seta a animacao de colisao nos blocos com o valor recebido da matriz
    void animacao(int a, int b, int i, int j, int k, int l) {

        int aux1, auxX, auxY;
        aux1 = a;
        auxX = i;
        auxY = j;

        for (int h = 0; h < 2; h++) {
            switch (aux1) {
                case 2:
                    texto[auxX][auxY].setIcon(friccao2);
                    break;
                case 4:
                    texto[auxX][auxY].setIcon(friccao4);
                    break;
                case 8:
                    texto[auxX][auxY].setIcon(friccao8);
                    break;
                case 16:
                    texto[auxX][auxY].setIcon(friccao16);
                    break;
                case 32:
                    texto[auxX][auxY].setIcon(friccao32);
                    break;
                case 64:
                    texto[auxX][auxY].setIcon(friccao64);
                    break;
                case 128:
                    texto[auxX][auxY].setIcon(friccao128);
                    break;
                case 256:
                    texto[auxX][auxY].setIcon(friccao256);
                    break;
                case 512:
                    texto[auxX][auxY].setIcon(friccao512);
                    break;
                case 1024:
                    texto[auxX][auxY].setIcon(friccao1024);
                    break;
            }
            aux1 = b;
            auxX = k;
            auxY = l;
        }
    }

     //Seta a animacao de formacao de blocos com o valor recebido da matriz
    public void animacao(int valor, int x, int y){
        switch (valor) {
                case 4:
                    texto[x][y].setIcon(juncao4);
                    break;
                case 8:
                    texto[x][y].setIcon(juncao8);
                    break;
                case 16:
                    texto[x][y].setIcon(juncao16);
                    break;
                case 32:
                    texto[x][y].setIcon(juncao32);
                    break;
                case 64:
                    texto[x][y].setIcon(juncao64);
                    break;
                case 128:
                    texto[x][y].setIcon(juncao128);
                    break;
                case 256:
                    texto[x][y].setIcon(juncao256);
                    break;
                case 512:
                    texto[x][y].setIcon(juncao512);
                    break;
                case 1024:
                    texto[x][y].setIcon(juncao1024);
                    break;
            }
        
    }
    public void mover_dir(int v[][]) {
        Runnable g = new Runnable() {
            public void run() {
                int i, j, k, ver = -1, l = 0, g = 0, delay = 60;               
                posicao_M[] localizacao = new posicao_M[16];// vetor de posicoes da matriz
                for (i = 0; i < 16; i++) {
                    localizacao[i] = new posicao_M();

                }

                for (i = 0; i < 4; i++) {
                    for (j = 1; j < 4; j++) {
                        if (v[i][j] != 0) {// se posicao da matriz diferente de 0, gerar movimento
                            for (k = j; k > 0; k--) {// proximo bloco para comparar
                                if (v[i][k - 1] == 0) {// se proximo bloco igual a 0, mover
                                    v[i][k - 1] = v[i][k];
                                    v[i][k] = 0;
                                    atualizar_cores(v[i][k],i,k);//atualizar icone do bloco
                                    atualizar_cores(v[i][k-1],i,k-1);//atualizar icone do bloco
                                    try {
                                        Thread.sleep(delay);// delay para mover bloco
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    if (delay > 30) {// diminuir delay para suavizar movimento
                                        delay -= 10;
                                    }
                                } else {
                                    if (v[i][k] == v[i][k - 1]) {// se blocos iguais iniciar procedimento de verificacao de flag
                                        for (g = 0; g < l; g++) {
                                            if (i == localizacao[g].i && k == localizacao[g].j) {
                                                ver = 1;
                                            }
                                        }
                                        if (ver != 1) {// se flag valida somar
                                            localizacao[l].alterar(i, k - 1);
                                            l++;
                                            localizacao[l].alterar(i, k);
                                            l++;
                                            jogo.score += v[i][k - 1];// atualizar score
                                            v[i][k - 1] *= 2;
                                            v[i][k] = 0;
                                    atualizar_cores(v[i][k],i,k);
                                    animacao(v[i][k-1],i,k-1);
                                        }
                                    } else {
                                        if (v[i][k] != 0 && v[i][k - 1] != 0 && v[i][k] != v[i][k - 1]) {//friccao entre blocos
                                           
                                             animacao(v[i][k],v[i][k-1],i,k,i,k-1);
                                        }
                                    }
                                }
                                ver = -1;
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(150);//delay para gerar novos blocos
                } catch (InterruptedException ex) {
                    Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                jogo.gerar_random(matriz);//gerar blocos aleatorios
                atualizar();//atualizar vericacoes de jogo
            }
        };
        Thread f = new Thread(g);
        f.start();//executar thread
    }

    public void mover_esq(int v[][]) {
        Runnable g = new Runnable() {
            public void run() {
                int i, j, k, ver = -1, l = 0, g = 0, delay = 60;

                posicao_M[] localizacao = new posicao_M[16];// vetor de posicoes da matriz
                for (i = 0; i < 16; i++) {
                    localizacao[i] = new posicao_M();
                }
                for (i = 0; i < 4; i++) {
                    for (j = 2; j >= 0; j--) {
                        if (v[i][j] != 0) {// se posicao da matriz diferente de 0, gerar movimento
                            for (k = j; k < 3; k++) {// proximo bloco para comparar
                                if (v[i][k + 1] == 0) {// se proximo bloco igual a 0, mover
                                    v[i][k + 1] = v[i][k];
                                    v[i][k] = 0;
                                    atualizar_cores(v[i][k],i,k);//atualizar icone do bloco
                                    atualizar_cores(v[i][k+1],i,k+1);//atualizar icone do bloco
                                    try {
                                        Thread.sleep(delay);// delay para mover bloco
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    if (delay > 30) {
                                        delay -= 10;// diminuir delay para suavizar movimento
                                    }
                                } else {

                                    if (v[i][k] == v[i][k + 1]) {// se blocos iguais iniciar procedimento de verificacao de flag
                                        for (g = 0; g < l; g++) {
                                            if (i == localizacao[g].i && k == localizacao[g].j) {
                                                ver = 1;
                                            }
                                        }
                                        if (ver != 1) {// se flag valida somar
                                            localizacao[l].alterar(i, k + 1);
                                            l++;
                                            localizacao[l].alterar(i, k);
                                            l++;
                                            jogo.score += v[i][k + 1];// atualizar score
                                            v[i][k + 1] *= 2;
                                            v[i][k] = 0;
                                    atualizar_cores(v[i][k],i,k);
                                   animacao(v[i][k+1],i,k+1);

                                    
                                        }
                                    } else {
                                        if (v[i][k] != 0 && v[i][k + 1] != 0 && v[i][k] != v[i][k + 1]) {//friccao entre blocos
                                            animacao(v[i][k],v[i][k+1],i,k,i,k+1);
                                        }
                                    }
                                }
                                ver = -1;
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(150);//delay para gerar novos blocos
                } catch (InterruptedException ex) {
                    Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                jogo.gerar_random(matriz);
                atualizar();;//atualizar vericacoes de jogo
            }
        };
        Thread f = new Thread(g);
        f.start();//executar thread
    }

    public void mover_cima(int v[][]) {
        Runnable g = new Runnable() {
            public void run() {
                int i, j, k, ver = -1, l = 0, g = 0, delay = 60;

                posicao_M[] localizacao = new posicao_M[16];// vetor de posicoes da matriz
                for (i = 0; i < 16; i++) {
                    localizacao[i] = new posicao_M();
                }
                for (j = 0; j < 4; j++) {
                    for (i = 1; i < 4; i++) {
                        if (v[i][j] != 0) {// se posicao da matriz diferente de 0, gerar movimento
                            for (k = i; k > 0; k--) {// proximo bloco para comparar
                                if (v[k - 1][j] == 0) {// se proximo bloco igual a 0, mover
                                    v[k - 1][j] = v[k][j];
                                    v[k][j] = 0;
                                    atualizar_cores(v[k][j],k,j);//atualizar icone do bloco
                                    atualizar_cores(v[k-1][j],k-1,j);//atualizar icone do bloco
                                    try {
                                        Thread.sleep(delay);;// delay para mover bloco
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    if (delay > 30) {
                                        delay -= 10;// diminuir delay para suavizar movimento
                                    }
                                } else {
                                    if (v[k][j] == v[k - 1][j]) {// se blocos iguais iniciar procedimento de verificacao de flag
                                        for (g = 0; g < l; g++) {
                                            if (k == localizacao[g].i && j == localizacao[g].j) {
                                                ver = 1;
                                            }
                                        }
                                        if (ver != 1) {// se flag valida somar
                                            localizacao[l].alterar(k - 1, j);
                                            l++;
                                            localizacao[l].alterar(k, j);
                                            l++;
                                            jogo.score += v[k - 1][j];// atualizar score
                                            ver = k - 1;
                                            v[k - 1][j] *= 2;
                                            v[k][j] = 0;
                                            atualizar_cores(v[k][j],k,j);
                                           animacao(v[k-1][j],k-1,j);
                                        }

                                    } else {
                                        if (v[k][j] != 0 && v[k - 1][j] != 0 && v[k][j] != v[k - 1][j]) {
                                            animacao(v[k][j],v[k-1][j],k,j,k-1,j);//friccao entre blocos
                                        }
                                    }
                                }

                                ver = -1;
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(150);//delay para gerar novos blocos
                } catch (InterruptedException ex) {
                    Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                jogo.gerar_random(matriz);
                atualizar();//atualizar vericacoes de jogo
            }
        };
        Thread f = new Thread(g);
        f.start();//executar thread
    }

    public void mover_baixo(int v[][]) {
        Runnable g = new Runnable() {
            public void run() {

                int i, j, k, ver = -1, l = 0, g = 0, delay = 60;

                posicao_M[] localizacao = new posicao_M[16];// vetor de posicoes da matriz
                for (i = 0; i < 16; i++) {
                    localizacao[i] = new posicao_M();
                }
                for (j = 0; j < 4; j++) {
                    for (i = 2; i >= 0; i--) {
                        if (v[i][j] != 0) {// se posicao da matriz diferente de 0, gerar movimento
                            for (k = i; k < 3; k++) {// proximo bloco para comparar
                                if (v[k + 1][j] == 0) {// se proximo bloco igual a 0, mover
                                    v[k + 1][j] = v[k][j];
                                    v[k][j] = 0;
                                    atualizar_cores(v[k][j],k,j);//atualizar icone do bloco
                                    atualizar_cores(v[k+1][j],k+1,j);   ;//atualizar icone do bloco                              
                                    try {
                                        Thread.sleep(delay);// delay para mover bloco
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    if (delay > 30) {
                                        delay -= 10;// diminuir delay para suavizar movimento
                                    }
                                } else {
                                    if (v[k][j] == v[k + 1][j]) {// se blocos iguais iniciar procedimento de verificacao de flag

                                        for (g = 0; g < l; g++) {
                                            if (k == localizacao[g].i && j == localizacao[g].j) {
                                                ver = 1;
                                            }
                                        }
                                        if (ver != 1) {// se flag valida somar
                                            localizacao[l].alterar(k + 1, j);
                                            l++;
                                            localizacao[l].alterar(k, j);
                                            l++;
                                            jogo.score += v[k + 1][j];// atualizar score
                                            ver = k + 1;
                                            v[k + 1][j] *= 2;
                                            v[k][j] = 0;
                                            atualizar_cores(v[k][j],k,j);
                                            
                                            
                                            animacao(v[k+1][j],k+1,j);
                                        }

                                    } else {
                                        if (v[k][j] != 0 && v[k + 1][j] != 0 && v[k][j] != v[k + 1][j]) {
                                            animacao(v[k][j],v[k+1][j],k,j,k+1,j);//friccao entre blocos
                                        }
                                    }

                                }
                                ver = -1;
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(150);//delay para gerar novos blocos
                } catch (InterruptedException ex) {
                    Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                jogo.gerar_random(matriz);
                atualizar();//atualizar vericacoes de jogo
            }
        };
        Thread f = new Thread(g);
        f.start();//executar thread
    }
    //Funcao Evento para a movimentacao pelas setas direcionais e as letras "w,a,s,d" 
    public void keyPressed(KeyEvent e) {
        int aux;
        int score = jogo.score;
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == 38) {          //Se movimento para cima
            aux = jogo.movimento_possivel(matriz, 1);
            if (aux != 1) {
                jogo.score = score;
                mover_cima(matriz);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == 37) {          //Se movimento para direita
            aux = jogo.movimento_possivel(matriz, 4);
            if (aux != 1) {
                jogo.score = score;
                mover_dir(matriz);

            }
        }

        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == 39) {          //Se movimento para esquerda
            aux = jogo.movimento_possivel(matriz, 3);
            if (aux != 1) {
                jogo.score = score;
                mover_esq(matriz);

            }

        }
        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == 40) {          //Se movimento para baixo
            aux = jogo.movimento_possivel(matriz, 2);
            if (aux != 1) {
                jogo.score = score;
                mover_baixo(matriz);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
