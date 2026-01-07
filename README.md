# 📌 API de Gerenciamento de Clientes e Contatos

API REST desenvolvida com **Spring Boot** para gerenciamento de **clientes** e seus **contatos associados**, aplicando boas práticas de arquitetura, separação de responsabilidades, uso de DTOs e tratamento adequado de erros.

---

## 🚀 Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- PostgreSQL (Banco de dados local)  
- Lombok  
- SpringDoc OpenAPI (Swagger)  
- JUnit / Mockito (testes)  

---

## 📐 Arquitetura

O projeto segue os princípios da **Clean Architecture**, separando claramente as responsabilidades em camadas:

- **Controller** → Entrada da API (HTTP)
- **Service (Use Cases)** → Regras de negócio
- **Repository** → Persistência de dados
- **Domain** → Entidades e regras centrais
- **DTOs** → Comunicação entre camadas

Essa abordagem facilita:
- Manutenção  
- Testes  
- Evolução do sistema  
- Baixo acoplamento  

---

## 🗂️ Estrutura de Pastas

```text
src/main/java/com/seuusuario/clientesapi
│
├── controller
│   ├── ClientController.java
│   └── ContactController.java
│
├── dto
│   ├── client
│   │   ├── ClientRequestDTO.java
│   │   └── ClientResponseDTO.java
│   └── contact
│       ├── ContactRequestDTO.java
│       └── ContactResponseDTO.java
│
├── domain
│   ├── Client.java
│   └── Contact.java
│
├── repository
│   ├── ClientRepository.java
│   └── ContactRepository.java
│
├── service
│   ├── ClientService.java
│   └── ContactService.java
│
├── exception
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
│
└── ClientesApiApplication.java
