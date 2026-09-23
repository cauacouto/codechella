# 🎟️ Plataforma de Ingressos — Spring Reactive

Aplicação desenvolvida para simular uma **plataforma de venda de ingressos para eventos**, utilizando uma arquitetura reativa com **Spring WebFlux, Project Reactor e R2DBC**.

O projeto tem como objetivo explorar o desenvolvimento de aplicações capazes de lidar com **grande quantidade de requisições simultâneas**, como em situações onde milhares de usuários acessam uma plataforma ao mesmo tempo para comprar ingressos de um evento.

## 🚀 Tecnologias

* Java
* Spring Boot
* Spring WebFlux
* Project Reactor

  * `Mono`
  * `Flux`
* Spring Data R2DBC
* Banco de dados relacional
* flyway
* Maven
* Docker

## 🧩 Sobre o projeto

Imagine a abertura das vendas de ingressos para um grande show.

Milhares de pessoas podem acessar a plataforma simultaneamente para:

* consultar eventos;
* visualizar disponibilidade de ingressos;
* selecionar ingressos;
* realizar uma compra;
* consultar seus pedidos.

Em uma aplicação tradicional bloqueante, cada operação pode manter uma thread ocupada enquanto aguarda uma operação de I/O, como uma consulta ao banco de dados.

Neste projeto, a proposta é utilizar o modelo **reativo**, permitindo que a aplicação trabalhe de forma **não bloqueante**, utilizando os recursos do Spring WebFlux e do Project Reactor.

## ⚡ Programação Reativa

A aplicação utiliza `Mono` e `Flux` para representar operações assíncronas e não bloqueantes.

### Mono

Utilizado quando uma operação pode retornar **zero ou um elemento**.

Exemplo:

```java
Mono<Event> findById(Long id)
```

### Flux

Utilizado quando uma operação pode retornar **zero, um ou vários elementos**.

Exemplo:

```java
Flux<Event> findAll()
```

Dessa forma, o fluxo de dados pode ser processado de maneira reativa, evitando o modelo tradicional de bloqueio durante operações de I/O.

## 🏗️ Arquitetura

A aplicação segue uma separação de responsabilidades entre as principais camadas:

```text
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
Database
```

A comunicação entre essas camadas utiliza os tipos reativos do Project Reactor.

```text
HTTP Request
     │
     ▼
Spring WebFlux
     │
     ▼
Mono / Flux
     │
     ▼
R2DBC
     │
     ▼
Database
```

## 🎯 Objetivo do uso de WebFlux

O principal objetivo do projeto é estudar como uma aplicação pode trabalhar com **alta concorrência utilizando operações não bloqueantes**.

Um cenário que representa bem o problema é:

```text
             ┌───────────────┐
             │    Usuário    │
             └───────┬───────┘
                     │
                     ▼
              ┌─────────────┐
              │ API WebFlux │
              └──────┬──────┘
                     │
             ┌───────┴────────┐
             │                │
             ▼                ▼
        ┌─────────┐      ┌─────────┐
        │  Flux   │      │  Mono   │
        └────┬────┘      └────┬────┘
             │                │
             └───────┬────────┘
                     ▼
                ┌─────────┐
                │ R2DBC   │
                └────┬────┘
                     ▼
                ┌─────────┐
                │  Banco  │
                └─────────┘
```

## 📚 Conceitos estudados

Durante o desenvolvimento do projeto são explorados conceitos como:

* Programação reativa
* Spring WebFlux
* Project Reactor
* `Mono` e `Flux`
* Backpressure
* Operações não bloqueantes
* R2DBC
* APIs REST reativas
* Alta concorrência
* Fluxo assíncrono de dados
* Persistência reativa

## 🔄 Fluxo de uma consulta

Um exemplo de consulta de eventos pode seguir o seguinte fluxo:

```text
GET /events
      │
      ▼
Controller
      │
      ▼
Service
      │
      ▼
Repository
      │
      ▼
R2DBC
      │
      ▼
Flux<Event>
```

O `Flux` representa o fluxo de eventos que será consumido pela aplicação.

## 🛠️ Como executar

### Pré-requisitos

* Java 21+
* Maven
* Docker e Docker Compose

### Executar a aplicação

```bash
./mvnw spring-boot:run
```

Ou:

```bash
mvn spring-boot:run
```

## 📌 Status do projeto

🚧 Projeto em desenvolvimento.

O projeto está sendo desenvolvido com foco no estudo de **Spring Reactive e arquitetura não bloqueante**, podendo receber novos recursos relacionados ao gerenciamento de eventos, ingressos e compras.

## 👨‍💻 Autor

**Cauã Couto**

Desenvolvedor Backend Java

* Java
* Spring Boot
* Microservices
* APIs REST
* Mensageria
* Arquitetura de software
