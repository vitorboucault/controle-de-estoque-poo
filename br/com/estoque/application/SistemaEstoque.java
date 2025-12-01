package br.com.estoque.application;

import java.util.Scanner;

import br.com.estoque.exception.EstoqueInsuficienteException;
import br.com.estoque.model.Acessorio;
import br.com.estoque.model.Item;
import br.com.estoque.model.roupas.RoupaPMG;
import br.com.estoque.model.roupas.RoupaTamanhoUnico;

public class SistemaEstoque {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Item[] produtos = new Item[5];

        produtos[0] = new Acessorio("Pulseira de couro", 20, 3, 10);
        produtos[1] = new Acessorio("Colar prateado", 15, 2, 7);
        produtos[2] = new RoupaTamanhoUnico("Camiseta OneSize", 10, 1, 5);
        produtos[3] = new RoupaPMG("Camisa Polo", 10, 2, 4, 6, 3);
        produtos[4] = new RoupaPMG("Moletom", 8, 2, 3, 4, 2);

        int opcao = -1;

        do {
            System.out.println("\n===== MENU DE ESTOQUE =====");
            for (int i = 0; i < produtos.length; i++) {
                System.out.println(i + " - " + produtos[i].getDescricao());
            }
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = sc.nextInt();
            } catch (Exception e) {
                System.out.println("\nEntrada inválida! Digite um número.");
                sc.nextLine();
                continue;
            }

            if (opcao >= 0 && opcao <= 4) {

                Item produto = produtos[opcao];

                System.out.println("\n--- Venda ---");

                try{
                    produto.venda(sc);
                    produto.reposicaoEstoque();
                }catch (EstoqueInsuficienteException e) {
                    System.out.println("⚠ Atenção: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("\nErro inesperado: " + e.getMessage());
                }

            } else if (opcao != 5) {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        System.out.println("\n===== ESTOQUE FINAL =====");
        for (Item p : produtos) {
            System.out.println(p);
        }

        System.out.println("\nSistema encerrado.");
        sc.close();
    }
}