package dominio;

public class Elevador {
    private int andarAtual;
    private int totalAndares;

    public Elevador(int totalAndares) {
        this.andarAtual = 0; // Térreo
        this.totalAndares = totalAndares;
    }

    public void subir() {
        if (andarAtual < totalAndares) {
            andarAtual++;
            System.out.println("Subindo... Agora no andar: " + andarAtual);
        } else {
            System.out.println("Já está no último andar!");
        }
    }

    public void descer() {
        if (andarAtual > 0) {
            andarAtual--;
            System.out.println("Descendo... Agora no andar: " + andarAtual);
        } else {
            System.out.println("Já está no térreo!");
        }
    }

    public void exibirAndar() {
        System.out.println("Andar atual: " + andarAtual);
    }
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

package controle;

import dominio.Elevador;
import java.util.Scanner;

public class SimuladorElevador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o número total de andares do prédio: ");
        int totalAndares = scanner.nextInt();
        Elevador elevador = new Elevador(totalAndares);
        
        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Subir");
            System.out.println("2 - Descer");
            System.out.println("3 - Exibir andar atual");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    elevador.subir();
                    break;
                case 2:
                    elevador.descer();
                    break;
                case 3:
                    elevador.exibirAndar();
                    break;
                case 0:
                    System.out.println("Encerrando simulação...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
        
        scanner.close();
    }
}
