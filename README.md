# 📞 Controle de Contatos - API Rest

## 📌 Descrição do Projeto

Controle de Contatos é uma aplicação desenvolvida em Java utilizando o framework Spring Boot. O objetivo do projeto é fornecer uma API para gerenciar o cadastro de Pessoas e seus respectivos Contatos.

## 🚀 Tecnologias Utilizadas

🟡 **Java** (Spring Boot 3.4.2)🟢 **JPA/Hibernate** (para persistência de dados)🔵 **Banco de Dados** ( H2)🟠 **Swagger/OpenAPI** (para documentação da API)

## ⚙️ Funcionalidades Implementadas

✅ **Cadastro de Pessoas**✅ **Cadastro de Contatos**🔎 **Busca de Pessoas e Contatos**✏️ **Atualização de Informações**❌ **Exclusão de Registros**

## 🏛️ Modelagem do Banco de Dados

### 🧑 Pessoa

- **🆔 ID** (Identificador único, não pode ser nulo)
- **📛 Nome** (Obrigatório)
- **🏠 Endereço, 📍 CEP, 🌆 Cidade, 🏛 UF** (Opcional)

### 📞 Contato

- **🆔 ID** (Identificador único, não pode ser nulo)
- **📱 Tipo de Contato** (0 = Telefone, 1 = Celular)
- **📩 Contato** (Obrigatório)
- **🔗 Relacionamento** (Uma Pessoa pode ter vários Contatos - @OneToMany e @ManyToOne)

## 🔗 Endpoints da API

### 🧑 Pessoa

- **➕ POST** `/api/pessoas` - Criar uma nova Pessoa
- **📌 GET** `/api/pessoas/{id}` - Obter os dados de uma Pessoa por ID
- **📬 GET** `/api/pessoas/maladireta/{id}` - Obter dados de mala direta (usando DTO)
- **📋 GET** `/api/pessoas` - Listar todas as Pessoas
- **✏️ PUT** `/api/pessoas/{id}` - Atualizar uma Pessoa
- **❌ DELETE** `/api/pessoas/{id}` - Remover uma Pessoa

### 📞 Contato

- **➕ POST** `/api/contatos/` - Adicionar um novo Contato
- **📌 GET** `/api/contatos/{id}` - Obter Contato por ID
- **📋 GET** `/api/contatos/pessoa/{idPessoa}` - Listar todos os Contatos de uma Pessoa
- **✏️ PUT** `/api/contatos/{id}` - Atualizar um Contato
- **❌ DELETE** `/api/contatos/{id}` - Remover um Contato

## 🛠 Como Executar o Projeto

### 1️⃣ Configurar o Banco de Dados

O projeto suporta MySQL, MariaDB, PostgreSQL ou H2. Configure a conexão no arquivo `application.properties`:

```properties
spring.h2.console.enabled:true
spring.h2.console.path:/h2-console
spring.jpa.database-platform:org.hibernate.dialect.H2Dialect
spring.jpa.show-sql:true
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:h2:mem:pessoas
spring.datasource.username=sa
spring.datasource.password=
```

### 2️⃣ Rodar a Aplicação

```sh
mvn spring-boot:run
```

Ou, se estiver usando um IDE como IntelliJ ou Eclipse, rode a classe principal com `main`.

### 3️⃣ Acessar a Documentação da API

Após iniciar a aplicação, acesse:

```
http://localhost:8084/swagger-ui.html
```

## 🤝 Contribuição

1. 📌 Faça um Fork do projeto.
2. 🌿 Crie uma Branch (`git checkout -b feature/sua-feature`).
3. 💾 Faça Commit das suas alterações (`git commit -m 'Adiciona nova funcionalidade'`).
4. 🚀 Faça Push para a Branch (`git push origin feature/sua-feature`).
5. 🔄 Abra um Pull Request.

## 👨‍💻 Autor

Desenvolvido por Karina Gabriella de Marins.

---

📝 Este README serve como guia para configurar, rodar e entender a API de Controle de Contatos.
