# vendas-sys
Projeto realizado em Spring Boot como avaliação para disciplina TCC00338 Projeto de Software da Universidade Federal Fluminense.

Esse projeto consiste em uma aplicação Web para gerenciamento de vendas de um mercado, para usuários do tipo gerente e vendedor. A aplicação permite o cadastro de clientes VIPs para sistema de troca de pontos por desconto em compras.

## 1. Compilando o código

Para rodar localmente a aplicação backend, no PowerShell rode o comando `mvn spring-boot:run`. O endereço base da aplicação é http://localhost:8083.

Além disso, é necessário configurar a url, username e senha para o banco em `application.properties`.

## 2. Estrutura do projeto

* vendas-sys/src/main
    * java
        * br.com.uff.vendassys
            * domain
                * entity
                * enums 
                * repository
            * service
                * builder
                * exception
                * impl (implementação dos serviços)
                * *interfaces dos services*
            * web
                * controller
                * dto
                * utils (ferramentas de apoio)
    * resources
        * application.properties (configurações do projeto)
        * data.sql (carga mock do banco)

## 3. Relatório

O relatório do projeto encontra-se no diretório `docs`.

## 4. API

É possível testar os endpoints e visualizar a documentação da API rodando a aplicação e acessando a [UI Swagger](https://swagger.io/tools/swagger-ui/) no endereço **http://localhost:8083/api-doc**.
