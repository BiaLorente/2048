/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_2048;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author 18726430
 */
public class derrota extends JFrame{
     JPanel fundo = new JPanel();
    som p = new som();
    JLabel mago = new JLabel();
    JLabel morreu = new JLabel();
    Icon wizard = new ImageIcon("FF1NES_BlackMage_Death.png");
    Icon morte = new ImageIcon("fim.png");
        java.awt.Color azul = new Color(143, 196, 245);

    public derrota() {
        mago.setSize(300,300);
        mago.setLocation(150,100);
        mago.setIcon(wizard);
        add(mago);
        
        morreu.setSize(350,350);
        morreu.setLocation(200,20);
        morreu.setIcon(morte);
        add(morreu);
        
        
        fundo.setSize(600, 400);
        fundo.setBackground(azul);
        add(fundo);
        
        setUndecorated(true);
        setLayout(null);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        p.executaSom("10convert.com_Dark-Souls-You-Died-Sound-Effect_CpaT28qMfis (online-audio-converter.com).wav");
        
    }
    
    
}
