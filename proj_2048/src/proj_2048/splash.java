/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_2048;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author biaml
 */

//Classe splash que simula um loading
public class splash extends JFrame {

    Icon fundo = new ImageIcon("pre_menu-2048.png");                            //instancia a imagem
    JLabel fundo2 = new JLabel();                                               //instancia o label
    JLabel sair = new JLabel();                                                 //instancia o label sair 

    public splash() {
        
        sair.setSize(50, 50);                                                   //Configura o label sair
        sair.setLocation(630, 0);
        add(sair);
        
        sair.addMouseListener(new MouseAdapter() {                              //Evento do mouse para sair
            public void mouseClicked(MouseEvent e) {                
                System.exit(0);
            }            
        });
        
        fundo2.setSize(669, 334);                                               //Configura a imagem no label 
        fundo2.setIcon(fundo);
        add(fundo2);
        
        setSize(669, 334);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        
        setVisible(true);
        
    }
    
}
