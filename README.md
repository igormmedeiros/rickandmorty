# Rick and Morty Java Project

Este projeto é um exemplo de uma aplicação Java que consome a API do Rick and Morty.

site: https://rickandmortyapi.com/ 
## Funcionalidades

- Listar personagens com paginação.
- Buscar um personagem pelo nome.
- Implementação de caching com TTL de 60 segundos.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Feign Client**
- **Caffeine**
- **Lombok**

## Endpoints

- `GET /personagens?page={n}`: Retorna uma lista de personagens com paginação.
- `GET /personagens?name={nome}`: Busca um personagem pelo nome.