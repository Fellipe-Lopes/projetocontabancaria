# 💳 Projeto de Conta Bnacária

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

## ⚙️ Testes com JMeter

- Configurações:
  - 10 threads
  - 100 iterações por thread
  - Operações de depósito e retirada simultâneas
- Resultados exportados para análise de desempenho e possíveis falhas de bloqueio
- Os arquivos "Deposito.jmx" e "Retirada.jmx" mostram os testes feitos com o JMeter

### Print do resultado de teste com o JMeter

TESTE DE RETIRADA

![Image](https://github.com/user-attachments/assets/f1008e1e-675a-40ee-9fd3-2ba4fbc72668)

![Image](https://github.com/user-attachments/assets/c7a74e66-6b84-4858-a490-44c62fdbcd5d)

TESTE DE DEPÓSITO

![Image](https://github.com/user-attachments/assets/3be2f126-00a0-4020-89f9-d0db7d10e414)

![Image](https://github.com/user-attachments/assets/0890ced9-ec8c-423d-81cb-29cdfe7eb6e0)


## 🖥️ Console do Banco H2

- Acesso ao H2 console: [http://localhost:8080/h2](http://localhost:8080/h2)
- Credenciais:
  - **User:** `sa`
  - **Password:** `sa`

## 🧠 Observações Técnicas

- O campo `@Version` em `ContaBancariaVersionada` evita perda de dados em ambientes concorrentes
- Os testes mostram que o controle de concorrência otimista evita inconsistências no saldo
