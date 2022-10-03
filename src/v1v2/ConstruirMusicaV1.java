package v1v2;

import java.util.ArrayList;
import java.util.Random;
import org.jfugue.midi.MidiDictionary;
import codigos.*;

public class ConstruirMusicaV1 {
    private String textoInput;
    private int volume = 16;
    private int volumeDefault = 16;
    private float duracao;
    private int oitava = 5;
    private int BPM = 120;
    private byte instrumento = 0;
    private String musica = "";
    private int totalNotas = 0;
    ArrayList<Nota> notasMusica = new ArrayList<Nota>();
    String notasMusicaString = "";

    public ConstruirMusicaV1(String texto, byte instrumento, int BPM){
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
                case 'a', 'b', 'c', 'd', 'e', 'f', 'g': adicionarNota(textoInput.charAt(i)); break;

                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9': trocarInstrumento(textoInput.charAt(i)); break;

                case '+': tratarMais(textoInput, i); break;
                case '-': tratarMenos(textoInput, i); break;
                case '?': notaAleatoria(); break;

                case 'O', 'o', 'U', 'u', 'I', 'i': repeteLetra(textoInput, i); break;
                case '\n': instrumentoAleatorio(); break;
                case ';': bpmAleatorio(); break;
                case ' ': adicionarNota(' '); break;
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
    
    private void repeteLetra(String texto, int i){
        
        char min = (int) 'A';
        char max = (int) 'G';
        
        int caractereAnterior = (int)texto.charAt(i-1);
        
        if (min<=caractereAnterior && max>=caractereAnterior){
            adicionarNota((char)caractereAnterior);
        } 
        else {
            byte instrumentoAnterior = this.instrumento;
            trocarInstrumento("Telephone_Ring");
            adicionarNota('A');
            String instrumento1 = MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get(instrumentoAnterior);
            this.musica += "I[" + instrumento1 + "] ";
            this.instrumento = instrumentoAnterior;
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

    private void diminuirVolume() {
        this.volume = this.volumeDefault;
        
        this.musica += ":CON(7," + volume + ") ";
    }

    private void notaAleatoria() {
        Random rand = new Random();
        int AateG=7;
        int A=65;
        
        int numeroAleatorio =  A + rand.nextInt(AateG);
         adicionarNota((char) numeroAleatorio);
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

    private void bpmAleatorio() {
        
        Random rand = new Random();
        int maxBPM=240;
        int numeroAleatorio = rand.nextInt(maxBPM+1);
        
        trocarBPM(numeroAleatorio);
    }

    private void instrumentoAleatorio() {
        
        Random rand = new Random();
        int ultimoInstrumento = 128;
        int numero = rand.nextInt(ultimoInstrumento);
        int novaNota = this.instrumento + numero;
        
        byte novaNotaByte = (novaNota>= 0 && novaNota <= 127) ? (byte)(novaNota) : (byte)((numero + this.instrumento) - 128);
        String instrumento1 = MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get(novaNotaByte);
        this.musica += "I[" + instrumento1 + "] ";
        this.instrumento = novaNotaByte;
    }
                              
    
}
