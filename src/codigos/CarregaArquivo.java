package codigos;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CarregaArquivo extends javax.swing.JFrame {
    private final JFileChooser openFileChooser;
    
    public CarregaArquivo() {
        openFileChooser = new JFileChooser();
        openFileChooser.setCurrentDirectory(new File("."));
        openFileChooser.setFileFilter(new FileNameExtensionFilter(".txt", "txt"));
    }
    
    public JFileChooser getOpenFileChooser() {
        return this.openFileChooser;
    }
}
