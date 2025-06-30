# 💳 Projeto de Conta Bancária
# Discente: Luiz Fellipe Lobo Lopes

Projeto Spring Boot para simulação de uma aplicação bancária com operações de **depósito**, **retirada**, controle de **concorrência**, e testes automatizados com **JMeter**.

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Banco de dados H2
- JMeter
- Maven

## 🏦 Funcionalidades da Conta Bancária

- Criar contas com nome do cliente e saldo inicial
- Realizar depósitos e retiradas
- Ver saldo atualizado
- Testes com concorrência de múltiplas threads
- Versão otimista com controle de versão usando `@Version`

## 🔗 Endpoints REST

| Método | Endpoint                         | Descrição             |
|--------|----------------------------------|------------------------|
| GET    | `/contas`                        | Listar todas as contas |
| POST   | `/contas`                        | Criar nova conta       |
| PUT    | `/contas/{id}/deposito?valor=10` | Depositar valor        |
| PUT    | `/contas/{id}/retirada?valor=5`  | Retirar valor          |

> Exemplo: `PUT http://localhost:8080/contas/1/deposito?valor=200`

## 🧪 Testes de Concorrência

- Foi criada uma classe de teste que simula múltiplas operações paralelas (com `ExecutorService`)
- Testes realizados sobre:
  - `ContaBancaria` (sem controle de versão)
  - `ContaBancariaVersionada` (com `@Version`)

## ⚙️ Testes c/ JMeter

- Configurações:
  - 10 threads
  - 100 iterações por thread
  - Operações de depósito e retirada simultâneas
- Resultados exportados para análise de desempenho e possíveis falhas de bloqueio
- Os arquivos "Deposito.jmx" e "Retirada.jmx" mostram os testes feitos com o JMeter. Eles podem ser encontrados no repositório deste README.

### Print do resultado de teste com o JMeter

### TESTE DE RETIRADA

![Image](https://github.com/user-attachments/assets/317897de-7527-4f3f-af3b-45dc2cc70e05)

![Image](https://github.com/user-attachments/assets/d4ad0974-f98a-41c2-9e8e-e0b468996556)

### TESTE DE DEPÓSITO

![Image](https://github.com/user-attachments/assets/4e9766a9-03d5-4a54-bb54-35e98e35d17e)

![Image](https://github.com/user-attachments/assets/e22bfa1e-17fd-43a1-92e4-135ee20da463)


## 🖥️ Banco H2

- Acesso ao H2 console: [http://localhost:8080/h2](http://localhost:8080/h2)
- Credenciais:
  - **User:** `sa`
  - **Password:** `sa`

## 🧠 Observações

- O campo `@Version` em `ContaBancariaVersionada` evita perda de dados em ambientes concorrentes
- Os testes mostram que o controle de concorrência otimista evita inconsistências no saldo
