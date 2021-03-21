**Projeto Cobranca**

Para criar base dados execute no Docker:

ˋˋˋ
docker run -p 5432:5432 --name cobranca -e POSTGRES_PASSWORD=postgres -d postgres

docker exec -it cobranca psql -U postgres -w postgres  -c "CREATE DATABASE cobranca;"

docker cp "pendencia_financeira.sql" cobranca:/

docker exec -it cobranca bash

psql -U postgres -d cobranca -f pendencia_financeira.sql;

ˋˋˋ

Para gerar um Bearer para chamadas na aplicação, execute a classe JwtGeneratorTest.java como JUNIT.
Após executar a classe copie do Console o Json Web Token gerado.

Para realizar chamadas deve adicionado o Header Authorization : Bearer + { JWT Gerado Acima } 
