Arquivo: calculadora.c
----------------------------------------------------------------------------------------
Uma calculadora simples no terminal que permite o usuário realizar operações básicas:
-Soma

-Subtração

-Divisão

-Multiplicação

Loop para múltiplas operações até o usuário encerrar.

Tecnologias:

Linguagem C

Entrada via scanf e saída formatada com printf
----------------------------------------------------------------------------------------
Sistema de Empréstimos em Java

Objetivo:

Simula um sistema de cadastro de clientes e concessão de empréstimos com base em dados validados e critérios de aprovação.

Classes Java:

Cliente.java

-Armazena os dados do cliente: nome, CPF, endereço e renda mensal.

-Faz validações de CPF e nome.

-Implementa o padrão Listener para notificar mudanças ao empréstimo.

-Inclui métodos para alterar e exibir os dados.

ClienteListener.java

-Interface que define o método clienteAtualizado(Cliente cliente) usado para comunicação entre Cliente e Emprestimo.

Data.java

-Representa datas com validação.

-Permite adicionar dias, meses e anos.

-Impede que a data ultrapasse o ano de 2050.

-Implementa verificação de ano bissexto.

-Possui método toString para exibir datas no formato dd/mm/aaaa.

Emprestimo.java

-Armazena dados do empréstimo: valor, juros, parcelas, data de início e fim.

-Calcula o valor com juros compostos (1.02 por mês).

-Avalia automaticamente o status do empréstimo com base na renda do cliente (parcela < 60% da renda).

-Atualiza-se automaticamente caso o cliente seja modificado, graças ao padrão Observer (Listener).

SistemaDeCadastro.java

Classe com o método main que simula um cenário:

-Criação de um cliente e empréstimo.

-Modificação dos dados do cliente.

-Geração de um relatório detalhado.

Requisitos para execução

Para o projeto em C:

Compilador C (GCC, Clang ou similares)

Para o projeto em Java:

Java JDK 8 ou superior

Funcionalidades importantes no sistema Java:

-Validação de entrada (nome, CPF, datas).

-Atualização automática de status do empréstimo com base na renda do cliente.

-Controle de datas com limites realistas.

-Separação das responsabilidades em classes específicas.

Conceitos aplicados:

-Programação estruturada (C)

-Programação orientada a objetos (Java)

-Encapsulamento

-Validação de dados

-Padrão Observer (Listener)

-Tratamento de exceções

-Modularização e reuso de código

Autor

Vinicius Silva

Estudante de Ciência da Computação | Projetos com C e Java

