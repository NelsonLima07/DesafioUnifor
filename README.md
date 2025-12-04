## 🎓 Desafio de Arquitetura de Software - Sistema Acadêmico Uni4

Este repositório contém a solução proposta para o Desafio de Arquiteto de Software da Unifor. A arquitetura foi estruturada com foco em **microsserviços modernos**, **performance** e **escalabilidade**
---

### 📁 Estrutura do Repositório

A organização dos arquivos segue uma estrutura modular, facilitando a separação de responsabilidades entre as camadas do projeto:

| Pasta | Conteúdo Principal | Descrição |
| :--- | :--- | :--- |
| **`Docs/`** | Documentação | Contém todos os artefatos do projeto, como manuais, requisitos, apresentações técnicas e atas de reunião. |
| **`uni4_academico-api/`** | Back-end (API REST) | Código do servidor de aplicação.
| **`uni4_academico-bd/`** | Banco de daados e Keycloak | Arquivos de configuração e inicialização do banco de dados |
| **`uni4_academico-front/`** | Front-end (Web UI) | Código do sistema web de interface do usuário |

Diagrama do banco de dados: https://dbdiagram.io/d/Uni4-academico-692c601ed6676488baf596c6
---

### 🚀 Tecnologias Utilizadas

É uma *stack* robusta e moderna. Foi proposta no documento que descreve o desafio

<table>
    <thead>
    </thead>
    <tbody>
        <tr>
            <th colspan="4" align="center">
                💾 Banco de Dados e IAM
            </th>
        </tr>
        <tr>
            <td align="center">**PostgreSQL 16.7**a</td>
            <td>SGDB *open source* robusto, estável e gratuito.</td>
        </tr>
        <tr>
            <td align="center">**Keycloak 26.4.6**</td>
            <td>Plataforma de Gerenciamento de Identidade e Acesso (**IAM**) e controle de permissões.</td>
        </tr>
        <tr>
            <td align="center">**Flyway**</td>
            <td>Ferramenta que **versiona e controla** as alterações no banco de dados de forma segura e sequencial.</td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                ⚙️ Back-end (API REST)
            </td>
        </tr>
        <tr>
            <td align="center">Java 21</td>
            <td>Linguagem de programação</td>
        </tr>
        <tr>
            <td align="center">Quarkus 3</td>
            <td>**Framework Java nativo** otimizado para otimizar criação de microserviços</td>
        </tr>
        <tr>
            <td align="center">Panache</td>
            <td>ORM Simplificado abstrai e simplifica o uso do Hibernate</td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                🌐 Front-end e Serviços
            </td>
        </tr>
        <tr>
            <td align="center">Angular 18</td>
            <td>Framework para o desenvolvimento WEB</td>
        </tr>
        <tr>
            <td align="center">PrimeNG</td>
            <td>Biblioteca UI de componentes de interface (*widgets*) para Angular</td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                📦 Outras Ferramentas
            </td>
        </tr>
        <tr>
            <td align="center">Docker</td>
            <td>Containerização para empacotar e isolar os serviços</td>
        </tr>
        <tr>
            <td align="center">HeidiSQL</td>
            <td>Cliente BD, uma interface gráfica (GUI) para interagir e gerenciar banco de dados</td>
        </tr>
        <tr>
            <td align="center">VSCode</td>
            <td>Editor gráfico, utilizado para codificação e desenvolvimento</td>
        </tr>
      </tbody>
</table>

### 🛠️ Como Iniciar o Projeto

#### Pré-requisitos 
Node.js - https://nodejs.org/pt
Docker - https://www.docker.com/
Java JDK - https://www.oracle.com/java/
Quarkus - https://quarkus.io/
Gradle - https://gradle.org/

Certifique-se que tenha tudo instalado corretamente. E sigas os seguintes passos

### 1. Subir Banco e Keycloak

Na pasta: uni4_academico-bd\docker do projeto
```
docker-compose -p uni4_academico up -d
````
PostgreSQL: Teste o acesso com algum cliente de acesso a banco de dados Postgre. Verifique as configurações em .env da mesma pasta.
Keycloak: Teste o acesso navegando localhost:8080. 

### 2. Subir API Quarkus
Na pasta: uni4_academico-api\quarkus-academico do projeto
```
gradle quarkusdev
````
Quarkus: Teste o acesso navegando localhost:8180. 

### 3. Subir Front web Angular
Na pasta: uni4_academico-front\angular_uni4-academico do projeto
```
ng serve
````
Angular: Teste o acesso navegando localhost:4200. 

## ⚡Agora faça login acessando: admin / admin
---