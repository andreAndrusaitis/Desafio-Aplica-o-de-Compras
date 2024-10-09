import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Digitar o Saldo do cartão
        System.out.println("Digite o Saldo do cartão:");
        double saldo = scanner.nextDouble();

        // Criar uma lista para armazenar os produtos comprados
        List<InfoProduto> listaDeProdutos = new ArrayList<>();

        // Loop para continuar comprando ou sair
        int continuarComprando = 1;  // Inicializa com 1 para entrar no loop
        while (continuarComprando != 0) {
            scanner.nextLine(); // Limpar o buffer do scanner

            // Digitar o Nome do produto desejado
            System.out.println("Digite o nome do produto desejado:");
            String produto = scanner.nextLine();

            // Digitar o Valor do Produto
            System.out.println("Qual o valor do produto?");
            double precoProduto = scanner.nextDouble();

            // Verificar se a compra é possível
            if (precoProduto > saldo) {
                System.out.println("********************");
                System.out.println("Impossível realizar a compra. O produto custa: " + precoProduto);
                System.out.println("Saldo disponível: " + saldo);
                System.out.println("********************");

                // Ordenar os produtos do mais caro para o mais barato
                Collections.sort(listaDeProdutos);

                // Exibir todos os produtos comprados
                for (InfoProduto produtosComprados : listaDeProdutos) {
                    System.out.println(produtosComprados);
                }
                System.out.println("********************");


            } else {
                saldo -= precoProduto;  // Subtrai o valor do produto do saldo
                System.out.println("Compra de " + produto + " realizada com sucesso!");
                System.out.println("Saldo restante: " + saldo);

                // Criar um novo InfoProduto e adicionar à lista de produtos
                InfoProduto infoProduto = new InfoProduto(produto, precoProduto);
                listaDeProdutos.add(infoProduto);
            }

            // Perguntar se o usuário quer continuar comprando
            System.out.println("Digite 0 para sair ou 1 para continuar comprando:");
            continuarComprando = scanner.nextInt();
        }

        // Ordenar os produtos do mais caro para o mais barato
        Collections.sort(listaDeProdutos);

        System.out.println("********************");

        // Exibir todos os produtos comprados
        for (InfoProduto produtosComprados : listaDeProdutos) {
            System.out.println(produtosComprados);
        }
        System.out.println("********************");

        System.out.println("Obrigado por usar nosso sistema de compras!");
        scanner.close();  // Fecha o Scanner ao final do programa
    }
}
