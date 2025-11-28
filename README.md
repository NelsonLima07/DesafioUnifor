# 🎓 Desafio de Arquitetura de Software - Sistema Acadêmico Uni4

Este repositório contém a solução proposta para o Desafio de Arquiteto de Software da Unifor. A arquitetura foi estruturada com foco em **microsserviços modernos**, **performance** e **escalabilidade**
---

## 📁 Estrutura do Repositório

A organização dos arquivos segue uma estrutura modular, facilitando a separação de responsabilidades entre as camadas do projeto:

| Pasta | Conteúdo Principal | Descrição |
| :--- | :--- | :--- |
| **`Docs/`** | Documentação | Contém todos os artefatos do projeto, como manuais, requisitos, apresentações técnicas e atas de reunião. |
| **`uni4_academico-api/`** | Back-end (API REST) | Código do servidor de aplicação.
| **`uni4_academico-bd/`** | Banco de daados e Keycloak | Arquivos de configuração e inicialização do banco de dados |
| **`uni4_academico-front/`** | Front-end (Web UI) | Código do sistema web de interface do usuário |

---

## 🚀 Tecnologias Utilizadas

É uma *stack* robusta e moderna. Foi proposta no documento que descreve o desafio

### 💾 Banco de Dados e Gerenciamento de Identidade

| Tecnologia | Descrição |
| :--- | :--- |
| **PostgreSQL 16.7** | SGDB *open source* robusto, estável e gratuito. |
| **Keycloak 26.4.6** | Plataforma de Gerenciamento de Identidade e Acesso (**IAM**) para implementar **Single Sign-On (SSO)** e controle de permissões. |
| **Flyway** | Ferramenta que **versiona e controla** as alterações no banco de dados de forma segura e sequencial. |

### ⚙️ Back-end (API REST)

| Tecnologia | Descrição |
| :--- | :--- |
| **Java 21** | Linguagem de programação |
| **Quarkus 3** | **Framework Java nativo** otimizado para otimizar criação de microserviços|
| **Panache** | ORM Simplificado abstrai e simplifica o uso do Hibernate ORM |

### 🌐 Front-end (Web UI)

| Tecnologia | Descrição |
| :--- | :--- |

| **Angular 18** | Framework para o desenvolvimento WEB |
| **PrimeNG** |  | Biblioteca UI de componentes de interface (*widgets*) para Angular |
nh
### 📦 Outras Ferramentas

| Tecnologia | Descrição |
| :--- | :--- |
| **Docker** | Containerização para empacotar e isolar os serviços |
| **HeidiSQL** | Cliente BD, uma interface gráfica (GUI) para interagir e gerenciar banco de dados |
| **VSCode** | Editor gráfico, utilizado para codificação e desenvolvimento. |
---

## 🛠️ Como Iniciar o Projeto

Certifique-se que tenha o **docker** instalado e um client **Git**