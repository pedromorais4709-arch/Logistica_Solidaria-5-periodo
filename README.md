# Logística Solidária

# Alunos: Pedro Barbosa Morais e Samuel Castello Branco

## Descrição do Projeto

O **Logística Solidária** é um sistema desenvolvido como projeto acadêmico, com o objetivo de conectar doadores, beneficiários, voluntários e organizações não governamentais (ONGs) em uma única plataforma. A aplicação tem como propósito facilitar o gerenciamento, a distribuição e o acompanhamento de doações, promovendo maior organização, transparência e impacto social.

Este projeto foi desenvolvido utilizando o framework **Spring Boot**, e o motor de templates **Thymeleaf** para renderização das páginas.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** (módulos Web e Thymeleaf)
- **Spring Boot DevTools**
- **Maven** — gerenciamento de dependências e automação de build
- **Thymeleaf** — motor de templates para integração entre back-end e front-end
- **HTML5, CSS3 e JavaScript** — camada de apresentação

## Pré-requisitos

Para executar este projeto localmente, é necessário possuir os seguintes componentes instalados:

- Java Development Kit (JDK), versão 17 ou superior
- Apache Maven

### Instalação no Fedora

```bash
sudo dnf install java-17-openjdk maven
```

### Instalação no Ubuntu/Debian

```bash
sudo apt install openjdk-17-jdk maven
```

### Instalação no Windows

1. Baixe e instale o **JDK 17** (ou superior) através do site oficial da Oracle ou de uma distribuição OpenJDK, como a [Eclipse Temurin](https://adoptium.net/).

2. Baixe o **Apache Maven** em [maven.apache.org/download.cgi](https://maven.apache.org/download.cgi), na versão "Binary zip archive".

3. Extraia o arquivo `.zip` do Maven em uma pasta de sua preferência, por exemplo: `C:\Program Files\Apache\maven`.

4. Configure as variáveis de ambiente:
   - Abra o menu Iniciar e pesquise por **"Variáveis de ambiente"**
   - Clique em **"Editar as variáveis de ambiente do sistema"**
   - Em **Variáveis do sistema**, adicione:
     - `JAVA_HOME`: caminho da instalação do JDK (ex: `C:\Program Files\Java\jdk-17`)
     - `MAVEN_HOME`: caminho da pasta onde o Maven foi extraído (ex: `C:\Program Files\Apache\maven`)
   - Edite a variável `Path` e adicione:
     - `%JAVA_HOME%\bin`
     - `%MAVEN_HOME%\bin`

5. Reinicie o terminal (Prompt de Comando ou PowerShell) para que as alterações tenham efeito.

### Verificação da instalação

Para confirmar que as ferramentas foram instaladas corretamente, execute:

```bash
java -version
mvn -version
```

## Instruções de Instalação e Execução

1. Clone o repositório para sua máquina local:

```bash
git clone <URL-DO-REPOSITORIO>
cd logistica-solidaria
```

2. Execute a aplicação por meio do Maven:

```bash
mvn spring-boot:run
```

3. Após a inicialização, a aplicação estará disponível no navegador através do seguinte endereço:

```
http://localhost:8080
```

**Observação:** caso a porta 8080 já esteja sendo utilizada por outro processo na máquina, é possível alterá-la no arquivo `src/main/resources/application.properties`:

```properties
server.port=8081
```

## Estrutura do Projeto

```
logistica-solidaria/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── com/logisticasolidaria/
        │       ├── LogisticaSolidariaApplication.java
        │       ├── controller/     — camada responsável pelo roteamento e tratamento das requisições
        │       ├── model/          — classes que representam as entidades do sistema (Doação, Usuário)
        │       └── service/        — camada de regras de negócio e manipulação dos dados simulados
        └── resources/
            ├── application.properties
            ├── static/              — arquivos estáticos (CSS, JavaScript e imagens)
            └── templates/           — páginas HTML processadas pelo Thymeleaf
```

## Funcionalidades e Rotas

| Rota | Descrição |
|---|---|
| `/` | Página inicial da plataforma |
| `/login` | Autenticação de usuários |
| `/cadastro` | Cadastro de novos usuários |
| `/dashboard` | Painel com estatísticas gerais e doações recentes |
| `/doacoes` | Listagem de doações, com filtros por status e categoria |
| `/doacoes/nova` | Formulário para cadastro de novas doações |
| `/rastreamento` | Acompanhamento do status de uma doação |
| `/perfil` | Visualização e edição dos dados do usuário |

