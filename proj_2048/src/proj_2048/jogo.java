/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_2048;
import java.util.Random;
/**
 *
 * @author Wagner
 */
public class jogo {
    public int vitoria=0;
    public int derrota=0;
    public int score=0;
  
    
    public void inicializar(int v[][])
    {
       int i=0,j=0;
       for(i=0;i<4;i++)
       {
           for(j=0;j<4;j++)
           {
               v[i][j]=0;
           }
       }
       gerar_random(v);
       gerar_random(v);
       
    }
    
    public void gerar_random(int v[][])
    {
        int i=0,j=0,k=0,randomposi,randomnum;
        posicao_M[] localizacao = new posicao_M[16];
        for(i=0;i<16;i++)
        {
        localizacao[i]= new posicao_M();
        
        }
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                if(v[i][j]==0)
                {
                    localizacao[k].alterar(i, j);
                    k++;
                }
            }
        }
         if(k>1)
         {
         Random gerador = new Random();
         randomposi=gerador.nextInt(k-1);
         randomnum=gerador.nextInt(10);
         if(randomnum<=3)
         {
             v[localizacao[randomposi].i][localizacao[randomposi].j]=4;
             
         }
         else
         {
             v[localizacao[randomposi].i][localizacao[randomposi].j]=2;
         }
         }
         
         if(k==1)
         {
              Random gerador = new Random();
              randomnum=gerador.nextInt(10);
               if(randomnum<=3)
         {
             v[localizacao[0].i][localizacao[0].j]=4;
             
         }
         else
         {
             v[localizacao[0].i][localizacao[0].j]=2;
         }
         }
         
        
    }
    
    public void mover_esq(int v[][])
    {
        int i,j,k,ver=-1;
        
        for(i=0;i<4;i++)
        {
            for(j=2;j>=0;j--)
            {
                if(v[i][j]!=0)
                {
                    for(k=j;k<3;k++)
                    {
                        if(v[i][k+1]==0)
                        {
                            v[i][k+1]=v[i][k];
                            v[i][k]=0;
                        }
                        else
                        {
                            if(v[i][k]==v[i][k+1])
                            {
                                if(ver!=k && ver+1!=k)
                                {
                                score+=v[i][k+1];
                                ver=k;
                                v[i][k+1]*=2;
                                v[i][k]=0;
                                }
                            }
                        }
                    }
                }
            }
             ver=-1;
        }
    }
    
        public void mover_baixo(int v[][])
    {
        int i,j,k,ver=-1;
          for(j=0;j<4;j++)
            {
        for(i=2;i>=0;i--)
        {
                if(v[i][j]!=0)
                {
                     for(k=i;k<3;k++)
                    {
                        if(v[k+1][j]==0)
                        {
                            v[k+1][j]=v[k][j];
                            v[k][j]=0;
                        }
                        else
                        {
                            if(v[k][j]==v[k+1][j])
                            {
                                if(ver!=k && ver+1!=k)
                                {
                                     score+=v[k+1][j];
                                ver=k;
                                v[k+1][j]*=2;
                                v[k][j]=0;
                                }
                            }
                        }
                    }
                }
            }
         ver=-1;
        }
    }
    
    
    
    
    
    
    
    public void mover_dir(int v[][])
    {
         int i,j,k,ver=-1;
        
        for(i=0;i<4;i++)
        {
            for(j=1;j<4;j++)
            {
                if(v[i][j]!=0)
                {
                    for(k=j;k>0;k--)
                    {
                        if(v[i][k-1]==0)
                        {
                            v[i][k-1]=v[i][k];
                            v[i][k]=0;
                        }
                        else
                        {
                            if(v[i][k]==v[i][k-1])
                            {
                                if(ver!=k && ver-1!=k)
                                {
                                 score+=v[i][k-1];
                                ver=k;
                                v[i][k-1]*=2;
                                v[i][k]=0;
                               }
                            }
                        }
                    }
                }
            }
            ver=-1;
        }     
        
    }
    
    
    public void mover_cima(int v[][])
    {
         int i,j,k,ver=-1;
        
        for(j=0;j<4;j++)
        {
            for(i=1;i<4;i++)
            {
                if(v[i][j]!=0)
                {
                    for(k=i;k>0;k--)
                    {
                        if(v[k-1][j]==0)
                        {
                            v[k-1][j]=v[k][j];
                            v[k][j]=0;
                        }
                        else
                        {
                            if(v[k][j]==v[k-1][j])
                            {
                                if(ver!=k && ver-1!=k)
                                {
                                score+=v[k-1][j];
                                ver=k;
                                v[k-1][j]*=2;
                                v[k][j]=0;
                               }
                            }
                        }
                    }
                }
            }
            ver=-1;
        }     
        
    }
    
    
    
    
    
    public void vitoria(int v[][])
    {
        int i,j;
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                if(v[i][j]==2048)
                {
                    this.vitoria=1;
                }
            }
        }
    }
    
    public void derrota(int v[][])
    {
        if(movimento_possivel(v,1)==1 && movimento_possivel(v,2)==1 && movimento_possivel(v,3)==1 && movimento_possivel(v,4)==1)
        {
            this.derrota=1;
        }
        
    }
    
    public int movimento_possivel(int v[][],int tipo)
    {
        int matriz[][]= new int[4][4];
        int i=0,j=0,igual=1;
        
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                matriz[i][j]=v[i][j];
            }
        }
        switch(tipo)
        {
            case 1:
                mover_cima(matriz);
                break;
            case 2:
                mover_baixo(matriz);
                break;
            case 3:
                mover_esq(matriz);
                break;
            case 4:
                mover_dir(matriz);
                break;
        }
        
        
        
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                if(v[i][j]!=matriz[i][j])
                {
                    igual=0;
                }
            }
        }
        return igual;
    }
    
}
