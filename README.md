# 🎀 Projeto Barbie - Colecionismo e Fórum (Programação 4)

Bem-vindo ao repositório do **Projeto Barbie**! Esta é uma aplicação web desenvolvida como requisito para a disciplina de Programação 4.

O sistema funciona como um portal interativo para colecionadores e fãs da franquia, permitindo a exploração de um catálogo de bonecas, o gerenciamento de coleções pessoais, a leitura de notícias e a interação com outros usuários através de um fórum de discussões.

Alunos: Ana Luiza Almeida e Wagner Lopes
---

## 🚀 Funcionalidades da Aplicação

O sistema foi dividido em módulos para facilitar a navegação e o uso:

*   **🔐 Autenticação e Segurança:**
    *   Cadastro de novos usuários.
    *   Sistema de Login.
    *   Recuperação de senha.
*   **📖 Catálogo e Wiki:**
    *   Listagem completa de bonecas (ex: Fashionistas, Profissões, Colecionáveis, etc).
    *   Filtro dinâmico para busca de bonecas no catálogo.
    *   Cadastro de novas bonecas no sistema.
    *   Seção Wiki com detalhes de cada modelo.
*   **💬 Fórum de Discussões:**
    *   Criação de novos tópicos (Posts) vinculados a categorias específicas.
    *   Página dedicada para discussão e leitura de tópicos.
    *   Sistema de comentários nos tópicos (interação entre usuários).
*   **👤 Área do Usuário (Perfil):**
    *   Painel pessoal do usuário.
    *   Gerenciamento da coleção pessoal de bonecas.
    *   Histórico de "Meus Posts" criados no fórum.
*   **📰 Portal de Notícias:**
    *   Mural com os últimos lançamentos e novidades do universo Barbie.

---

## 🛠️ Tecnologias Utilizadas

O projeto adota a arquitetura **MVC (Model-View-Controller)** e utiliza as seguintes tecnologias:

**Backend:**
*   **Java 25**
*   **Spring Boot (3.3.4)**
*   **Spring Data JPA** & **Hibernate** (Mapeamento Objeto-Relacional)
*   **Flyway** (Migrations para versionamento do banco de dados)
*   **HikariCP** (Pool de conexões)

**Frontend:**
*   **Thymeleaf** (Template Engine)
*   **HTML5, CSS3 e JavaScript** (Estilização de páginas, modais e filtros dinâmicos)

**Banco de Dados:**
*   **PostgreSQL**

---

## ⚙️ Como executar o projeto localmente

Para que a aplicação funcione corretamente na sua máquina (ou na avaliação do professor), é necessário configurar o banco de dados antes de iniciar o servidor. Siga o passo a passo abaixo:

### 1. Criação do Banco de Dados
A aplicação utiliza o **Flyway** para criar as tabelas e inserir dados iniciais automaticamente, mas o banco principal precisa existir previamente.
* Abra o seu gerenciador de banco de dados (pgAdmin, DBeaver, etc).
* Crie um novo banco de dados vazio com o nome exato: `DB_barbie` (ou o nome que configuramos na string de conexão).

### 2. Configuração de Credenciais
Acesse o arquivo de configuração localizado em:
`src/main/resources/application.properties`

Encontre a linha correspondente à senha e altere para a senha do seu usuário `postgres` local (ou o usuário que você utiliza no banco):
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/DB_barbie
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA_AQUI