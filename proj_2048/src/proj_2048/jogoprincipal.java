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
import javax.swing.border.LineBorder;
public class jogoprincipal extends JFrame  implements KeyListener{
    JPanel[][] blocos = new JPanel[4][4];
     JLabel[][] texto = new JLabel[4][4];
     JLabel pontuacao = new JLabel();
     JLabel numero_pontuacao= new JLabel();
     jogo jogo = new jogo();
     JButton reiniciar= new JButton();
      int matriz[][]= new int[4][4];
      Color zero = new Color(220,220,220);
      
    
    

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
     
     reiniciar.setSize(150,40);
     reiniciar.setLocation(350, 20);
     reiniciar.setFont(new Font("Courier New", Font.ITALIC, 16));
     reiniciar.setText("Reiniciar");
     reiniciar.setFocusable(false);
     add(reiniciar);
     
    reiniciar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      jogo.inicializar(matriz);
      jogo.score=0;
      atualizar();
      }
    });
     
     
     
     
     
     
     
     
     

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
           texto[i][j].setSize(80, 80);
           texto[i][j].setLocation(tamx+30, tamy);
           texto[i][j].setFont(new Font("Bahnschrift SemiLight", Font.BOLD, 20));
             blocos[i][j]=new JPanel();
             blocos[i][j].setSize(80, 80);
             blocos[i][j].setLayout(null);
             blocos[i][j].setLocation(tamx, tamy);
             blocos[i][j].setBackground(zero);
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
      atualizar();
    }
    
    void atualizar()
    {
        int score=jogo.score;
        for(int i=0;i<4;i++)
                   {
                       for(int j=0;j<4;j++)
                       {
                           if(matriz[i][j]!=0)
                           {
                           texto[i][j].setText(Integer.toString(matriz[i][j]));
                           }
                           else
                           {
                              blocos[i][j].setBorder(null); 
                               texto[i][j].setText("");
                           }
                    
                       }
                   }
         jogo.vitoria(matriz);
        jogo.derrota(matriz);
        jogo.score=score;
        numero_pontuacao.setText(Integer.toString(jogo.score));
        if(jogo.derrota==1)
        {
            System.out.print("cccccc");
        }
    }
    
    void atualizar_cores(int valor,int i, int j)
    {
        switch(valor)
        {
            case 0:
                blocos[i][j].setBackground(zero);
                break;
            case 2:
                blocos[i][j].setBackground(zero);
                break;
            case 4:
                 blocos[i][j].setBackground(zero);
                break;
            case 8:
                 blocos[i][j].setBackground(zero);
                break;
            case 16:
                 blocos[i][j].setBackground(zero);
                break;
             case 32:
                 blocos[i][j].setBackground(zero);
                break;
             case 64:
                 blocos[i][j].setBackground(zero);
                break;
             case 128:
                 blocos[i][j].setBackground(zero);
                break;
              case 256:
                 blocos[i][j].setBackground(zero);
                break;
               case 512:
                 blocos[i][j].setBackground(zero);
                break;
                case 1024:
                 blocos[i][j].setBackground(zero);
                break;
                 case 2048:
                 blocos[i][j].setBackground(zero);
                break;
                
                
        }
    }
            
    
         public void keyPressed(KeyEvent e) {  
             int aux;
             int score=jogo.score;
               if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode()==38) {
                   aux=jogo.movimento_possivel(matriz, 1);
                   if(aux!=1)
                   {
                       jogo.score=score;
                   jogo.mover_cima(matriz);
                   jogo.gerar_random(matriz);
                   atualizar();
             }
                    
               }
                if (e.getKeyCode() == KeyEvent.VK_A|| e.getKeyCode()==37) {
                   aux=jogo.movimento_possivel(matriz, 4);
                   if(aux!=1)
                   {
                    jogo.score=score;
                   jogo.mover_dir(matriz);
                   jogo.gerar_random(matriz);
                   atualizar(); 
             }
               }
                      
                   if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode()==39) {
                   aux=jogo.movimento_possivel(matriz, 3);
                   if(aux!=1)
                   {
                    jogo.score=score;
                   jogo.mover_esq(matriz);
                   jogo.gerar_random(matriz);
                   atualizar();
                 
             }
                                     
               }
                      
                    if (e.getKeyCode() == KeyEvent.VK_S|| e.getKeyCode()==40) {
                   aux=jogo.movimento_possivel(matriz, 2);
                   if(aux!=1)
                   {
                    jogo.score=score;
                   jogo.mover_baixo(matriz);
                   jogo.gerar_random(matriz);
                   atualizar();
             }
                       
               }                                         
    }  
    public void keyReleased(KeyEvent e) {   
    }  
    public void keyTyped(KeyEvent e) {  
    }  
    
}
