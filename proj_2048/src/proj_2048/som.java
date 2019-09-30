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
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author Wagner
 */
public class som {

    Clip clip;

    public void executaSom(String caminho) {
        try {
            File audioPath = new File(caminho);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioPath);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            System.out.println("Erro ao executar SOM!");
            ex.printStackTrace();
        }
    }

    public void parar() throws LineUnavailableException {
        // Clip clip = AudioSystem.getClip();
        try {
            this.clip.stop();
        } catch (Exception e) {

        }
    }

}
