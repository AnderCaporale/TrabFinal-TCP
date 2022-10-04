package codigos;

import interfaceGrafica.NovaJanelaPopUp;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LerMusica {
    private Path arquivoMusica;
    private String textoMusica;
    
    public void abrirArquivo(String caminhoArquivo) {
        try {
            arquivoMusica = Paths.get(caminhoArquivo);
        } catch(Exception erro) {
            new NovaJanelaPopUp("Erro ao abrir arquivo").setVisible(true);
        }
    }
    
    public void lerArquivo() {
       try {
           byte[] bytesArquivo = Files.readAllBytes(this.arquivoMusica);
           textoMusica = new String(bytesArquivo);
        } catch(Exception erro) {
           new NovaJanelaPopUp("Erro ao ler arquivo").setVisible(true);; 
       }
    }
    
    public String getTextoMusica() {
        return this.textoMusica;
    }
}
