package br.com.estoque.model;

import br.com.estoque.exception.EstoqueInsuficienteException;
import java.util.Scanner;

public class Acessorio extends Peca implements Item{

    public Acessorio(String descricao, int estoqueMaximo, int estoqueMinimo, int quantidade) {
        super(descricao, estoqueMaximo, estoqueMinimo, quantidade);
    }

    @Override
    public void venda(Scanner sc) throws EstoqueInsuficienteException {
        System.out.print("Quantas unidades de " + getDescricao() + " foram vendidas? ");
        try {
            int quantidadeVendida = sc.nextInt();
            if (quantidadeVendida <= 0) {
                throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
            }
            if (quantidadeVendida > getQuantidadeEstoque()) {
                throw new EstoqueInsuficienteException("Estoque insuficiente! Disponível: " + getQuantidadeEstoque());
            }
            int controle = getQuantidadeEstoque() - quantidadeVendida;
            setQuantidadeEstoque(controle);
            System.out.println("Venda de " + quantidadeVendida + " unidades realizada.");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Erro: Digite um número inteiro válido.");
            sc.nextLine();
        }
    }



}
