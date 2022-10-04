package codigos;

import org.jfugue.midi.MidiDictionary;

public class ConstruirMusica {
    private String textoInput;
    private int volume = 16;
    private int volumeDefault = 16;
    private int oitava = 5;
    private int BPM = 120;
    private byte instrumento = 0;
    private String musica = "";
    private int totalNotas = 0;

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
                case 'A': 
                case 'B': 
                case 'C': 
                case 'D': 
                case 'E': 
                case 'F': 
                case 'G': adicionarNota(textoInput.charAt(i)); break;
                case 'a': 
                case 'b': 
                case 'c': 
                case 'd': 
                case 'e': 
                case 'f': 
                case 'g': tratarMinusculas(textoInput.charAt(i), textoInput, i); break;

                case 'Q': 
                case 'W': 
                case 'R': 
                case 'T': 
                case 'Y': 
                case 'P': 
                case 'S': 
                case 'H': 
                case 'J': 
                case 'K': 
                case 'L': 
                case 'Z': 
                case 'X': 
                case 'V': 
                case 'N': 
                case 'M': repeteLetra(textoInput, i); break;      
                case 'q': 
                case 'w': 
                case 'r': 
                case 't': 
                case 'y': 
                case 'p': 
                case 's': 
                case 'h': 
                case 'j': 
                case 'k': 
                case 'l': 
                case 'z': 
                case 'x': 
                case 'v': 
                case 'n': 
                case 'm': repeteLetra(textoInput, i); break;

                case '0': 
                case '1': 
                case '2': 
                case '3': 
                case '4': 
                case '5': 
                case '6': 
                case '7': 
                case '8': 
                case '9': trocarInstrumento(textoInput.charAt(i)); break;

                case ' ': aumentarVolume(); break;
                case '+': tratarMais(textoInput, i); break;
                case '-': tratarMenos(textoInput, i); break;
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
    
    public void setInstrumento(byte numero){
        this.instrumento = numero;
    }
    
    public int getBPM(){
        return this.BPM;
    }
    
    public byte getInstrumento(){
        return this.instrumento;
    }
    
    public int getTotalNotas(){
        return this.totalNotas;
    }
    
    private void adicionarNota(char nota){
        this.totalNotas++;
        
        if (this.oitava == 10 && (nota=='A' || nota=='B')) {    //Não existe A10 nem B10
            this.musica += nota + (oitava-1+" ");
        } else{
            this.musica += nota + (oitava+" ");
        }
    }
    
    private void trocarInstrumento(String instrumento){
        this.instrumento = MidiDictionary.INSTRUMENT_STRING_TO_BYTE.get(instrumento.toUpperCase());
        this.musica += "I[" + instrumento + "] ";
    }
    
    private void trocarInstrumento(char valor){
        int numero = Integer.valueOf(valor+"");
        int novaNota = this.instrumento + numero;    

        byte novaNotaByte = (novaNota>= 0 && novaNota <= 127) ? (byte)(novaNota) : (byte)((numero + this.instrumento) - 128);
        String instrumento1 = MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get(novaNotaByte);
        this.musica += "I[" + instrumento1 + "] ";
        this.instrumento = novaNotaByte;
    }
    
    private void trocarBPM(int bpm){
        this.BPM = bpm;
        this.musica += "T" + bpm + " ";
    }
    
    
    private void aumentarVolume(){
        this.volume *= 2;

        if(this.volume == 254){
            this.volume = 16;
        }
        else{if(this.volume > 127 && this.volume < 254){
            this.volume = 127;
        }}
        
        this.musica += ":CON(7," + volume + ") ";
    }

    private void diminuirVolume() {
        this.volume = this.volumeDefault;
        
        this.musica += ":CON(7," + volume + ") ";
    }
    
    private void tratarMais(String texto, int i) {
        
        if(i>0){
            int caractereAnterior = texto.charAt(i-1);
            
            if(caractereAnterior=='R' && i>0){
                aumentarOitava();
            } else
                if(caractereAnterior=='M'&& i>0){
                    if(texto.charAt(i-2)=='P')
                        if(texto.charAt(i-3)=='B'){
                            trocarBPM(this.BPM+80);
                        }
                } else
                    aumentarVolume();
        }
        else {
            aumentarVolume();
            return;
        }
    }

    private void tratarMenos(String texto, int i) {
        
        int caractereAnterior = texto.charAt(i-1);  
        
        if(caractereAnterior=='R'){
            diminuirOitava();
        } else
            diminuirVolume();
    }

    private void diminuirOitava() {
        
        if(this.oitava<1){
            this.oitava=1;
        } else
            this.oitava-=1;
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
}
