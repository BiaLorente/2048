/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_2048;

import java.awt.Font;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Wagner
 */
public class vitoria extends JFrame {

    JLabel saida = new JLabel();                                                //Label sair
    som p = new som();                                                          //instancia som
    JLabel fogos1 = new JLabel();                                               //instancia label dos fogos
    JLabel fogos2 = new JLabel();
    JLabel fogos3 = new JLabel();
    JPanel fundo = new JPanel();
    JLabel wizard = new JLabel();                                               //instancia label do mago
    JLabel wizard2 = new JLabel();                                              //instancia label do mago2
    java.awt.Color azul = new Color(143, 196, 245);                             //personaliza a cor azul
    Color fundo2 = new Color(000, 142, 144);                                  //personaliza a cor do fundo2

    public vitoria() {
        ImageIcon icon = new ImageIcon("fogo-de-artificio-imagem-animada-0037.gif");    //instancia imagem dos gifs de fogo de artificio
        ImageIcon icon2 = new ImageIcon("fogo-de-artificio-imagem-animada-0092.gif");
        ImageIcon icon3 = new ImageIcon("fogo-de-artificio-imagem-animada-0089.gif");
        ImageIcon mago = new ImageIcon("mago_alegre.gif");                              //instancia imagem do gif do mago
        JButton jogar = new JButton();                                                  //nstancia botao jogar?
        JButton sair = new JButton();                                                   //instancia botao sair?

        sair.addActionListener(new ActionListener() {                           //Evento do mouse para sair
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

        jogar.addActionListener(new ActionListener() {                          //Evento do mouse para jogar novamente
            public void actionPerformed(ActionEvent e) {

                jogoprincipal principal = new jogoprincipal();
                principal.setVisible(true);
                try {
                    p.parar();
                } catch (Exception f) {

                }
                dispose();

            }
        });

        wizard.setIcon(mago);                                                   //Configura mago
        wizard.setSize(200, 200);
        wizard.setLocation(25, 80);
        add(wizard);

        wizard2.setIcon(mago);
        wizard2.setSize(200, 200);
        wizard2.setLocation(465, 80);
        add(wizard2);

        sair.setSize(150, 25);                                                  //Configura botao sair
        sair.setText("Sair?");
        sair.setLocation(320, 320);
        sair.setFocusable(false);

        sair.setBackground(fundo2);
        sair.setForeground(Color.white);
        sair.setBorderPainted(false);
        add(sair);

        jogar.setSize(150, 25);                                                 //Configura botao jogar
        jogar.setText("jogar?");
        jogar.setLocation(130, 320);
        jogar.setFocusable(false);
        jogar.setBackground(fundo2);
        jogar.setForeground(Color.white);
        jogar.setBorderPainted(false);
        add(jogar);

        saida.setSize(300, 150);                                                //Configura Label da saida
        saida.setLocation(150, 120);
        saida.setText("Jogo Finalizado com sucesso");
        saida.setFont(new Font("Courier New", Font.BOLD, 18));
        saida.setForeground(Color.white);
        fogos1.setIcon(icon);
        fogos1.setSize(150, 150);
        fogos1.setLocation(120, 110);
        fogos2.setIcon(icon2);
        fogos2.setSize(250, 250);
        fogos2.setLocation(200, 50);
        fogos3.setIcon(icon3);
        fogos3.setSize(150, 150);
        fogos3.setLocation(350, 110);
        add(fogos3);
        add(fogos2);
        add(fogos1);
        add(saida);
        p.executaSom("Final Fantasy VI - Victory Fanfare(1) (online-audio-converter.com).wav");

        fundo.setSize(600, 400);
        fundo.setBackground(azul);
        add(fundo);

        setUndecorated(true);
        setLayout(null);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
