/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_2048;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.io.File;
//import javafx.scene.paint.Color;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author Wagner
 */
public class vitoria extends JFrame {

    JLabel saida = new JLabel();
    som p = new som();
    JLabel fogos1 = new JLabel();
    JLabel fogos2 = new JLabel();
    JLabel fogos3 = new JLabel();
    JPanel fundo = new JPanel();
    java.awt.Color azul = new Color(143, 196, 245);

    public vitoria() {
        ImageIcon icon = new ImageIcon("fogo-de-artificio-imagem-animada-0037.gif");
        ImageIcon icon2 = new ImageIcon("fogo-de-artificio-imagem-animada-0092.gif");
        ImageIcon icon3 = new ImageIcon("fogo-de-artificio-imagem-animada-0089.gif");
        JButton jogar = new JButton();
        JButton sair = new JButton();

        sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

        jogar.addActionListener(new ActionListener() {
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

        sair.setSize(150, 25);
        sair.setText("Sair?");
        sair.setLocation(210, 220);
        sair.setFocusable(false);
        sair.setBackground(Color.gray);
        sair.setBorderPainted(false);
        add(sair);

        jogar.setSize(150, 25);
        jogar.setText("jogar?");
        jogar.setLocation(30, 220);
        jogar.setFocusable(false);
        jogar.setBackground(Color.gray);
        jogar.setBorderPainted(false);
        add(jogar);

        saida.setSize(300, 150);
        saida.setLocation(60, 50);
        saida.setText("Jogo Finalizado com sucesso");
        saida.setFont(new Font("Courier New", Font.BOLD, 16));
        fogos1.setIcon(icon);
        fogos1.setSize(150, 150);
        fogos1.setLocation(50, 0);
        fogos2.setIcon(icon2);
        fogos2.setSize(250, 250);
        fogos2.setLocation(100, 0);
        fogos3.setIcon(icon3);
        fogos3.setSize(150, 150);
        fogos3.setLocation(250, 0);
        add(fogos3);
        add(fogos2);
        add(fogos1);
        add(saida);
        p.executaSom("Final Fantasy VI - Victory Fanfare(1) (online-audio-converter.com).wav");

        fundo.setSize(400, 300);
        fundo.setBackground(azul);
        add(fundo);

        setUndecorated(true);
        setLayout(null);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
