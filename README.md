## API DE AUTENTICAÇÃO

Esse projeto foi desenvolvido em Java afim de explorar e conhecer ferramentas atuais para autenticação de usuario, utilizando ferramentas ferramentas contemporaneas
como JWT e Spring Security para controle autenticações e geração de token (matendo o padrão statless), Flyway migrations e PostgreSQL como banco de dados.

## Instalação
1. Clone o repositório:

```bash
https://github.com/dev-danielJunio/auth-api.git
```

2. Instale as dependencias com Maven

3.  Instale [PostgresSQL](https://www.postgresql.org/)

## API Endpoints
A API fornece os seguintes endpoints:

```markdown
GET /product - Recuperar uma lista de todos os produtos. (todos os usuários autenticados).

POST /product - Register um novo produto (requerido acesso como ADMIN).

POST /auth/login - Logar no app.

POST /auth/register - Register um novo usuario no app.
```

# Autenticação
A API usa Spring Security para controle de autenticação. As seguintes funções estão disponíveis:

```
USUÁRIO -> Função de usuário padrão para usuários logados.
ADMIN -> Função administrativa para parceiros gestores (registo de novos parceiros).
```
Para acessar endpoints protegidos como usuário ADMIN, forneça as credenciais de autenticação apropriadas no cabeçalho da solicitação.

