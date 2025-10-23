# 🏪 Sistema de Controle de Estoque

Este projeto é um **Sistema de Controle de Estoque** desenvolvido em **Java com Spring Boot**, permitindo gerenciar **produtos, clientes, funcionários e vendas**.  
O sistema realiza operações completas de **CRUD** e inclui uma funcionalidade de **vendas automatizadas**, onde o produto é decrementado do estoque conforme a venda é feita — e é inativado caso o estoque chegue a zero.

---

## 🚀 Funcionalidades Principais

- 🧍 **Cadastro de Clientes** — criar, listar, atualizar e excluir clientes.
- 👷 **Cadastro de Funcionários** — registrar e gerenciar funcionários.
- 📦 **Cadastro de Produtos** — controlar nome, quantidade, preço e status (ativo/inativo).
- 💰 **Gestão de Vendas**:
  - Realiza vendas entre cliente, funcionário e produto.
  - Decrementa automaticamente o estoque do produto.
  - Inativa o produto caso o estoque chegue a **zero**.
  - Calcula o valor total da venda com base no preço do produto.

---

## 🧱 Arquitetura do Projeto

O projeto segue o padrão **MVC (Model–View–Controller)**:

```text
controle-estoque/
│
├── src/main/java/br/com/vieiradev/controleestoque/ControleDeEstoque/
│   ├── controller/        # Endpoints REST
│   ├── dto/               # Objetos de transferência de dados
│   ├── model/             # Entidades JPA (Cliente, Produto, Venda, Funcionário)
│   ├── repository/        # Interfaces JpaRepository
│   ├── service/           # Lógica de negócio
│   └── ControleDeEstoqueApplication.java
│
└── README.md
````

---

## ⚙️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 Database** (ou outro configurado em `application.properties`)
- **Lombok**
- **Maven**
- **Jakarta Persistence (JPA)**
- **Spring Web**

---

## 🧩 Entidades Principais

| Entidade | Descrição |
|-----------|-----------|
| **Client** | Representa o cliente que realiza uma compra. |
| **Employee** | Representa o funcionário responsável pela venda. |
| **Product** | Armazena informações dos produtos no estoque (nome, preço, quantidade e status ativo/inativo). |
| **Sale** | Registra cada venda feita, associando cliente, produto e funcionário. |

---

## 🔄 Lógica de Vendas

Ao realizar uma venda:

1. O sistema busca o cliente, produto e funcionário pelo ID.
2. Verifica se há estoque suficiente.
3. Calcula o valor total (preço × quantidade).
4. Reduz a quantidade do produto.
5. Se a quantidade chegar a **zero**, o produto é inativado.
6. A venda é registrada na base de dados.

---

## 📡 Endpoints Principais

## Clientes (`/client`)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET    | `client` | Lista todos os clientes |
| GET    | `client/{id}` | Busca cliente por ID |
| POST   | `client` | Cria um cliente |
| PUT    | `client/{id}` | Atualiza cliente existente |
| DELETE | `client/{id}` | Deleta cliente pelo ID |

## Funcionários (`/employee`)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET    | `employee` | Lista todos os funcionários |
| GET    | `employee/{id}` | Busca funcionário por ID |
| POST   | `employee` | Cria um funcionário |
| PUT    | `employee/{id}` | Atualiza funcionário existente |
| DELETE | `employee/{id}` | Deleta funcionário pelo ID |

### Produtos (`/product`)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/product` | Lista todos os produtos |
| `GET` | `/product/{id}` | Busca produto por ID |
| `POST` | `/product` | Cria um novo produto |
| `PUT` | `/product/{id}` | Atualiza produto existente |
| `DELETE` | `/product/{id}` | Deleta produto |

### Vendas (`/sale`)

| Método | Endpoint	| Descrição
|--------|----------|-----------|
| GET	| `sale` | Lista todas as vendas
| GET	| `sale/{id}`	| Busca venda por ID
| POST	| `sale`	| Cadastra uma venda (entidade completa)
| PUT	| `sale/{id}`	| Atualiza venda existente
| DELETE	| `sale/{id}`	| Exclui venda pelo ID
| POST	| `sale/realizar`	| Realiza uma venda e ajusta o estoque automaticamente

**Exemplo JSON para cadastrar clientes:**
```
json
{
  "name": "Heitor",
  "cpf": 000.000.000-00,
  "email": heitor@gmail.com
}
````

**Exemplo JSON para cadastrar funcionários:**
```
json
{
  "name": "Heitor",
  "cpf": 000.000.000-00,
  "email": heitor@gmail.com
}
````

**Exemplo JSON para cadastrar produto:**
```
json
{
  "name": "Notebook",
  "quantity": 10,
  "price": 3500.0,
  "active": true
}
````

**Exemplo JSON para cadastrar vendas:**
```
json
{
  "clientId": 1,
  "productId": 2,
  "employeeId": 1,
  "quantity": 3
}
```

## 💻 Como Executar o Projeto
### Pré-requisitos:

Java 17+

Maven 3.8+

IDE (IntelliJ, VS Code, Eclipse, etc.)

### Passos:

#### Clone o repositório: 

git clone https://github.com/heitorffvieira/controle-estoque.git


#### Entre na pasta:

cd controle-estoque


#### Execute o projeto:

mvn spring-boot:run


#### Acesse no navegador ou via Postman/Insomnia:

http://localhost:8080
