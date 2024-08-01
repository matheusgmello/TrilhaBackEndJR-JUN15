![Código Certo Coders](https://utfs.io/f/3b2340e8-5523-4aca-a549-0688fd07450e-j4edu.jfif)

# 📚 Trilha Inicial BackEnd Jr
Este projeto tem como objetivo desenvolver uma API RESTful para gerenciamento de tarefas, proporcionando funcionalidades de CRUD (Create, Read, Update, Delete) de tarefas, autenticação de usuários e armazenamento dos dados em um banco de dados.

## Objetivos:
- Criar uma API que permita CRUD (Create, Read, Update, Delete) de tarefas.
- Implementar autenticação de usuários.
- Utilizar um banco de dados SQLite para armazenar as tarefas.
- Documentar todo o processo e apresentar as conclusões.

## Requisitos Funcionais:
- Criar Tarefa: Endpoint para criar uma nova tarefa.
- Listar Tarefas: Endpoint para listar todas as tarefas.
- Atualizar Tarefa: Endpoint para atualizar uma tarefa existente.
- Deletar Tarefa: Endpoint para deletar uma tarefa existente.

## Autenticação de Usuários:
- Registro de Usuário: Endpoint para registrar um novo usuário.
- Login de Usuário: Endpoint para autenticar um usuário e gerar um token JWT.
- Proteção de Rotas: Garantir que apenas usuários autenticados possam acessar os endpoints de tarefas.

## Como instalar e usar 

* Caso não queire testar localmente, Pode ser acessada via deploy atráves do link: (`https://trilhabackendjr.onrender.com/`)

* 1 Clone o repositório
```bash
git clone git@github.com:matheusgmello/TrilhaBackEndJR-JUN15.git
```
- 2 Instale as dependências
```bash
mvn clean install
```
- 3 Inicie o servidor
```bash
mvn spring-boot:run
```
- 4 API ficara disponivel na url
```bash
http://localhost:8080
```
- 5 Teste a API no Postman

### Rotas 

- Acesse a documentação dos Endpoints através do Swagger

   * Deploy `https://trilhabackendjr.onrender.com/swagger-ui/index.html#/`
   * Localmente `http://localhost:8080/swagger-ui/index.html#/`
  

```markdown

### Rotas de Autenticacao

POST /usuario/register - Registra usuário

{
  "usuario": "Matheus",
  "senha": "123456"
}

Response Body

{
  "message": "Usuário criado com sucesso"
}

POST /usuario/login - Realiza o Login do usuário, gerando um token de acesso

{
  "usuario": "Matheus",
  "senha": "123456"
}

Response Body

{
  "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9."
}

### Rotas do usuário

**Necessita estar autenticado**

GET /usuario - Lista todos usuários registrados

Response Body

[
  {
    "id": 1,
    "usuario": "Matheus",
    "senha": "$2a$10$qXUsMSpZgI6RptKYq3mJRuZ.ATgq4hnkGSpLiZbOP3cc9B9KDqBAW"
  }
]

PUT /usuario/{ID} - Atualiza o usuário com o ID fornecido

{
  "usuario": "Adonaldo Cleber",
  "senha": "123456"
}

Response Body

{
  "id": 1,
  "usuario": "Adonaldo Cleber",
  "senha": "$2a$10$mymTZ5jkLN3gytEBPUrYHeN//9kJSZFqf7nHygp9GCtU/VQzcMOh2"
}

DELETE /usuario/{ID} - Deleta o usuário com o ID fornecido

Response Body

{
  "message": Usuário deletado com sucesso.
}

### Rotas de Tarefas

**É necessário estar autenticado para utilizar está rota**

POST /tarefa - Cria uma nova tarefa

**Status da tarefa pode ser PENDENTE', 'CONCLUIDO' ou 'CANCELADO'**

{
  "descricao": "Ir ao mercado comprar pão e leite",
  "status": "PENDENTE"
}

GET /tarefa - Lista todas as tarefas registradas

Response Body

[
  {
    "id": 1,
    "descricao": "Ir ao mercado comprar pão e leite",
    "status": "PENDENTE",
    "dataCriacao": "2024-08-01 12:51:31",
    "dataAtualizacao": "2024-08-01 12:51:42"
  }
]

PUT /tarefa/{ID} - Altera a tarefa com o ID fornecido

{
  "descricao": "Ir ao mercado comprar pão e leite e banana",
  "status": "CONCLUIDO",
}

Response Body

{
  "id": 1,
  "descricao": "Ir ao mercado comprar pão e leite e banana",
  "status": "PENDENTE",
  "dataCriacao": "2024-08-01 12:51:31",
  "dataAtualizacao": "2024-08-01 12:51:42"
}

DELETE /tarefa/{ID} - Deleta a tarefa com o ID fornecido

Response Body

{
  "mensagem": "Tarefa deletada com sucesso"
}

```
## Conecte-se comigo
[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/matheusgmello)
[![Reddit](https://img.shields.io/badge/Reddit-%23FF4500.svg?style=for-the-badge&logo=Reddit&logoColor=white)](https://www.reddit.com/user/math7zw)
[![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/matheusgmello/)