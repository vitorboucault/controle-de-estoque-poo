package br.com.estoque.model;

import br.com.estoque.exception.EstoqueInsuficienteException;

import java.util.Scanner;

public abstract class Peca {
        private String descricao;
        private int quantidadeEstoque;
        private int estoqueMinimo;
        private int estoqueMaximo;

        public Peca(String descricao, int estoqueMaximo, int estoqueMinimo, int quantidade) {
            this.descricao = descricao;
            this.estoqueMaximo = estoqueMaximo;
            this.estoqueMinimo = estoqueMinimo;
            this.quantidadeEstoque = quantidade;
        }

        public abstract void venda(Scanner sc) throws EstoqueInsuficienteException;

        public void reposicaoEstoque() {
            if (this.quantidadeEstoque < this.estoqueMinimo) {
                this.quantidadeEstoque = this.estoqueMaximo;
                System.out.println("Reposição de estoque feita com sucesso!");
            } else {
                System.out.println("Estoque não está abaixo do mínimo!");
            }
        }


        public String getDescricao() {
            return this.descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public int getEstoqueMaximo() {
            return this.estoqueMaximo;
        }

        public void setEstoqueMaximo(int estoqueMaximo) {
            this.estoqueMaximo = estoqueMaximo;
        }

        public int getEstoqueMinimo() {
            return this.estoqueMinimo;
        }

        public void setEstoqueMinimo(int estoqueMinimo) {
            this.estoqueMinimo = estoqueMinimo;
        }

        public int getQuantidadeEstoque() {
            return this.quantidadeEstoque;
        }

        public void setQuantidadeEstoque(int quantidadeEstoque) {
            this.quantidadeEstoque = quantidadeEstoque;
        }

        @Override
        public String toString() {
            return descricao + ":" +
                    " | Quantidade em estoque: "  + quantidadeEstoque +
                    " | Estoque minimo: "  + estoqueMinimo +
                    " | Estoque maximo: " + estoqueMaximo;
        }
    }

