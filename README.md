<h1 align="center">
  Place Service Api
</h1>

<p align="center">
 <a href="https://www.linkedin.com/in/erly-choqque-layme-449391208" target="_blank">
  <img src="https://img.shields.io/static/v1?label=LinkedIn&message=@erlychoqquelayme&color=0A66C2&labelColor=000000" alt="@erlychoqquelayme" />
 </a>
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=0A66C2&labelColor=000000" alt="Desafio" />
</p>

API para gerenciar lugares (CRUD)

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Webflux](https://docs.spring.io/spring-framework/reference/web/webflux.html)
- [Spring Data + R2DBC](https://docs.spring.io/spring-framework/reference/data-access/r2dbc.html)
- [Slugify](https://github.com/slugify/slugify)

## Práticas adotadas

- SOLID
- Testes automatizados
- API reativa na web e na camada de banco
- Uso de DTOs para a API
- Injeção de Dependências
- Geração de slugs automática com o Slugify
- Auditoria sobre criação e atualização da entidade

## Como Executar

### Localmente
- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Executar:
```
java -jar place-service-api/target/place-service-api-0.0.1-SNAPSHOT.jar
```

### Usando Docker

- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Construir a imagem:
```
./mvnw spring-boot:build-image
```
- Executar o container:
```
docker run --name place-service-api -p 8080:8080  -d place-service-api:0.0.1-SNAPSHOT
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [postman](https://www.postman.com/):

- POST /places
```
http://localhost:8080/places
{
  "name": "Machu Picchu",
  "state": "Cusco"
}

Status 201 created
Content-Length: 146
Content-Type: application/json

{
  "name":"Machu Picchu",
  "slug":"machu-picchu",
  "state":"Cusco",
  "createdAt":"2025-11-24T15:54:22.713143",
  "updatedAt":"2025-11-24T15:54:22.713143"
}
```

- GET /places/{id}
```
http://localhost:8080/places/1

Status 200 Ok
Content-Type: application/json
Content-Length: 134

{
  "name":"Machu Picchu",
  "slug":"machu-picchu",
  "state":"Cusco",
  "createdAt":"2025-11-24T15:57:30.618235",
  "updatedAt":"2025-11-24T15:57:30.618235"
}

```

- GET /places?name=?
```
http://localhost:8080/places?name=Machu Picchu

Status 200 Ok
transfer-encoding: chunked
Content-Type: application/json

{
  "name":"Machu Picchu",
  "slug":"machu-picchu",
  "state":"Cusco",
  "createdAt":"2025-11-24T15:57:30.618235",
  "updatedAt":"2025-11-24T15:57:30.618235"
}

```

- PATCH /places/{id}
```
http://localhost:8080/places/1
{
  "name": "New Machu Picchu",
  "state": "New Cusco"
}

Status 200 Ok
Content-Type: application/json
Content-Length: 139

{
  "name":"New Machu Picchu",
  "slug":"new-machu-picchu",
  "state":"New Cusco",
  "createdAt":"2025-11-24T15:57:30.618235",
  "updatedAt":"2025-11-24T16:01:34.484393"
}

```