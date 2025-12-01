# 📦 Sistema de Controle de Estoque (POO)

Projeto desenvolvido como atividade prática da disciplina de **Programação Orientada a Objetos**. O sistema simula o controle de estoque de uma loja de vestuário, gerenciando vendas e reposição automática de diferentes tipos de produtos.

## 📋 Sobre o Projeto

A aplicação é um sistema via console (CLI) que gerencia um inventário de 5 itens pré-cadastrados. O foco principal é a demonstração de conceitos de POO, incluindo:

* **Herança e Polimorfismo:** Tratamento genérico de diferentes tipos de produtos (`Acessorio`, `RoupaTamanhoUnico`, `RoupaPMG`).
* **Abstração:** Uso de Classes Abstratas (`Peca`) e Interfaces (`Item`).
* **Tratamento de Exceções:** Criação de exceções personalizadas para regras de negócio (`EstoqueInsuficienteException`).
* **Encapsulamento:** Proteção dos atributos e acesso via métodos.

## 🚀 Funcionalidades

* **Listagem de Produtos:** Exibição de um menu interativo com os itens disponíveis.
* **Venda de Itens:**
    * *Acessórios:* Venda por quantidade informada.
    * *Roupa Tamanho Único:* Venda unitária.
    * *Roupa PMG:* Venda por tamanho específico (P, M ou G).
* **Validação de Estoque:** Impede vendas caso o estoque seja insuficiente, lançando alertas claros ao usuário.
* **Reposição Automática:** Após cada venda, o sistema verifica se o estoque atingiu o nível mínimo e, se necessário, repõe para o nível máximo automaticamente.

## 🛠️ Estrutura de Classes (Hierarquia)

O projeto segue rigorosamente o Diagrama de Classes proposto na atividade:

1.  **Interface `Item`:** Define o contrato obrigatório (`venda`, `reposicaoEstoque`, `getDescricao`).
2.  **Classe Abstrata `Peca`:** Implementa a lógica base de reposição e atributos comuns (descrição, estoque min/max).
3.  **Classes Concretas:**
    * `Acessorio`: Herda de `Peca`.
    * `RoupaTamanhoUnico`: Herda de `Peca`.
    * `RoupaPMG`: Implementa `Item` diretamente (gerencia estoques P, M e G individualmente).

## 📂 Organização do Projeto

A estrutura de pacotes segue o padrão de separação de responsabilidades:

```text
src/br/com/estoque
├── application
│   └── SistemaEstoque.java      # Classe Main (Menu e Interação com Usuário)
├── exception
│   └── EstoqueInsuficienteException.java # Exceção personalizada 
└── model
    ├── Item.java                # Interface principal
    ├── Peca.java                # Classe Abstrata pai
    ├── Acessorio.java           # Model
    └── roupas
        ├── RoupaPMG.java        # Model (Lógica complexa de P/M/G)
        └── RoupaTamanhoUnico.java # Model
