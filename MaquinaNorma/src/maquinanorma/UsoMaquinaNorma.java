package maquinanorma;

import java.util.ArrayList;

public class UsoMaquinaNorma {
    private MaquinaNorma maquina;
    private ArrayList<String> programa;
    
    public UsoMaquinaNorma(int A, int B, int C, int D) {
        this.maquina = new MaquinaNorma(A, B, C, D);
    }
    
    public void setPrograma(ArrayList<String> programa) {
        this.programa = programa;
    }
    
    public void executar() {
        int instrucao = 0;
        
        System.out.println("Estado inicial: " + getEstadoAtualMaquina());
	while (existeInstrucao(instrucao)) {
            System.out.println(getEstadoAtualMaquina() + " " + getTextoInstrucao(instrucao));
            instrucao = executarInstrucao(instrucao);
	} 
        System.out.println("Estado final: " + getEstadoAtualMaquina());
    }
    
    private boolean existeInstrucao(int instrucao) {
        return (instrucao >= 0 && instrucao < programa.size());
    }
 
    private String getEstadoAtualMaquina() {
        return "(" +
                maquina.get('A') + ", " +
                maquina.get('B') + ", " +
                maquina.get('C') + ", " +
                maquina.get('D') +
            ")";
    }
    
    private int executarInstrucao(int instrucao) {
        String s = programa.get(instrucao);
        String[] partes = s.split(" ");
        
        String rotulo = partes[0];
        String comando = partes[1];
        String registrador = partes[2];
        String proxInstrucao;
        
        if (!rotulo.matches("\\d{1,2}:")) {
            throw new IllegalArgumentException("Instrução inválida!");
        }
        
        switch (comando) {
            case "ADD":
                maquina.add(registrador.charAt(0));
                proxInstrucao = partes[3];
                break;
            case "SUB":
                maquina.sub(registrador.charAt(0));
                proxInstrucao = partes[3];
                break;
            case "ZER":
                if (maquina.zer(registrador.charAt(0)))
                    proxInstrucao = partes[3];
                else
                    proxInstrucao = partes[4];
                break;
            default:
                throw new IllegalArgumentException("Instrução inválida!");
        }
        
        return Integer.parseInt(proxInstrucao) - 1;
    }

    private String getTextoInstrucao(int instrucao) {
        String s = programa.get(instrucao);
        String[] partes = s.split(" ");
          
        if (!partes[0].matches("\\d{1,2}:")) {
            throw new IllegalArgumentException("Instrução inválida!");
        }
        
        switch (partes[1]) {
            case "ADD":
                s = "FACA " + partes[1] + "(" + partes[2] + ") VA_PARA " + partes[3];
                break;
            case "SUB":
                s = "FACA " + partes[1] + "(" + partes[2] + ") VA_PARA " + partes[3];
                break;
            case "ZER":
                s = "SE " + partes[1] + "(" + partes[2] + ") ENTAO VA_PARA " + partes[3] + " SENAO VA_PARA " + partes[4];
                break;
            default:
                throw new IllegalArgumentException("Instrução inválida!");
        }
        
        return s;
    }
}
