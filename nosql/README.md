# NoSQL

## Documento
* mongodb
* elasticsearch
* couchdb
* couch DB

## Grafos
* Neo4j
    * user and pwd neo4j
    * url (localhost:7687)
    * start learning
    * explicar nodes, relationships, properties (label)
    * Cypher (query language)
         CREATE (ee:Bairro { name: "Jardim Botânico", totalHabitantes: 200 })
         MATCH (ee:Bairro) return ee;
         CREATE (ee:Bairro { name: "Plano Piloto", totalHabitantes: 50000 })
         CREATE (ee:Bairro { name: "Luziânia", totalHabitantes: 100000 })
         MATCH (ee:Bairro) WHERE ee.name = "Jardim Botânico" RETURN ee;

        -- criando a relação 
         MATCH (ee:Bairro) WHERE ee.name = "Jardim Botânico"
         MATCH (pp:Bairro) WHERE pp.name = "Plano Piloto"
         CREATE (ee)-[:onibus {linhas: [780, 746]}]->(pp)
        
        -- criando a relação 
         MATCH (ee:Bairro) WHERE ee.name = "Jardim Botânico"
         MATCH (pp:Bairro) WHERE pp.name = "Plano Piloto"
         CREATE (ee)-[:metro {horarios: ["08:00", "10:00"]}]->(pp)
        
        -- criando a relação 
         MATCH (lz:Bairro) WHERE lz.name = "Luziânia"
         MATCH (pp:Bairro) WHERE pp.name = "Plano Piloto"
         CREATE (pp)-[:onibus {linhas: [7000, 7002]}]->(lz)
* DGraph

## Colunas
* cassandra
* apache hbase

## Chave/Valor
* Redis
* DynamoDB


