package tratamentoErro;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ExemploFinally {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        try {
            System.out.print("Digite o numerador: ");
            int num1 = leitor.nextInt();

            System.out.print("Digite o denominador: ");
            int num2 = leitor.nextInt();

            int resultado = num1 / num2;
            System.out.println("Resultado: " + resultado);

        } catch (ArithmeticException e) {
            // Captura erro de divisão por zero
            System.out.println("Erro: Não é possível dividir por zero!");
        } catch (InputMismatchException e) {
            // Captura erro se o usuário digitar uma letra em vez de número
            System.out.println("Erro: Você deve digitar apenas números inteiros.");
        } finally {
            // Este bloco SEMPRE executa
            System.out.println("\nFinalizando recursos...");
            leitor.close();
            System.out.println("O Scanner foi fechado com segurança.");
        }
        
        System.out.println("O programa continua rodando após o bloco try-catch-finally.");
    }
}
