/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_2048;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 *
 * @author Wagner
 */
public class som {
     public void executaSom(String caminho) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(caminho).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Erro ao executar SOM!");
            ex.printStackTrace();
        }
    }
     
       public void executaSom(String caminho, int i) {
        try {
            int a=99999999;
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(caminho).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(a);
        } catch (Exception ex) {
            System.out.println("Erro ao executar SOM!");
            ex.printStackTrace();
        }
    }
     
     
     
     
     public void parar()
     {
      //    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(caminho).getAbsoluteFile());
          //  Clip clip = AudioSystem.getClip();
           // clip.open(audioInputStream);
            //clip.stop();
     }
    
}
