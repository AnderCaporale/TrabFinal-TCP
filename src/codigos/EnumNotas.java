package codigos;

public enum EnumNotas {
    A ("Lá"),
    B ("Si"),
    C ("Dó"),
    D ("Ré"),
    E ("Mi"),
    F ("Fá"),
    G ("Sol");

    
    private String sabor;
    
    EnumNotas(String sabor){
        this.sabor = sabor;
    }
    
    public String getNota(){
        return this.sabor;
    }
}
