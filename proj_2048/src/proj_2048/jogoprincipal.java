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
     JLabel[][] texto = new JLabel[4][4];
     JLabel pontuacao = new JLabel();
     JLabel numero_pontuacao= new JLabel();
     JLabel secreto= new JLabel();
     jogo jogo = new jogo();
     JButton reiniciar= new JButton();
      int matriz[][]= new int[4][4];
       Icon zero = new ImageIcon("0.png");
       Icon dois = new ImageIcon ("2.png");
       Icon quatro= new ImageIcon("4.png");
       Icon oito = new ImageIcon("8.png");
       Icon dezesseis= new ImageIcon("16.png");
       Icon trintaedois= new ImageIcon("32.png");
       Icon sessentaequatro= new ImageIcon("64.png");
       Icon centoevintoeoito = new ImageIcon("128.png");
       Icon duzentosecinquentaeseis= new ImageIcon("256.png");
       Icon quinhetosedoze = new ImageIcon("512.png");
       Icon milevinteequatro = new ImageIcon("1024.png");
       Icon doismilequarentaeoitro= new ImageIcon("2048.png");

    public jogoprincipal() {
      int tamx=165,tamy=115;
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
     
     secreto.setSize(100,100);
     secreto.setLocation(700,450);
     secreto.setText(".");
     secreto.setFont(new Font("Courier New", Font.ITALIC, 1));
     add(secreto);
     
    reiniciar.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
      jogo.inicializar(matriz);
      jogo.score=0;
      jogo.vitoria=0;
      jogo.derrota=0;
      atualizar();
      
      }
    });
    
    
    secreto.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                matriz[i][j]=0;
            }
        }
        matriz[2][2]=1024;
        matriz[3][2]=1024;
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
           texto[i][j].setIcon(zero);
             add(texto[i][j]);
             
           
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
         int tamx=165,tamy=115;
        int score=jogo.score;
        for(int i=0;i<4;i++)
                   {
                       for(int j=0;j<4;j++)
                       {
                           atualizar_cores(matriz[i][j],i,j,tamx,tamy);
                            tamx+=100;
                       }
                       tamx-=400;
                       tamy+=100;
                   }
         jogo.vitoria(matriz);
        jogo.derrota(matriz);
        jogo.score=score;
        numero_pontuacao.setText(Integer.toString(jogo.score));
        if(jogo.derrota==1)
        {
            System.out.print("cccccc");
        }
        
        if(jogo.vitoria==1)
        {
      vitoria vitoria= new vitoria();
      jogo.inicializar(matriz);
      jogo.score=0;
      jogo.vitoria=0;
      jogo.derrota=0;
      atualizar();
      
        }
        
    }
    
    void atualizar_cores(int valor,int i, int j,int tamx,int tamy)
    {
        switch(valor)
        {
            case 0:
                  texto[i][j].setIcon(zero);
                break;
            case 2:
                texto[i][j].setIcon(dois);
                break;
            case 4:
                texto[i][j].setIcon(quatro);
                break;
            case 8:
                   texto[i][j].setIcon(oito);
                break;
            case 16:
                 texto[i][j].setIcon(dezesseis);
                break;
             case 32:
                  texto[i][j].setIcon(trintaedois);
                break;
             case 64:
                  texto[i][j].setIcon(sessentaequatro);
                break;
             case 128:
                   texto[i][j].setIcon(centoevintoeoito);
                break;
              case 256:
                  texto[i][j].setIcon(duzentosecinquentaeseis);
                break;
               case 512:
                     texto[i][j].setIcon(quinhetosedoze);
                break;
                case 1024:
                  texto[i][j].setIcon(milevinteequatro);
                 
                break;
                 case 2048:
                     texto[i][j].setIcon(doismilequarentaeoitro);
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
