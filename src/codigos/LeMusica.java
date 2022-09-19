/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Alber
 */
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
