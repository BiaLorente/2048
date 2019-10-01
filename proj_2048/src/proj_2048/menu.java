/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_2048;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import proj_2048.jogoprincipal;

/**
 *
 * @author biaml
 */

// Classe menu tem a funcao start para dar inicio ao jogo em si, e mais funcoes complementares.

//instancia a imagem do menu(Icon), a label onde o menu será posto, a função sair e start, e instancia uma label para o mago.
public class menu extends JFrame {

    Icon fundo = new ImageIcon("menu_start.png"); //imagem do menu        
    JLabel fundo2 = new JLabel();                // label onde o menu sera posto
    JLabel sair = new JLabel();                 // label sair
    JLabel start = new JLabel();                //label start
    JLabel wizard = new JLabel();               //label do mago


    public menu() {
        
         ImageIcon mago = new ImageIcon("mago_alegre.gif");     //instancia o gif do mago

         
        wizard.setIcon(mago);                                   //instancia o gif na label
        wizard.setSize(200, 200);
        wizard.setLocation(25, 140);
        add(wizard);
                    
        sair.setSize(50, 50);                                   //configura o label sair no "X" da imagem
        sair.setLocation(630, 0);
        add(sair);
        
        sair.addMouseListener(new MouseAdapter() {            //evento de click do mouse para sair
            public void mouseClicked(MouseEvent e) {                
                System.exit(0);
            }            
        });
        
        start.setSize(100,100);                                  //configura o label start no "START" da imagem
        start.setLocation(270, 220);
        add(start);
        
                start.addMouseListener(new MouseAdapter() {        //evento do click do mouse para dar start    
            public void mouseClicked(MouseEvent e) {
                dispose();
                jogoprincipal jogo = new jogoprincipal();
                jogo.setVisible(true);
            }            
        });
        
        fundo2.setSize(669, 334);                                //confugura a imagem menu na label
        fundo2.setIcon(fundo);
        add(fundo2);
        
        setSize(669, 334);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        
        setVisible(true);
        
    }
    
}
