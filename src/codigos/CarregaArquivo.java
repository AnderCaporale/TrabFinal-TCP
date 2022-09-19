/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigos;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Alber
 */
public class CarregaArquivo extends javax.swing.JFrame {
    private final JFileChooser openFileChooser;
    
    public CarregaArquivo() {
        openFileChooser = new JFileChooser();
        openFileChooser.setCurrentDirectory(new File("c:\\temp"));
        openFileChooser.setFileFilter(new FileNameExtensionFilter(".txt", "txt"));
    }
    
    public JFileChooser getOpenFileChooser() {
        return this.openFileChooser;
    }
}
