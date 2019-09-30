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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Color;

/**
 *
 * @author Wagner
 */
public class vitoria extends JFrame{
    JLabel saida = new JLabel();
    JLabel fogos1= new JLabel();
        JLabel fogos2= new JLabel();
         JLabel fogos3= new JLabel();
    JPanel fundo = new JPanel();
    java.awt.Color azul = new Color(143,196,245);
    

    public vitoria() {
       ImageIcon icon = new ImageIcon("fogo-de-artificio-imagem-animada-0037.gif");
        ImageIcon icon2 = new ImageIcon("fogo-de-artificio-imagem-animada-0092.gif");
         ImageIcon icon3 = new ImageIcon("fogo-de-artificio-imagem-animada-0089.gif");
       saida.setSize(300,150);
       saida.setLocation(50, 50);
       saida.setText("Jogo Finalizado com sucesso");
       saida.setFont(new Font("Courier New", Font.BOLD, 16));
       fogos1.setIcon(icon);
       fogos1.setSize(150,150);
       fogos1.setLocation(50, 0);
       fogos2.setIcon(icon2);
       fogos2.setSize(250,250);
       fogos2.setLocation(100, 0);
       fogos3.setIcon(icon3);
       fogos3.setSize(150,150);
       fogos3.setLocation(250, 0);
       add(fogos3);
       add(fogos2);
        add(fogos1);
       add(saida);
       som p= new som();
       p.executaSom("win (online-audio-converter.com) (1).wav");
      
       fundo.setSize(400,300);
      fundo.setBackground(azul);
      add(fundo);
  
    setLayout(null);
    setSize(400,300);
    setLocationRelativeTo(null);
    setVisible(true);
    }
}
