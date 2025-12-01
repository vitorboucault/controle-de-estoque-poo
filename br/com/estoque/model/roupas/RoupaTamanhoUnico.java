package br.com.estoque.model.roupas;

import br.com.estoque.exception.EstoqueInsuficienteException;
import br.com.estoque.model.Item;
import br.com.estoque.model.Peca;

import java.util.Scanner;

public class RoupaTamanhoUnico extends Peca implements Item {

    public RoupaTamanhoUnico(String descricao, int estoqueMaximo, int estoqueMinimo, int quantidade) {
        super(descricao, estoqueMaximo, estoqueMinimo, quantidade);
    }

    @Override
    public void venda(Scanner sc) throws EstoqueInsuficienteException {
        if (getQuantidadeEstoque() > 0) {
            int controle = getQuantidadeEstoque() - 1;
            setQuantidadeEstoque(controle);
            System.out.println("Venda de 1 unidade de " + getDescricao() + " realizada.");
        } else {
            throw new EstoqueInsuficienteException("Estoque insuficiente para " + getDescricao());
        }
    }
}
