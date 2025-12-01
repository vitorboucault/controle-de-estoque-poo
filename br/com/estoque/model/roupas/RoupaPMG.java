package br.com.estoque.model.roupas;

import br.com.estoque.exception.EstoqueInsuficienteException;
import br.com.estoque.model.Item;

import java.util.Scanner;

public class RoupaPMG implements Item {

    private final String descricao;
    private int quantidadeP;
    private int quantidadeM;
    private int quantidadeG;
    private final int estoqueMinimo;
    private final int estoqueMaximo;

    public RoupaPMG(String descricao, int estoqueMaximo, int estoqueMinimo, int quantidadeP, int quantidadeM, int quantidadeG) {
        this.descricao = descricao;
        this.estoqueMaximo = estoqueMaximo;
        this.estoqueMinimo = estoqueMinimo;
        this.quantidadeP = quantidadeP;
        this.quantidadeM = quantidadeM;
        this.quantidadeG = quantidadeG;
    }

    @Override
    public void venda(Scanner sc) throws EstoqueInsuficienteException {
        System.out.println("\n--- Venda de " + this.descricao + " ---");
        System.out.print("Informe o tamanho (P, M ou G): ");
        String tamanho = sc.next().toUpperCase();

        switch (tamanho) {
            case "P":
                if (this.quantidadeP <= 0 ){
                    throw new EstoqueInsuficienteException("Estoque P indisponível para " + getDescricao());
                }
                this.quantidadeP--;
                System.out.println("Venda do " + getDescricao() + " tamanho P realizada com sucesso.");
                break;

            case "M":
                if (this.quantidadeM <= 0 ){
                    throw new EstoqueInsuficienteException("Estoque M indisponível para " + getDescricao());
                }
                this.quantidadeM--;
                System.out.println("Venda do " + getDescricao() + " tamanho M realizada com sucesso.");
                break;

            case "G":
                if (this.quantidadeG <= 0 ){
                    throw new EstoqueInsuficienteException("Estoque G indisponível para " + getDescricao());
                }
                this.quantidadeG--;
                System.out.println("Venda do " + getDescricao() + " tamanho G realizada com sucesso.");
                break;

            default:
                System.out.println("\nTamanho inválido! Escolha P, M ou G.");
                break;
        }
    }

    public void reposicaoEstoque() {
        if (this.quantidadeP < this.estoqueMinimo) {
            this.quantidadeP = this.estoqueMaximo;
            System.out.println("Estoque P de " + this.descricao + " reposto para o máximo.");
        }

        if (this.quantidadeM < this.estoqueMinimo) {
            this.quantidadeM = this.estoqueMaximo;
            System.out.println("Estoque M de " + this.descricao + " reposto para o máximo.");
        }

        if (this.quantidadeG < this.estoqueMinimo) {
            this.quantidadeG = this.estoqueMaximo;
            System.out.println("Estoque G de " + this.descricao + " reposto para o máximo.");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao +
                " | Quantidade P: " + quantidadeP +
                " | Quantidade M: " + quantidadeM +
                " | Quantidade G: " + quantidadeG +
                " | Estoque Minimo: " + estoqueMinimo +
                " | Estoque Maximo: " + estoqueMaximo;
    }
}
