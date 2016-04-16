package maquinanorma;

public class MaquinaNorma {
    
    private int[] registradores = new int[4];
    
    public void add(char registrador){
        this.registradores[this.posicao(registrador)] += 1;
    }
    
    public void sub(char registrador){
        if(this.registradores[this.posicao(registrador)] != 0)
            this.registradores[this.posicao(registrador)] -= 1;             
    }
    
    public boolean zer(char registrador){
        return this.registradores[this.posicao(registrador)] == 0;
    }
    
    private int posicao(char registrador){
        if(registrador == 'A')
            return 0;
        if(registrador == 'B')
            return 1;
        if(registrador == 'C')
            return 2;
        if(registrador == 'D')
            return 3;
        
        throw new IllegalArgumentException("Registrador inválido!");
    }
}
