package dominio;

public class Aluno {
    private String nome;
    private double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public boolean validarNota() {
        return nota >= 0 && nota <= 10;
    }

    public String classificarAluno() {
        if (nota >= 7) {
            return "Aprovado";
        } else if (nota >= 5) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }

    public void exibirResultado() {
        System.out.println("Aluno: " + nome);
        System.out.println("Nota: " + nota);
        System.out.println("Classificação: " + classificarAluno());
    }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

package controle;

import dominio.Aluno;
import java.util.Scanner;

public class GerenciadorAluno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Informe o nome do aluno: ");
        String nome = scanner.nextLine();
        double nota;
        
        while (true) {
            System.out.print("Informe a nota do aluno (0 a 10): ");
            nota = scanner.nextDouble();
            
            if (nota >= 0 && nota <= 10) {
                break;
            } else {
                System.out.println("Nota inválida! Digite um valor entre 0 e 10.");
            }
        }
        
        Aluno aluno = new Aluno(nome, nota);
        aluno.exibirResultado();
        
        scanner.close();
    }
}
