package codigos;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class ReproduzirMusica extends Thread{ 
    private String musica="";
    private Player player = new Player();
    private Pattern pattern1;
    
    public ReproduzirMusica(String notas){
        this.musica = notas;

    }
    @Override
    public void run(){
        pattern1 = new Pattern(this.musica);
        System.out.println(pattern1);
        player.play(pattern1);
     }
    
    public boolean pause(){
        player.getManagedPlayer().pause();
        return true;
    }
}
