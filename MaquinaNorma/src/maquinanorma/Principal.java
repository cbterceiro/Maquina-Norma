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
        String opcao;
        
        sc = new Scanner(System.in);
        leitora = new LeitoraArquivos();
        
        System.out.println("-----------------");
        System.out.println("| Máquina Norma |");
        System.out.println("-----------------");
        
        while (true) {
            System.out.println("-------------------------------------");
            System.out.println("Selecione o programa a ser executado:");
            System.out.println("-------------------------------------");
            System.out.println("[1] Soma A := A + B, A fica com a soma e B fica zerado");
            System.out.println("[2] Soma A := A + B, C fica com a soma, A e B ficam zerados");
            System.out.println("[3] Soma A := A + B, A fica com a soma, B é restaurado, C zerado");
            System.out.println("[4] Multiplicação A := A * B, A fica com o produto, B é restaurado, C e D zerados");
            System.out.println("[5] Multiplicação A := A * B, D fica com o produto, A e B zerados");
            System.out.println("[6] Fatorial de A");
            System.out.println("[7] Programa arbitrário");
            System.out.println("[S] Sair do programa");
            System.out.print("Digite sua opção: ");
            opcao = sc.next();
            
            if ("S".equals(opcao.toString().toUpperCase()))
                break;
            
            try {            
                programa = null;
                switch(opcao) {
                    case "1":
                        programa = leitora.lerArquivo("soma caso 1.txt");
                        break;
                    case "2":
                        programa = leitora.lerArquivo("soma caso 2.txt");
                        break;
                    case "3":
                        programa = leitora.lerArquivo("soma caso 3.txt");
                        break;
                    case "4":
                        programa = leitora.lerArquivo("multiplicacao caso 1.txt");
                        break;
                    case "5":
                        programa = leitora.lerArquivo("multiplicacao caso 2.txt");
                        break;
                    case "6":
                        programa = leitora.lerArquivo("fatorial.txt");
                        break;
                    case "7":
                        programa = leitora.lerArquivo("programa.txt");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        continue;
                }
                
                System.out.println("----------------------------");
                System.out.println("Inicialize os registradores:");
                System.out.println("----------------------------");
                System.out.print("A: "); A = sc.nextInt();
                System.out.print("B: "); B = sc.nextInt();
                System.out.print("C: "); C = sc.nextInt();
                System.out.print("D: "); D = sc.nextInt();
                
                usoMaquinaNorma = new UsoMaquinaNorma(A, B, C, D);
                usoMaquinaNorma.setPrograma(programa);

                System.out.println("--------");
                System.out.println("Execução");
                System.out.println("--------");
                usoMaquinaNorma.executar();
            }
            catch (FileNotFoundException ex) {
                System.out.println("Arquivo não encontrado!");
            }
            catch (IOException ex) {
                System.out.println("Falha ao ler o arquivo!");
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println();
        }
        
        
    }
}
