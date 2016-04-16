package maquinanorma;

import java.util.ArrayList;
import java.io.*;

public class LeitoraArquivos {
    public ArrayList<String> lerArquivo(String nomeArquivo) throws FileNotFoundException, IOException {
        ArrayList<String> instrucoes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
        String instrucao;
        
        try {
            while ((instrucao = br.readLine()) != null) {
                instrucoes.add(instrucao);
            }
        }
        finally {
            br.close();
        }
        
        return instrucoes;
    }
}
