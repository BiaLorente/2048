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
//Classe que inicia o jogo chamando a função splash e depois o menu

public class Proj_2048{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int matriz[][]= new int[4][4];
        int i,j;
        long k=5;

       splash inicio = new splash();   //instancia a splash


        try                             //Espera de 1 seg com a splash na tela
        {
        Thread.sleep(1000);
        }
        catch(Exception e)
                {
                    
                }
        inicio.dispose();              //splash encerra
         menu start = new menu();       // instancia o menu
        

}
}
