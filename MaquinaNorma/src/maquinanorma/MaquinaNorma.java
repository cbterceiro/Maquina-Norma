package maquinanorma;

public class MaquinaNorma {
    
    private int[] registradores = new int[4];
    
    public MaquinaNorma(int A, int B, int C, int D) {
        this.registradores[0] = A;
        this.registradores[1] = B;
        this.registradores[2] = C;
        this.registradores[3] = D;
    }
    
    public int get(char registrador) {
        return this.registradores[this.posicao(registrador)];
    }
    
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
