package codigos;

import java.io.File;
import java.io.IOException;
import org.jfugue.pattern.Pattern;

public class DownloadMusica {
    String musica = "";
    Pattern pattern1;
    File localDownload;
    
    public DownloadMusica(String notas) {
        this.musica = notas;
    }
    
    public void criaArquivo(String caminhoArquivo) {
        try{
           localDownload = new File(caminhoArquivo);
           pattern1 = new Pattern(this.musica);
           org.jfugue.midi.MidiFileManager.savePatternToMidi(pattern1, localDownload);
           localDownload.delete();
       } catch(IOException erro) {
           System.out.println("Erro");
       }
    }
    
}
