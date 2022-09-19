package codigos;

import java.util.ArrayList;
import org.jfugue.midi.MidiDictionary;

public class ConstruirMusica {
    private String textoInput;
    private int volume = 16;
    private float duracao;
    private int oitava = 5;
    private int BPM = 120;
    private byte instrumento = 0;
    private String musica = "";
    private int totalNotas = 0;
    ArrayList<Nota> notasMusica = new ArrayList<Nota>();
    String notasMusicaString = "";

    public ConstruirMusica(String texto, byte instrumento, int BPM){
        this.textoInput = texto;
        this.instrumento = instrumento;
        this.BPM = BPM;
    }
    
    public void gerarMusica(){
        String instrumento2 = MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get(this.instrumento);
        this.musica += "I[" + instrumento2 + "] ";
        this.musica += "T" + this.BPM + " ";
        this.musica += ":CON(7," + this.volume + ") ";

        for (int i=0; i<textoInput.length(); i++){
            switch (textoInput.charAt(i)){
                case 'A', 'B', 'C', 'D', 'E', 'F', 'G': adicionarNota(textoInput.charAt(i)); break;
                case 'a', 'b', 'c', 'd', 'e', 'f', 'g': tratarMinusculas(textoInput.charAt(i), textoInput, i); break;

                case 'Q', 'W', 'R', 'T', 'Y', 'P', 'S', 'H', 'J', 'K', 'L', 'Z', 'X', 'V', 'N', 'M' : repeteLetra(textoInput, i); break;
                
                case 'q', 'w', 'r', 't', 'y', 'p', 's', 'h', 'j', 'k', 'l', 'z', 'x', 'v', 'n', 'm' : repeteLetra(textoInput, i); break;

                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9': trocarInstrumento(textoInput.charAt(i)); break;

                case ' ': aumentarVolume(); break;
                case '?': aumentarOitava(); break;

                case 'O', 'o', 'U', 'u', 'I', 'i': trocarInstrumento("Harpsichord"); break;
                case '!': trocarInstrumento("Agogo"); break;
                case '\n': trocarInstrumento("Tubular_Bells"); break;
                case ';': trocarInstrumento("Pan_Flute"); break;
                case ',': trocarInstrumento("Church_Organ"); break;
                
                default: repeteLetra(textoInput, i); break;
            }
        }
    }
    
    public void setTexto(String texto){
        this.textoInput = texto;
    }
    
    public String getTexto(){
        return this.textoInput;
    }
    
    
    public String getMusica(){
        return this.musica;
    }
    
    
    public void adicionarNota(char nota){
        this.totalNotas++;
        Nota novaNota = new Nota();
        novaNota.setBPM(this.BPM);
        novaNota.setNota(nota);
        novaNota.setOitava(this.oitava);
        novaNota.setVolume(this.volume);
        novaNota.setInstrumento(this.instrumento);
        
        this.notasMusica.add(novaNota);
        
        if (this.oitava == 10 && (nota=='A' || nota=='B')) {    //Não existe A10 nem B10
            this.musica += nota + (oitava-1+" ");
        } else{
            this.musica += nota + (oitava+" ");
        }
         
    }
    
    public byte getInstrumento(){
        return this.instrumento;
    }
    
    public void trocarInstrumento(String instrumento){
        this.instrumento = MidiDictionary.INSTRUMENT_STRING_TO_BYTE.get(instrumento.toUpperCase());
        this.musica += "I[" + instrumento + "] ";
        
    }
    
    public void trocarInstrumento(char valor){
        int numero = Integer.valueOf(valor+"");
        int novaNota = this.instrumento + numero;    

        byte novaNotaByte = (novaNota>= 0 && novaNota <= 127) ? (byte)(novaNota) : (byte)((numero + this.instrumento) - 128);
        String instrumento1 = MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get(novaNotaByte);
        this.musica += "I[" + instrumento1 + "] ";
        this.instrumento = novaNotaByte;
    }
    
    public void trocarBPM(int bpm){
        this.BPM = bpm;
        this.musica += "T" + bpm + " ";
    }
    
    
    public void aumentarVolume(){
        this.volume *= 2;

        if(this.volume > 127){
            this.volume = 127;
        }
        
        this.musica += ":CON(7," + volume + ") ";
    }
    
    private void tratarMinusculas(char letra, String texto, int i){
        
        int minusculaParaMaiuscula = 32;
        char letraMaiuscula = (char)((int)letra - minusculaParaMaiuscula);
        
        if (i==0) {
            adicionarNota('R');
        } else if (letraMaiuscula == texto.charAt(i-1)){
            adicionarNota(letraMaiuscula);
        } else {
            adicionarNota('R');

        }    
    }
    
    private void repeteLetra(String texto, int i){
        
        char min = (int) 'A';
        char max = (int) 'G';
        
        int caractereAnterior = (int)texto.charAt(i-1);
        
        if (i==0) {
            adicionarNota('R');
        } else if (min<=caractereAnterior && max>=caractereAnterior){
            adicionarNota((char)caractereAnterior);
        } else {
            adicionarNota('R');

        } 
    }
    
    private void aumentarOitava(){
        
        if (this.oitava < 10){
            this.oitava+=1;
        } else{
            this.oitava = 5;
        }
    }
    
    public int getTotalNotas(){
        return this.totalNotas;
    }
    
    public ArrayList<Nota> getNotasMusica(){
        return this.notasMusica;
    }
    
    public String gerarNotasString(){
        String resultado = "";
        
        for (int i=0; i<notasMusica.size(); i++ ){
            resultado += Nota.construirNota(notasMusica.get(i));
        }
        
        return resultado;
    }
    
    public void setInstrumento(byte numero){
        this.instrumento = numero;
    }
    
    public int getBPM(){
        return this.BPM;
    }
    
}
