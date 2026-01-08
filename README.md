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

## 🛣️ Endpoints da API

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **POST** | `/client` | Cadastro de um novo Cliente |
| **POST** | `/contact` | Cadastro de Contato associado a um cliente existente |
| **GET** | `/client` | Listagem de todos os clientes com seus respectivos contatos |
| **GET** | `/client/{id}/contact` | Listagem de contatos de um cliente específico |

## 🛠️ Configuração Local

1. Clone o repositório.
2. Certifique-se de ter o **PostgreSQL** instalado e rodando localmente.
3. Configure as credenciais do banco no arquivo `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_seu_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update

## 🗂️ Estrutura de Pastas

```text
src/main/java/com/contact_management
│
├── commom/specification
│   ├── BaseSpecification.java
|   ├── SpecificationHelper.java
│   └── SearchCriteria.java
|
|
├── controller
│   ├── ClientController.java
│   └── ContactController.java
│
├── dto
│   ├── filter
│   │   ├── ClientFilterDTO.java
│   │   └── ContactFilterDTO.java
|   ├── response
│   │   ├── ClientResponseDTO.java
│   │   └── ContactResponseDTO.java
│   └── request
│       ├── ClientRequestDTO.java
│       └── ContactRequestDTO.java
│
├── mapper
│   ├── ClientCreateMapper.java
|   ├── ClientDTOMapper.java
|   ├── ContactCreateMapper.java
│   └── ContactDTOMapper.java
|
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
├── specification
│   ├── ClientSpecification.java
│   └── ContactSpecification.java
│
└── ContactManagementApplication.java
