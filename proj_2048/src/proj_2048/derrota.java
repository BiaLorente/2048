/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_2048;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author 18726430
 */
public class derrota extends JFrame {

    JPanel fundo = new JPanel();                                                //Instancia Panel do fundo
    som p = new som();                                                          //Instancia o som
    JLabel mago = new JLabel();                                                 //Instancia um LAbel para mago
    JLabel morreu = new JLabel();                                               //Instancia um Label para game over
    JLabel continuar = new JLabel();                                            //Instancia o Label continuar
    JLabel sim = new JLabel();                                                  //Instancia o Label sim
    JLabel nao = new JLabel();                                                  //Instancia o Label nao
    Icon wizard = new ImageIcon("FF1NES_BlackMage_Death.png");                  //Instancia a imagem do mago
    Icon morte = new ImageIcon("fim.png");                                      //Instancia a imagem do game over
    Icon afirmar = new ImageIcon("sim.png");                                    //Instancia a imagem do sim
    Icon negar = new ImageIcon("Não.png");                                      //Instancia a imagem do nao
    Icon continuar_I = new ImageIcon("CONTINUAR.png");                          //Instancia a imagem do continuar
    java.awt.Color azul = new Color(143, 196, 245);                             //Personaliza cor azul

    public derrota() {

        p.executaSom("10convert.com_Game-Over-8-Bit-Music_br3OzOrARh4 (online-audio-converter.com).wav");
        
        continuar.setSize(300, 200);                                            //Configura a "Label "Continuar?"
        continuar.setLocation(150, 0);
        continuar.setIcon(continuar_I);
        add(continuar);

        sim.setSize(150, 100);                                                  //Configura a Label "sim"
        sim.setLocation(130, 250);
        sim.setIcon(afirmar);
        add(sim);

        nao.setSize(150, 100);                                                  //Configura a Label "nao"
        nao.setLocation(290, 247);
        nao.setIcon(negar);
        add(nao);

        sim.addMouseListener(new MouseAdapter() {                               //Evento do click do mouse para jogar novamente causado pelo sim
            public void mouseClicked(MouseEvent e) {
                dispose();
                jogoprincipal principal = new jogoprincipal();
                principal.setVisible(true);
                try {
                    p.parar();
                } catch (Exception f) {
                    System.out.print(f);

                }

            }
        });

        nao.addMouseListener(new MouseAdapter() {                               //Evento do click do mouse para sair causado pelo nao
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        mago.setSize(300, 300);                                                 //Configura o mago
        mago.setLocation(150, 100);
        mago.setIcon(wizard);
        add(mago);

        morreu.setSize(350, 350);                                               //Configura o game over
        morreu.setLocation(200, 20);
        morreu.setIcon(morte);
        add(morreu);

        fundo.setSize(600, 400);                                                //Configura o fundo
        fundo.setBackground(azul);
        add(fundo);

        setUndecorated(true);
        setLayout(null);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
