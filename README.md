### Projeto de Migração de Dados 

Este projeto é uma aplicação Spring Batch para migração de dados de duas tabelas (`pessoa` e `dados_bancarios`) a partir de arquivos CSV para um banco de dados PostgreSQL. A aplicação é configurada para se conectar a dois bancos de dados: um banco de dados do Spring Batch e um banco de dados da aplicação.
O projeto foi desenvolvido durante o curso [Curso para Desenvolvimento de Jobs com Spring Batch](https://www.udemy.com/course/curso-para-desenvolvimento-de-jobs-com-spring-batch/) na Udemy.

### Pré-requisitos

- Java 17 ou superior
- PostgreSQL 13 ou superior
- Maven 3.6 ou superior

### Configuração do Banco de Dados

1. **Criação das Tabelas**

   Execute os seguintes comandos SQL no banco de dados PostgreSQL para criar as tabelas necessárias:

   ```sql
   CREATE TABLE pessoa (
       id SERIAL PRIMARY KEY,
       nome VARCHAR(500) NOT NULL,
       email VARCHAR(500) NOT NULL,
       data_nascimento DATE NOT NULL,
       idade INT NOT NULL
   );

   CREATE TABLE dados_bancarios (
       id SERIAL PRIMARY KEY,
       pessoa_id INT REFERENCES pessoa(id),
       agencia INT NOT NULL,
       conta INT NOT NULL,
       banco INT NOT NULL
   );
   ```

2. **Arquivos CSV**

   Certifique-se de ter dois arquivos CSV contendo os dados de `pessoa` e `dados_bancarios`.

### Configuração da Aplicação

#### application.properties

Configure as propriedades da aplicação no arquivo `application.properties`:

```properties
spring.application.name=migracao-dados-job

# Configurações do banco de dados do Spring Batch
spring.datasource.jdbcUrl=jdbc:postgresql://localhost:5432/spring_batch
spring.datasource.username=postgres
spring.datasource.password=1234
spring.batch.jdbc.initialize-schema=always

# Configurações do banco de dados da aplicação
app.datasource.jdbcUrl=jdbc:postgresql://localhost:5432/migracao_dados
app.datasource.username=postgres
app.datasource.password=1234
```

### Como Executar

1. **Configurar o banco de dados:**

   Certifique-se de que o PostgreSQL está em execução e que as tabelas `pessoa` e `dados_bancarios` foram criadas conforme as instruções acima.

2. **Configurar as propriedades da aplicação:**

   Verifique se as configurações no `application.properties` estão corretas para a sua instalação do PostgreSQL.

3. **Executar a aplicação:**

   Use o Maven para compilar e executar a aplicação:
   ```sh
   mvn spring-boot:run
   ```

4. **Verificar a migração:**

   Após a execução bem-sucedida, verifique as tabelas no banco de dados para garantir que os dados foram migrados corretamente.
