# 🎓 Desafio de Arquitetura de Software - Sistema Acadêmico Uni4

Este repositório contém a solução proposta para o Desafio de Arquiteto de Software da Unifor. A arquitetura foi estruturada com foco em **microsserviços modernos**, **performance** e **escalabilidade**, utilizando tecnologias *Cloud-Native*.

---

## 📁 Estrutura do Repositório

A organização dos arquivos segue uma estrutura modular, facilitando a separação de responsabilidades entre as camadas do projeto:

| Pasta | Conteúdo Principal | Descrição |
| :--- | :--- | :--- |
| **`Docs/`** | Documentação 📜 | Contém todos os artefatos do projeto, como manuais, requisitos, apresentações técnicas e atas de reunião. |
| **`uni4_academico-api/`** | Back-end (API REST) ⚙️ | Código do servidor de aplicação, desenvolvido em **Java** e **Quarkus**, responsável pela lógica de negócio e persistência de dados. |
| **`uni4_academico-bd/`** | Infraestrutura de Dados 💾 | Arquivos de configuração e *scripts* para inicialização e gestão do banco de dados **PostgreSQL** e do servidor de **Keycloak**. |
| **`uni4_academico-front/`** | Front-end (Web UI) 🌐 | Código do sistema web de interface do usuário, construído com o framework **Angular**. |

---

## 🚀 Tecnologias Utilizadas

Esta solução utiliza uma *stack* tecnológica robusta e moderna, garantindo alta performance, segurança e uma excelente experiência de desenvolvimento (DX).

### 💾 Banco de Dados e Gerenciamento de Identidade

| Tecnologia | Ícone | Versão / Função | Destaque |
| :--- | :--- | :--- | :--- |
| **PostgreSQL** |  | **16.7** | SGDB *open source* robusto, estável e gratuito, ideal para aplicações escaláveis. |
| **Keycloak** |  | **26.4.6** | Plataforma de Gerenciamento de Identidade e Acesso (**IAM**) para implementar **Single Sign-On (SSO)** e controle de permissões. |
| **Flyway** |  | Migração de BD | Ferramenta que **versiona e controla** as alterações no esquema do banco de dados de forma segura e sequencial. |

### ⚙️ Back-end (API REST)

| Tecnologia | Ícone | Versão / Função | Destaque |
| :--- | :--- | :--- | :--- |
| **Java** | 

[Image of Java icon]
 | **21 (LTS)** | Linguagem de programação moderna e versátil, versão de Suporte de Longo Prazo. |
| **Quarkus** |  | LTS (3.x) | **Framework Java nativo** otimizado para o *Cloud-Native*, garantindo **inicialização ultrarrápida** e **baixo consumo de memória**. |
| **Panache** |  | ORM Simplificado | Camada de abstração que simplifica o uso do Hibernate ORM, **reduzindo o código repetitivo** (*boilerplate*). |

### 🌐 Front-end (Web UI)

| Tecnologia | Ícone | Versão / Função | Destaque |
| :--- | :--- | :--- | :--- |
| **Angular** | 

[Image of Angular icon]
 | **18+** | Framework *front-end* robusto para o desenvolvimento de **Single Page Applications (SPAs)**. |
| **PrimeNG** |  | Biblioteca UI | Extensa biblioteca de componentes de interface (*widgets*) para Angular, garantindo um *design* **responsivo** e funcional. |

### 📦 Outras Ferramentas

| Ferramenta | Ícone | Função | Destaque |
| :--- | :--- | :--- | :--- |
| **Docker** | 

[Image of Docker icon]
 | Containerização | Plataforma essencial para **empacotar e isolar** os microsserviços (Quarkus, PostgreSQL, Keycloak), garantindo a consistência entre ambientes. |
| **HeidiSQL** |  | Cliente BD | Software cliente de interface gráfica (GUI) para **interagir e gerenciar** visualmente os dados do PostgreSQL. |
| **VSCode** |  | Editor de Código | Editor gráfico leve e popular, utilizado para codificação e desenvolvimento. |

---

## 🛠️ Como Iniciar o Projeto

A forma recomendada para colocar o projeto no ar em seu ambiente de desenvolvimento é através do **Docker Compose**.
