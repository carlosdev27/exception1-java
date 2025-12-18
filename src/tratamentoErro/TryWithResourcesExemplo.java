package tratamentoErro;

import java.util.Scanner;

public class TryWithResourcesExemplo {
    public static void main(String[] args) {
        
        // O recurso é declarado entre parênteses. 
        // Ele será fechado automaticamente ao final do bloco {}.
        try (Scanner leitor = new Scanner(System.in)) {
            
            System.out.print("Digite seu nome: ");
            String nome = leitor.nextLine();
            System.out.println("Olá, " + nome);
            
            // Não precisamos de finally para fechar o leitor!
            
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
        
        System.out.println("O Scanner já foi fechado pelo Java.");
    }
}
