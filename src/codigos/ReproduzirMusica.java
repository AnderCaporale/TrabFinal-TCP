package codigos;

import java.util.ArrayList;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class ReproduzirMusica extends Thread{ 
    boolean tocando;
    MusicaGerada music;
    String musica="";
    Player player = new Player();
    Pattern pattern1;
    ArrayList<Nota> notas;
    int repAtual = 0;
    
    public ReproduzirMusica(String notas){
        this.musica = notas;

    }
    @Override
    public void run(){
//        for (this.repAtual = this.repAtual; repAtual < notas.size(); this.repAtual++){
//            System.out.println(this.repAtual);
//            Nota notaAtual = notas.get(this.repAtual);
//            String no = Nota.construirNota(notaAtual);
//
//            //Pattern pattern1 = new Pattern(no);
//            //System.out.println(pattern1);
//            player.play(new Pattern(no));
//        }
        
        pattern1 = new Pattern(this.musica);
        System.out.println(pattern1);
        player.play(pattern1);
     }
    
    public boolean pause(){
        player.getManagedPlayer().pause();
        return true;
    }
    
}
