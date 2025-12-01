package br.com.estoque.model;

import br.com.estoque.exception.EstoqueInsuficienteException;

import java.util.Scanner;

public interface Item {
    void venda(Scanner sc) throws EstoqueInsuficienteException;
    void reposicaoEstoque();
    String getDescricao();
}