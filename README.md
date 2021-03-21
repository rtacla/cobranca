**Projeto Cobranca**

Java 8 com Spring Boot
Frameworks:
  Lombok
  Spring Data
  Swagger


Para criar base dados execute no Docker:

```
docker run -p 5432:5432 --name cobranca -e POSTGRES_PASSWORD=postgres -d postgres

docker exec -it cobranca psql -U postgres -w postgres  -c "CREATE DATABASE cobranca;"

docker exec -it cobranca bash

psql -U postgres -d cobranca -f pendencia.sql;

```


