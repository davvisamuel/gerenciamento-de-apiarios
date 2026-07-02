# Gerenciamento de Apiario

API REST para gerenciamento de apiarios, colmeias, rainhas e inspecoes apicolas.

## Requisitos

- Java 21
- Docker e Docker Compose
- Git Bash, PowerShell ou terminal equivalente

O projeto ja inclui Maven Wrapper, entao nao e necessario instalar o Maven separadamente.

## Como executar

1. Acesse a pasta do projeto:

```bash
cd gerenciamento-de-apiario
```

2. Suba o banco de dados PostgreSQL:

```bash
docker compose up -d
```

O banco sera iniciado com as seguintes configuracoes:

```text
host: localhost
porta: 5432
banco: gerenciamento_de_apiario
usuario: user
senha: password
```

3. Execute a aplicacao:

No Windows:

```bash
.\mvnw.cmd spring-boot:run
```

No Linux/macOS:

```bash
./mvnw spring-boot:run
```

4. Acesse a API em:

```text
http://localhost:8080
```

A documentacao Swagger fica disponivel em:

```text
http://localhost:8080/swagger-ui.html
```

## Testando a autenticacao

Crie um usuario:

```bash
curl -X POST http://localhost:8080/v1/auth/register \
  -H "Content-Type: application/json" \
  -d "{\"username\":\"admin\",\"password\":\"123456\"}"
```

Faca login para obter o token JWT:

```bash
curl -X POST http://localhost:8080/v1/auth/login \
  -H "Content-Type: application/json" \
  -d "{\"username\":\"admin\",\"password\":\"123456\"}"
```

Use o token retornado nas demais rotas protegidas:

```text
Authorization: Bearer SEU_TOKEN
```

## Comandos uteis

Executar os testes:

```bash
.\mvnw.cmd test
```

Gerar o pacote da aplicacao:

```bash
.\mvnw.cmd clean package
```

Parar o banco de dados:

```bash
docker compose down
```

Parar o banco e remover o volume de dados:

```bash
docker compose down -v
```

## Configuracoes principais

As configuracoes da aplicacao ficam em:

```text
src/main/resources/application.yaml
```

Por padrao, a aplicacao usa:

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/gerenciamento_de_apiario
    username: user
    password: password
```
