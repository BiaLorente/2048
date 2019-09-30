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
        //inicio inicio= new inicio();
       // principal principal = new principal();
        //inicio.setVisible(true);
       jogoprincipal a= new jogoprincipal();
        a.setVisible(true);
        //jogo a = new jogo();
        try
        {
        Thread.sleep(1000);
        }
        catch(Exception e)
                {
                    
                }
        matriz[0][0]=2;
        matriz[1][0]=2;
        matriz[2][0]=4;
        matriz[3][0]=8;
        
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                System.out.print("  "+matriz[i][j]);
            }
            System.out.println();
        }
      System.out.println(); System.out.println();
      //a.mover_baixo(matriz);
            for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                System.out.print("  "+matriz[i][j]);
            }
            System.out.println();
        }
}
}
