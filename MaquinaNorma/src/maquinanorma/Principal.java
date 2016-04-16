package maquinanorma;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        UsoMaquinaNorma usoMaquinaNorma;
        LeitoraArquivos leitora;
        ArrayList<String> programa;
        Scanner sc;
        int A, B, C, D;
        
        sc = new Scanner(System.in);
        leitora = new LeitoraArquivos();
        
        System.out.println("---------------");
        System.out.println(" Máquina Norma ");
        System.out.println("---------------");
        
        try {
            programa = leitora.lerArquivo("programa.txt");

            System.out.println("Inicialize os registradores:");
            System.out.print("A: "); A = sc.nextInt();
            System.out.print("B: "); B = sc.nextInt();
            System.out.print("C: "); C = sc.nextInt();
            System.out.print("D: "); D = sc.nextInt();

            usoMaquinaNorma = new UsoMaquinaNorma(A, B, C, D);
            usoMaquinaNorma.setPrograma(programa);
            
            System.out.println("--------------------------");
            System.out.println("Execução da Máquina Norma:");
            System.out.println("--------------------------");
            usoMaquinaNorma.executar();
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        }
        catch (IOException ex) {
            System.out.println("Falha ao ler o arquivo!");
        }
    }
}
