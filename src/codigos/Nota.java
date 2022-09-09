package codigos;

import org.jfugue.midi.MidiDictionary;
import org.jfugue.pattern.Pattern;

public class Nota {
    private byte instrumento;
    private int oitava;
    private char nota;
    private int volume;
    private int BPM;

    public byte getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(byte instrumento) {
        this.instrumento = instrumento;
    }

    public int getOitava() {
        return oitava;
    }

    public void setOitava(int oitava) {
        this.oitava = oitava;
    }

    public char getNota() {
        return nota;
    }

    public void setNota(char nota) {
        this.nota = nota;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getBPM() {
        return BPM;
    }

    public void setBPM(int BPM) {
        this.BPM = BPM;
    }
    
    public static String construirNota(Nota nota){
        
        String volume = ":CON(7," + nota.getVolume() + ") ";
        String bpm = "T" + nota.getBPM() + " ";
        String instrumento = "I[" + MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get(nota.getInstrumento()) + "] ";
        
        //Não existe A10 nem B10
        boolean notOitava10 = (nota.getOitava() == 10) && (nota.getNota()=='A' || nota.getNota()=='B');
        String comOitava10 = nota.getNota() + String.valueOf(nota.getOitava()) + " ";
        String semOitava10 = nota.getNota() + String.valueOf(nota.getOitava()-1) + " ";
        String notaOitava = notOitava10 ? semOitava10 : comOitava10;
        
        String notaAtual = volume + bpm + instrumento + notaOitava;
        
        return notaAtual;
    }
}
