package dominio;

public class CaixaEletronico {
    private double saldo;

    public CaixaEletronico(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public boolean sacar(double valor) {
        if (valor % 10 != 0) {
            System.out.println("Erro: O valor do saque deve ser múltiplo de R$ 10.");
            return false;
        }
        if (valor > saldo) {
            System.out.println("Erro: Saldo insuficiente.");
            return false;
        }
        saldo -= valor;
        System.out.println("Saque realizado com sucesso: R$ " + valor);
        return true;
    }

    public void exibirSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }
}

// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

package controle;

import dominio.CaixaEletronico;
import java.util.Scanner;

public class SimuladorCaixa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o saldo inicial do caixa eletrônico: ");
        double saldoInicial = scanner.nextDouble();
        
        CaixaEletronico caixa = new CaixaEletronico(saldoInicial);
        
        while (true) {
            System.out.println("\n1 - Sacar\n2 - Consultar saldo\n3 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            
            if (opcao == 1) {
                System.out.print("Informe o valor do saque: ");
                double valor = scanner.nextDouble();
                caixa.sacar(valor);
            } else if (opcao == 2) {
                caixa.exibirSaldo();
            } else if (opcao == 3) {
                System.out.println("Encerrando o caixa eletrônico...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
        
        scanner.close();
    }
}
