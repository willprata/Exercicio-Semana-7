package dominio;

public class Funcionario {
    private String nome;
    private double salarioBase;
    private String categoria;

    public Funcionario(String nome, double salarioBase, String categoria) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.categoria = categoria;
    }

    public double calcularSalarioFinal() {
        double salarioFinal = salarioBase;
        switch (categoria.toUpperCase()) {
            case "A":
                salarioFinal *= 1.2;
                break;
            case "B":
                salarioFinal *= 1.1;
                break;
            case "C":
                break;
            default:
                System.out.println("Categoria inválida. Nenhum bônus aplicado.");
        }
        return salarioFinal;
    }

    public void exibirSalarioFinal() {
        System.out.println("Salário final de " + nome + ": R$ " + calcularSalarioFinal());
    }
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------
  
package controle;

import dominio.Funcionario;
import java.util.Scanner;

public class GerenciadorFuncionario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Informe o nome do funcionário: ");
        String nome = scanner.nextLine();
        
        System.out.print("Informe o salário base: ");
        double salarioBase = scanner.nextDouble();
        
        System.out.print("Informe a categoria (A, B ou C): ");
        String categoria = scanner.next();
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, categoria);
        funcionario.exibirSalarioFinal();
        
        scanner.close();
    }
}
