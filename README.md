<h1 align="center">
  Place Service Api
</h1>

<p align="center">
 <a href="https://www.linkedin.com/in/erly-choqque-layme-449391208" target="_blank">
  <img src="https://img.shields.io/static/v1?label=LinkedIn&message=@erlychoqquelayme&color=0A66C2&labelColor=000000" alt="@erlychoqquelayme" />
 </a>
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=0A66C2&labelColor=000000" alt="Desafio" />
</p>

API para gerenciar lugares (CRUD), para pessoas desenvolvedoras backend que se candidatam para a ECHL.

O projeto foi desenvolvido virtualmente em tempo real.

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

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

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

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [postman](https://www.postman.com/):

- POST /places
```
http POST :8080/places 
{
  "name": "Lago Titica",
  "state": "Puno"
}

Status 201 created
Content-Length: 146
Content-Type: application/json

{
    "name":"Lago Titica",
    "slug":"lago-titica",
    "state":"Puno",
    "createdAt":"2025-10-31T20:31:25.973563337",
    "updatedAt":"2025-10-31T20:31:25.973563337"
}
```

- GET /places/{id}
```
http :8080/places/1

```

- GET /places?name=?
```
http :8080/places name==PLACE

```

- PATCH /places/{id}
```
http PATCH :8080/places/1 name='New Name' state='New State'

```