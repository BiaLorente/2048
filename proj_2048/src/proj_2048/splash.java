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
 * @author 18726430
 */
public class splash extends JFrame {

    Icon fundo = new ImageIcon("pre_menu-2048.png");
    JLabel fundo2 = new JLabel();
    JLabel sair = new JLabel();

    public splash() {
        
        sair.setSize(50, 50);
        sair.setLocation(630, 0);
        add(sair);
        
        sair.addMouseListener(new MouseAdapter() {            
            public void mouseClicked(MouseEvent e) {                
                System.exit(0);
            }            
        });
        
        fundo2.setSize(669, 334);
        fundo2.setIcon(fundo);
        add(fundo2);
        
        setSize(669, 334);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        
        setVisible(true);
        
    }
    
}
