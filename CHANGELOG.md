# Changelog

Todas as mudanças notáveis neste projeto serão documentadas neste arquivo.

O formato é baseado no [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
e este projeto adere ao [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [0.1.0] - 2026-01-07

### Adicionado
- Configuração inicial do projeto utilizando **Spring Boot 3** e **Java 17**.
- Dependências base: **Spring Web**, **Spring Data JPA**, **PostgreSQL Driver**, **Lombok** e **SpringDoc OpenAPI**.
- Estrutura de pacotes seguindo a separação de responsabilidades: `controller`, `service`, `repository`, `entities`, `dtos` e `exceptions`.
- Arquivo README.md com as especificações do desafio e instruções de setup.
- Configuração de conexão com banco de dados PostgreSQL local no `application.properties`.