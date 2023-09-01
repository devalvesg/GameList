<h1 align="center">
  DSLIST Games
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Email&message=gabrieldamasceno881@outlook.com&color=8257E5&labelColor=000000" alt="gabrieldamasceno881@outlook.com" />
 <img src="https://img.shields.io/static/v1?label=Linkedin&message=Gabriel Alves&color=8257E5&labelColor=000000" alt="Gabriel Alves" />
</p>

API de uma lista de jogos (CRUD) que foi desenvolvida durante a imersão do canal DevSuperior e modificado pelo autor(Gabriel Alves).


## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Postgresql](https://www.postgresql.org/docs/)
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Docker](https://docs.docker.com/)

## Práticas adotadas

- SOLID
- Consultas com filtros dinâmicos usando o Query
- API RESTFUL
- Uso de DTOs para a API
- Injeção de Dependências
- Auditoria sobre criação e atualização da entidade
- Consulta no Banco de dados com JPA

## Como Executar

### Localmente
- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Executar:
```
java -jar dsList/src/dsList-0.0.1-SNAPSHOT.jar
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
docker run --name ds-list -p 8080:8080  -d dsList:0.0.1-SNAPSHOT
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/api-documentation-tool/):

- POST /games
```
http POST :8080/games

HTTP/1.1 200 OK
Content-Length: 129
Content-Type: application/json

body: 
    {
    "title": "...",
    "year": "...",
    "genre": "...",
    "platforms": "...",
    "score": ...,
    "imgUrl": "...",
    "shortDescription": "...",
    "longDescription" : "..."
    }

```

- GET http://localhost:8080/games
```
http :8080/games
HTTP/1.1 200 OK
Content-Length: 129
Content-Type: application/json

{
    "id": 1,
    "title": "Crash",
    "year": 1996,
    "imgUrl": "https://www.crashbandicoot.com/content/dam/atvi/Crash/crash-touchui/common/Crash-Bandicoot-Work-Page.png",
    "shortDescription": "Crash Bandicoot é uma franquia de videogame originalmente desenvolvida pela Naughty Dog como um exclusivo para o console PlayStation da Sony ."
} ...
```

- GET /games/{id}
```
http :8080/games/10
HTTP/1.1 200 OK
Content-Length: 129
Content-Type: application/json

{
    "id": 10,
    "title": "Cuphead",
    "year": 2017,
    "genre": "Platform",
    "platforms": "XBox, Playstation, PC",
    "score": 4.6,
    "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/9.png",
    "shortDescription": "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!",
    "longDescription": "Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa."
}

```

- PUT http://localhost:8080/games/10
```
http PUT : http://localhost:8080/games/10
HTTP/1.1 200 OK
Content-Length: 142
Content-Type: application/json
Body: 

{
    "score": 4.1
}

```
