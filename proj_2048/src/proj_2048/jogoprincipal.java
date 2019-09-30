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
import java.awt.Color;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class jogoprincipal extends JFrame implements KeyListener {

    JLabel[][] texto = new JLabel[4][4];
    JLabel pontuacao = new JLabel();
    JLabel numero_pontuacao = new JLabel();
    JLabel secreto = new JLabel();
    JLabel setas = new JLabel();
    JLabel cima = new JLabel();
    JLabel esq = new JLabel();
    JLabel dir = new JLabel();
    JLabel baixo = new JLabel();
    JLabel explosao = new JLabel();
    JLabel mago = new JLabel();
    jogo jogo = new jogo();
    JButton reiniciar = new JButton();
    int matriz[][] = new int[4][4];
    Icon staff = new ImageIcon("Aqua Staff (2).png");
    Icon explosoes = new ImageIcon("explosao.gif");
    Icon seta = new ImageIcon("seta.png");
    Icon wizard = new ImageIcon("wizard.gif");
    Icon zero = new ImageIcon("0.png");
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
    Color fundo = new Color(135, 206, 235);
    Color fundo2 = new Color(000, 142, 144);

    som home = new som();
    som p = new som();

    public jogoprincipal() {
        int tamx = 175, tamy = 100;
        setResizable(false);

        explosao.setSize(500, 500);
        explosao.setLocation(130, 50);
        add(explosao);

        home.executaSom("10convert.com_8-Bit-RPG-Music-Royal-Castle-Original-Composition_YKKUEVcMdEU (online-audio-converter.com).wav");
        pontuacao.setText("Pontuação:");
        pontuacao.setSize(140, 80);
        pontuacao.setLocation(190, 10);
        pontuacao.setFont(new Font("Courier New", Font.BOLD, 24));
        pontuacao.setForeground(Color.white);
        add(pontuacao);

        numero_pontuacao.setText("0");
        numero_pontuacao.setSize(150, 80);
        numero_pontuacao.setLocation(340, 10);
        numero_pontuacao.setFont(new Font("Courier New", Font.BOLD, 24));
        numero_pontuacao.setForeground(Color.white);
        add(numero_pontuacao);

        reiniciar.setSize(150, 40);
        reiniciar.setLocation(320, 512);
        reiniciar.setFont(new Font("Courier New", 0, 16));
        reiniciar.setText("Reiniciar");
        reiniciar.setFocusable(false);
         reiniciar.setBorderPainted(false);
        reiniciar.setBackground(fundo2);
        reiniciar.setForeground(Color.white);
        add(reiniciar);

        secreto.setSize(50, 50);
        secreto.setLocation(650, 440);
        secreto.setIcon(staff);
        add(secreto);

        setas.setSize(100, 100);
        setas.setLocation(40, 400);
        setas.setIcon(seta);
        add(setas);

        cima.setSize(30, 20);
        cima.setLocation(80, 400);
        add(cima);

        esq.setSize(30, 20);
        esq.setLocation(40, 440);
        add(esq);

        dir.setSize(30, 20);
        dir.setLocation(120, 440);
        add(dir);

        baixo.setSize(30, 20);
        baixo.setLocation(80, 480);
        add(baixo);

        cima.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int aux;
                int score = jogo.score;
                aux = jogo.movimento_possivel(matriz, 1);
                if (aux != 1) {
                    jogo.score = score;
                    mover_cima(matriz);
                   
                }
            }
        });

        baixo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int aux;
                int score = jogo.score;
                aux = jogo.movimento_possivel(matriz, 2);
                if (aux != 1) {
                    jogo.score = score;
                    mover_baixo(matriz);

                }

            }
        });

        esq.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int aux;
                int score = jogo.score;
                aux = jogo.movimento_possivel(matriz, 4);
                if (aux != 1) {
                    jogo.score = score;
                    mover_dir(matriz);

                }
            }
        });

        dir.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int aux;
                int score = jogo.score;
                aux = jogo.movimento_possivel(matriz, 3);
                if (aux != 1) {
                    jogo.score = score;
                    //jogo.mover_esq(matriz);
                    mover_esq(matriz);
                      //jogo.gerar_random(matriz);
                    // atualizar();

                }

            }
        });

        mago.setSize(250, 250);
        mago.setLocation(500, 350);
        add(mago);

        reiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jogo.inicializar(matriz);
                jogo.score = 0;
                jogo.vitoria = 0;
                jogo.derrota = 0;
                numero_pontuacao.setForeground(Color.white);
                atualizar();

            }
        });

        secreto.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                secreto.setIcon(null);
                mago.setIcon(wizard);
                explodir();

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
        //Fundo.setLocationRelativeTo(null);
        add(Fundo);

        jogo.inicializar(matriz);
        atualizar();
    }

    void atualizar() {
        int tamx = 175, tamy = 100;
        int score = jogo.score;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                atualizar_cores(matriz[i][j], i, j, tamx, tamy);
                tamx += 100;
            }
            tamx -= 400;
            tamy += 100;
        }
        jogo.vitoria(matriz);
        jogo.derrota(matriz);
        jogo.score = score;
        numero_pontuacao.setText(Integer.toString(jogo.score));
        if (jogo.derrota == 1) {
            this.dispose();
            derrota derrota = new derrota();
           jogo.score = 0;
            jogo.vitoria = 0;
            jogo.derrota = 0;
            try {
                home.parar();
            } catch (Exception e) {

            }
            
        }

        if (jogo.vitoria == 1) {
            this.dispose();
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


    public void explodir() {
        Runnable kaboom = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1200);
                } catch (Exception e) {

                }
                p.executaSom("explosion-01.wav");
                explosao.setIcon(explosoes);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        matriz[i][j] = 0;
                    }
                }
                jogo.score = 999999999;
                numero_pontuacao.setForeground(Color.red);

                matriz[2][2] = 1024;
                matriz[3][2] = 1024;
                atualizar();
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

    void atualizar_cores(int valor, int i, int j, int tamx, int tamy) {
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
    
    
    
     public void mover_dir(int v[][]) {
                          Runnable g = new Runnable() {
            public void run() {
        int i, j, k, ver = -1, l = 0, g = 0,delay=70;

        posicao_M[] localizacao = new posicao_M[16];
        for (i = 0; i < 16; i++) {
            localizacao[i] = new posicao_M();

        }

        for (i = 0; i < 4; i++) {
            for (j = 1; j < 4; j++) {
                if (v[i][j] != 0) {
                    for (k = j; k > 0; k--) {
                        if (v[i][k - 1] == 0) {
                            v[i][k - 1] = v[i][k];
                            v[i][k] = 0;
                            atualizar();
                            try {
                                Thread.sleep(delay);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if(delay>30)
                            {
                                delay-=10;
                            }
                        } else {
                            if (v[i][k] == v[i][k - 1]) {
                                for (g = 0; g < l; g++) {
                                    if (i == localizacao[g].i && k == localizacao[g].j) {
                                        ver = 1;
                                    }

                                }
                                if (ver != 1) {
                                    localizacao[l].alterar(i, k - 1);
                                    l++;
                                    localizacao[l].alterar(i, k);
                                    l++;
                                    jogo.score += v[i][k - 1];
                                    v[i][k - 1] *= 2;
                                    v[i][k] = 0;
                                }

                            }
                        }
                        ver = -1;
                    }
                }
            }
        }
                        try {
                    Thread.sleep(150);
                } catch (InterruptedException ex) {
                    Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                                      jogo.gerar_random(matriz);
                     atualizar();
        
                    }

        };
        Thread f = new Thread(g);
        f.start();

    }
    
    
    
    
    
    
     public void mover_esq(int v[][]) {
                 Runnable g = new Runnable() {
            public void run() {
        int i, j, k, ver = -1, l = 0, g = 0,delay=70;

        posicao_M[] localizacao = new posicao_M[16];
        for (i = 0; i < 16; i++) {
            localizacao[i] = new posicao_M();

        }

        for (i = 0; i < 4; i++) {
            for (j = 2; j >= 0; j--) {
                if (v[i][j] != 0) {
                    for (k = j; k < 3; k++) {
                        if (v[i][k + 1] == 0) {
                            v[i][k + 1] = v[i][k];
                            v[i][k] = 0;
                            atualizar();
                            try {
                                Thread.sleep(delay);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if(delay>30)
                            {
                                delay-=10;
                            }
                        } else {

                            if (v[i][k] == v[i][k + 1]) {
                                for (g = 0; g < l; g++) {
                                    if (i == localizacao[g].i && k == localizacao[g].j) {
                                        ver = 1;
                                    }

                                }
                                if (ver != 1) {
                                    localizacao[l].alterar(i, k + 1);
                                    l++;
                                    localizacao[l].alterar(i, k);
                                    l++;
                                    jogo.score += v[i][k + 1];
                                    v[i][k + 1] *= 2;
                                    v[i][k] = 0;
                                }
                            }
                        }
                        ver = -1;
                    }
                }
            }
        }
                try {
                    Thread.sleep(150);
                } catch (InterruptedException ex) {
                    Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                                      jogo.gerar_random(matriz);
                     atualizar();
        
                    }

        };
        Thread f = new Thread(g);
        f.start();
    }
    
    
    
    
     public void mover_cima(int v[][]) {
            Runnable g = new Runnable() {
            public void run() {
        int i, j, k, ver = -1, l = 0, g = 0,delay=70;

        posicao_M[] localizacao = new posicao_M[16];
        for (i = 0; i < 16; i++) {
            localizacao[i] = new posicao_M();

        }

        for (j = 0; j < 4; j++) {
            for (i = 1; i < 4; i++) {
                if (v[i][j] != 0) {
                    for (k = i; k > 0; k--) {
                        if (v[k - 1][j] == 0) {
                            v[k - 1][j] = v[k][j];
                            v[k][j] = 0;
                            atualizar();
                            try {
                                Thread.sleep(delay);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if(delay>30)
                            {
                                delay-=10;
                            }
                        } else {
                            if (v[k][j] == v[k - 1][j]) {
                                for (g = 0; g < l; g++) {
                                    if (k == localizacao[g].i && j == localizacao[g].j) {
                                        ver = 1;
                                    }

                                }
                                if (ver != 1) {
                                    localizacao[l].alterar(k - 1, j);
                                    l++;
                                    localizacao[l].alterar(k, j);
                                    l++;
                                    jogo.score += v[k - 1][j];
                                    ver = k - 1;
                                    v[k - 1][j] *= 2;
                                    v[k][j] = 0;
                                }

                            }
                        }
                        ver = -1;
                    }
                }
            }
        }
                        try {
                    Thread.sleep(150);
                } catch (InterruptedException ex) {
                    Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                                      jogo.gerar_random(matriz);
                     atualizar();
        
                    
        
                            }

        };
        Thread f = new Thread(g);
        f.start();

    }
     
     
     
     
     
         public void mover_baixo(int v[][]) {
                         Runnable g = new Runnable() {
            public void run() {

        int i, j, k, ver = -1, l = 0, g = 0,delay=70;

        posicao_M[] localizacao = new posicao_M[16];
        for (i = 0; i < 16; i++) {
            localizacao[i] = new posicao_M();

        }

        for (j = 0; j < 4; j++) {
            for (i = 2; i >= 0; i--) {
                if (v[i][j] != 0) {
                    for (k = i; k < 3; k++) {
                        if (v[k + 1][j] == 0) {
                            v[k + 1][j] = v[k][j];
                            v[k][j] = 0;
                            
                             atualizar();
                            try {
                                Thread.sleep(delay);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if(delay>30)
                            {
                                delay-=10;
                            }
                            
                            
                            
                        } else {
                            if (v[k][j] == v[k + 1][j]) {

                                for (g = 0; g < l; g++) {
                                    if (k == localizacao[g].i && j == localizacao[g].j) {
                                        ver = 1;
                                    }

                                }

                                if (ver != 1) {
                                    localizacao[l].alterar(k + 1, j);
                                    l++;
                                    localizacao[l].alterar(k, j);
                                    l++;
                                    jogo.score += v[k + 1][j];
                                    ver = k + 1;
                                    v[k + 1][j] *= 2;
                                    v[k][j] = 0;
                                }

                            }
                        }
                        ver = -1;
                    }
                }
            }
        }
                                try {
                    Thread.sleep(150);
                } catch (InterruptedException ex) {
                    Logger.getLogger(jogoprincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                                      jogo.gerar_random(matriz);
                     atualizar();
                                    }

        };
        Thread f = new Thread(g);
        f.start();
    }
     
     
     
    
    
    
    
    public void keyPressed(KeyEvent e) {
        int aux;
        int score = jogo.score;
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == 38) {
            aux = jogo.movimento_possivel(matriz, 1);
            if (aux != 1) {
                jogo.score = score;
                mover_cima(matriz);
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == 37) {
            aux = jogo.movimento_possivel(matriz, 4);
            if (aux != 1) {
                jogo.score = score;
                mover_dir(matriz);

            }
        }

        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == 39) {
            aux = jogo.movimento_possivel(matriz, 3);
            if (aux != 1) {
                jogo.score = score;
                mover_esq(matriz);

            }

        }

        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == 40) {
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
