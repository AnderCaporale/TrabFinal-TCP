package codigos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MoverSlider extends Thread {
    
    private javax.swing.JSlider sliderMusica;
    private int velocidade = 120;
    private boolean pausar = false;
    
    public MoverSlider(javax.swing.JSlider sliderMusica, int velocidade){
        this.sliderMusica = sliderMusica;
        this.velocidade = velocidade;
    }
    
    public void run(){
        sliderMusica.setValue(0);
        this.pausar = false;
        while (!this.pausar && sliderMusica.getValue() < sliderMusica.getMaximum()){
            try {
                sleep( (1000*60 / velocidade)); 
            } catch (InterruptedException ex) {
                Logger.getLogger(MoverSlider.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.sliderMusica.setValue(this.sliderMusica.getValue() + 1);
        }
    }
    
    public boolean pause(){
        this.pausar = true;
        sliderMusica.setValue(0);
        return true;
    }
}
