# Sistema de Controle de Estoque

Projeto simples de **controle de estoque** desenvolvido com **Java** e **Spring Boot**. O sistema permite criar, editar, listar e apagar itens das entidades principais: **Clientes**, **Produtos**, **Vendas** e **Funcionários**. Os dados são persistidos em memória usando a integração JPA do Spring Boot (H2 ou implementação em memória equivalente).

---

## Funcionalidades

* CRUD completo (Create, Read, Update, Delete) para as entidades:

  * `Clientes`
  * `Produtos`
  * `Vendas`
  * `Funcionários`
* Listar todos e buscar por `id` para cada entidade
* Armazenamento em memória via JPA (dados voláteis — perdidos ao reiniciar a aplicação)

---

## Tecnologias

* Java (11+ recomendado)
* Spring Boot (Web, Data JPA)
* H2 Database (modo em memória) — pode ser substituído por outro banco
* Maven (ou Gradle)

---

## Requisitos

* JDK 11 ou superior
* Maven 3.6+ (ou Gradle)
* IDE de sua preferência (IntelliJ, VSCode, Eclipse)

---

## Como executar

1. Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
cd <NOME_DO_PROJETO>
```

2. Build e execução (Maven):

```bash
./mvnw clean package
./mvnw spring-boot:run
```

ou

```bash
mvn clean package
java -jar target/*.jar
```

3. A aplicação roda por padrão em `http://localhost:8080`.

> Observação: por padrão o projeto usa armazenamento em memória (H2). Todos os dados serão perdidos quando a aplicação for interrompida.

---

## Endpoints (exemplo REST)

Os endpoints seguem um padrão REST simples. Substitua `:id` pelo identificador do recurso.

### Clientes

* `GET /clientes` — listar todos
* `GET /clientes/{id}` — buscar por id
* `POST /clientes` — criar (body: JSON)
* `PUT /clientes/{id}` — atualizar
* `DELETE /clientes/{id}` — deletar

### Produtos

* `GET /produtos`
* `GET /produtos/{id}`
* `POST /produtos`
* `PUT /produtos/{id}`
* `DELETE /produtos/{id}`

### Vendas

* `GET /vendas`
* `GET /vendas/{id}`
* `POST /vendas`
* `PUT /vendas/{id}`
* `DELETE /vendas/{id}`

> Observação: dependendo da modelagem, a entidade `Venda` pode referenciar `Cliente` e itens de `Produto` (quantidade, preço unitário).

---

## Exemplos de body (JSON)

Cliente:

```json
{
  "name": "João Silva",
  "cpf": "000.000.000-00",
  "email": "joao@example.com"
}
```

Produto:

```json
{
  "name": "Teclado Mecânico",
  "price": 199.90,
  "quantity": 10
}
```

Venda (exemplo simplificado):

```json
{
  "clienteId": 1,
  "itens": [
    { "produtoId": 2, "quantidade": 1 },
    { "produtoId": 3, "quantidade": 2 }
  ]
}
```

Funcionário:

```json
{
  "name": "Maria Souza",
  "cpf": "000.000.000-00",
  "email": "maria@example.com"
}
```

---

## Observações sobre persistência

* O projeto está configurado para usar um banco em memória (H2) via Spring Data JPA — ideal para desenvolvimento e testes rápidos.
* Para persistência permanente, altere as configurações em `application.properties`/`application.yml` para conectar a um banco externo (MySQL, PostgreSQL, etc.) e ajuste as dependências.

---

## Testes

* Adicione testes unitários (JUnit + Mockito) para Services e Controllers.
* Recomenda-se testes de integração com `@SpringBootTest` e banco H2 configurado.

---

## Estrutura sugerida do projeto

```
src/
 ├─ main/
 │   ├─ java/
 │   │  └─ com.exemplo.controleestoque/
 │   │     ├─ controller/
 │   │     ├─ service/
 │   │     ├─ model/
 │   │     └─ repository/
 │   └─ resources/
 │      └─ application.properties
 └─ test/
```

---

## Como contribuir

1. Fork o repositório
2. Crie uma branch feature/x
3. Faça commits claros e pequenos
4. Abra um Pull Request descrevendo as mudanças

---

## Licença

Projeto licenciado como **MIT**. Sinta-se livre para usar, modificar e distribuir.

---

## Contato

Se precisar de ajuda com a configuração ou quiser melhorias, abra uma issue ou entre em contato via e-mail.
