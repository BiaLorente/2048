/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_2048;

/**
 *
 * @author Wagner
 */
public class Proj_2048{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int matriz[][]= new int[4][4];
        int i,j;
        long k=5;
        inicio inicio= new inicio();
        principal principal = new principal();
        inicio.setVisible(true);
        try
        {
        Thread.sleep(1000);
        }
        catch(Exception e)
                {
                    
                }
        inicio.dispose();
        principal.setVisible(true);
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                matriz[i][j]=0;
            }
        }
        jogo jogo= new jogo();
        jogo.gerar_random(matriz);
         jogo.gerar_random(matriz);
          jogo.gerar_random(matriz);
           jogo.gerar_random(matriz);
            jogo.gerar_random(matriz);

             matriz[0][0]=0;
                 matriz[0][1]=4;
                   matriz[0][2]=2;
                    matriz[0][3]=2;
                    
                         matriz[1][0]=2;
                 matriz[1][1]=0;
                   matriz[1][2]=2;
                    matriz[1][3]=4;
                    
            for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                System.out.print(matriz[i][j]);
            }
             System.out.println("\n");
        }
             System.out.println("\n");
              System.out.println("\n");
               System.out.println("\n");
               
            jogo.mover_cima(matriz);
            
                    for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                System.out.print(matriz[i][j]);
            }
             System.out.println("\n");
        }
            
        
        
        
    }
    
}
