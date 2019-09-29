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
public class jogoprincipal extends JFrame  implements KeyListener{
    JPanel[][] blocos = new JPanel[4][4];
     JLabel[][] texto = new JLabel[4][4];
     JLabel pontuacao = new JLabel();
     JLabel numero_pontuacao= new JLabel();
     jogo jogo = new jogo();
      int matriz[][]= new int[4][4];
      Color teste = new Color(220,220,220);
      
    
    

    public jogoprincipal() {
        int tamx=200,tamy=115;
     
     pontuacao.setText("Pontuação:");
     pontuacao.setSize(100,80);
     pontuacao.setLocation(150, 0);
     pontuacao.setFont(new Font("Courier New", Font.ITALIC, 16));
     add(pontuacao);
     
     numero_pontuacao.setText("0");
     numero_pontuacao.setSize(100,80);
     numero_pontuacao.setLocation(250, 0);
    numero_pontuacao.setFont(new Font("Courier New", Font.ITALIC, 16));
     add(numero_pontuacao);
     

    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setLayout(null);
    setSize(800,600);
    setLocationRelativeTo(null);
    addKeyListener(this);
    
    for(int i=0;i<4;i++)
    {
       for(int j=0;j<4;j++)
       {
         
           texto[i][j]= new JLabel();
           texto[i][j].setText("0");
           texto[i][j].setSize(80, 80);
           texto[i][j].setLocation(tamx+40, tamy);
             blocos[i][j]=new JPanel();
            // blocos[i][j].setLayout(new GridLayout(4,2));
             blocos[i][j].setSize(80, 80);
             blocos[i][j].setLayout(null);
             blocos[i][j].setLocation(tamx, tamy);
             blocos[i][j].setBackground(teste);
             add(texto[i][j]);
             add(blocos[i][j]);
           
             tamx+=100;
             
        }
       tamx-=400;
        tamy+=100;

    }
    
    JPanel Fundo = new JPanel();
     Fundo.setLayout(null);
     Fundo.setSize(500,450);
     Fundo.setLocation(135,80);
     Fundo.setBackground(Color.orange);
     add(Fundo);
     jogo.inicializar(matriz);
         for(int i=0;i<4;i++)
                   {
                       for(int j=0;j<4;j++)
                       {
                           texto[i][j].setText(Integer.toString(matriz[i][j]));
                    
                       }
                   }

    

    }
    
    
    
         public void keyPressed(KeyEvent e) {  
             int aux;
               if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode()==38) {
                   aux=jogo.movimento_possivel(matriz, 1);
                   if(aux!=1)
                   {
                   jogo.mover_cima(matriz);
                   jogo.gerar_random(matriz);
                   for(int i=0;i<4;i++)
                   {
                       for(int j=0;j<4;j++)
                       {
                           texto[i][j].setText(Integer.toString(matriz[i][j]));
                    
                       }
                   }
                 
             }
                    
               }
               
                      if (e.getKeyCode() == KeyEvent.VK_A|| e.getKeyCode()==37) {
                   aux=jogo.movimento_possivel(matriz, 4);
                   if(aux!=1)
                   {
                   jogo.mover_dir(matriz);
                   jogo.gerar_random(matriz);
                   for(int i=0;i<4;i++)
                   {
                       for(int j=0;j<4;j++)
                       {
                           texto[i][j].setText(Integer.toString(matriz[i][j]));
                    
                       }
                   }
                 
             }
                   
                   
                   
                   
               }
                      
                   if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode()==39) {
                   aux=jogo.movimento_possivel(matriz, 3);
                   if(aux!=1)
                   {
                   jogo.mover_esq(matriz);
                   jogo.gerar_random(matriz);
                   for(int i=0;i<4;i++)
                   {
                       for(int j=0;j<4;j++)
                       {
                           texto[i][j].setText(Integer.toString(matriz[i][j]));
                    
                       }
                   }
                 
             }
                                     
               }
                      
                    if (e.getKeyCode() == KeyEvent.VK_S|| e.getKeyCode()==40) {
                   aux=jogo.movimento_possivel(matriz, 2);
                   if(aux!=1)
                   {
                   jogo.mover_baixo(matriz);
                   jogo.gerar_random(matriz);
                   for(int i=0;i<4;i++)
                   {
                       for(int j=0;j<4;j++)
                       {
                           texto[i][j].setText(Integer.toString(matriz[i][j]));
                    
                       }
                   }
                 
             }
                       
               }                    
                      
             
    }  
    public void keyReleased(KeyEvent e) {  
        //l.setText("Key Released");  
    }  
    public void keyTyped(KeyEvent e) {  
        //l.setText("Key Typed");  
    }  
    
}
