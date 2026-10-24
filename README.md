# Logística Solidária

**Integrantes:** Pedro Barbosa Morais e Samuel Castello Branco

## Descrição do Projeto

O **Logística Solidária** é um sistema web desenvolvido como projeto acadêmico para conectar doadores, beneficiários, voluntários e organizações não governamentais (ONGs) em uma única plataforma. A aplicação facilita o gerenciamento, a distribuição e o acompanhamento de doações, promovendo organização, transparência e impacto social.

O projeto evoluiu de um site estático (HTML, CSS e JavaScript) para uma aplicação web completa com **Spring Boot**, **Thymeleaf**, **JPA** e **PostgreSQL**. A interface original foi mantida e integrada aos dados reais gravados no banco.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** (Web, Thymeleaf, Data JPA, Validation, DevTools)
- **Spring Data JPA / Hibernate** — persistência e mapeamento objeto-relacional
- **PostgreSQL** — banco de dados
- **Flyway** — controle de versão do banco (migrations)
- **Bean Validation** — validação no back-end (`@Valid`, `BindingResult`)
- **Thymeleaf** — integração entre back-end e páginas HTML
- **Maven** — gerenciamento de dependências e build
- **HTML5, CSS3 e JavaScript** — camada de apresentação

## Arquitetura

O projeto segue o fluxo em camadas:

```
Controller  →  Service  →  Repository  →  Banco de Dados
```

- **Controller:** recebe as requisições (`@GetMapping`, `@PostMapping`, `@PathVariable`) e envia dados às páginas por `Model`.
- **Service:** concentra as regras de negócio.
- **Repository:** acesso aos dados via `JpaRepository`.
- **Model:** entidades JPA (`@Entity`, `@Id`, `@GeneratedValue`) com relacionamento persistido no banco.

## Pré-requisitos

- JDK 17 ou superior
- Apache Maven
- PostgreSQL instalado e em execução

### Instalação no Fedora

```bash
sudo dnf install java-17-openjdk maven postgresql-server
```

### Instalação no Ubuntu/Debian

```bash
sudo apt install openjdk-17-jdk maven postgresql
```

### Instalação no Windows

1. Instale o **JDK 17** (por exemplo, [Eclipse Temurin](https://adoptium.net/)).
2. Baixe o **Apache Maven** em [maven.apache.org/download.cgi](https://maven.apache.org/download.cgi) (Binary zip archive) e extraia em uma pasta, como `C:\Program Files\Apache\maven`.
3. Crie as variáveis de ambiente `JAVA_HOME` e `MAVEN_HOME` e adicione `%JAVA_HOME%\bin` e `%MAVEN_HOME%\bin` ao `Path`.
4. Instale o **PostgreSQL** pelo [instalador oficial](https://www.postgresql.org/download/windows/).
5. Reabra o terminal e confirme:

```bash
java -version
mvn -version
```

## Configuração do Banco de Dados

1. Crie o banco no PostgreSQL:

```sql
CREATE DATABASE logistica_solidaria;
```

2. Ajuste as credenciais em `logistica-solidaria/src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/logistica_solidaria
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

As tabelas são criadas automaticamente pelo **Flyway** na primeira execução, a partir dos arquivos em `src/main/resources/db/migration`. Não é necessário criar tabelas manualmente.

## Como Executar

1. Clone o repositório e entre na pasta do projeto:

```bash
git clone https://github.com/pedromorais4709-arch/Logistica_Solidaria-5-periodo.git
cd Logistica_Solidaria-5-periodo/logistica-solidaria
```

2. Execute a aplicação:

```bash
mvn spring-boot:run
```

3. Acesse no navegador:

```
http://localhost:8080
```

Se a porta 8080 estiver ocupada, altere em `application.properties`:

```properties
server.port=8081
```

## Estrutura do Projeto

```
logistica-solidaria/
├── pom.xml
└── src/
    └── main/
        ├── java/com/logisticasolidaria/
        │   ├── LogisticaSolidariaApplication.java
        │   ├── controller/   — rotas e tratamento das requisições
        │   ├── service/      — regras de negócio
        │   ├── repository/   — interfaces JpaRepository
        │   └── model/        — entidades JPA
        └── resources/
            ├── application.properties
            ├── db/migration/ — migrations do Flyway
            ├── static/       — CSS, JavaScript e imagens
            └── templates/    — páginas Thymeleaf
```

## Funcionalidades e Rotas

| Rota | Descrição |
|------|-----------|
| `/` | Página inicial da plataforma |
| `/login` | Autenticação de usuários |
| `/cadastro` | Cadastro de novos usuários |
| `/dashboard` | Painel com estatísticas e doações recentes (dados do banco) |
| `/doacoes` | Listagem de doações com filtros por status e categoria |
| `/doacoes/nova` | Formulário de cadastro de doação, com validação |
| `/rastreamento` | Acompanhamento do status de uma doação |
| `/perfil` | Visualização e edição dos dados do usuário |

O sistema permite **cadastrar, listar, ver detalhes, editar e excluir** doações, com validação dos formulários no back-end e exibição de mensagens de erro.

## Licença

Distribuído sob a licença MIT. Consulte o arquivo `LICENSE`.
