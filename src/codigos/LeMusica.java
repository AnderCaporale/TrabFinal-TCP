package codigos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LeMusica {
    private Path arquivoMusica;
    private String textoMusica;
    
    public void abreArquivo(String caminhoArquivo) {
        try {
            arquivoMusica = Paths.get(caminhoArquivo);
        } catch(Exception erro) {
            System.out.println(erro);
        }
    }
    
    public void leArquivo() {
       try {
           byte[] bytesArquivo = Files.readAllBytes(this.arquivoMusica);
           textoMusica = new String(bytesArquivo);
        } catch(Exception erro) {
           System.out.println(erro); 
       }
    }
    
    public String getTextoMusica() {
        return this.textoMusica;
    }
}
