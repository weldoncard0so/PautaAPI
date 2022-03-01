# pautaAPI
 API criada para o desafio da sicredi
  ````
   API criada com Spring Web.
  ````


# Pré-Requisitos
 ### Maven
 
 ### Docker
 
 ### Docker-compose
 
 ### Java 11
 
 
 
# Executar testes automatizados:

````
mvn test -P dev
````
### Empacotar dependencias
```
mvn package -DskipTests
``` 
### Construir imagem
```
docker build -t desafio-pauta .
``` 
### Subir stack
```
docker-compose -f docker-compose.yml up -d
```

# Swagger

http://localhost:8080/swagger-ui/


# Versionamento:
###Atenção no parâmetro no header da requisição :

```
Api-Version = 1
```

### Cadastrar Pauta

```
POST http://localhost:8080/pautas

{
  "titulo": "titulo da pauta"
}
``` 

### Abrir Sessão

```
POST http://localhost:8080/pautas/abrir

{
    "id_pauta": 1,
    "minutos": 4
}

OU

{
    "id_pauta": 1,
}
```
### Votar em uma pauta
```
POST http://localhost:8080/votos

{
    "id_pauta": 1,
    "id_cooperado": 1,
    "cpf": "43980567001",
    "voto": "Sim"
}
``` 

### Consultar resultado da pauta
```
GET http://localhost:8080/resultados/{id}
```
