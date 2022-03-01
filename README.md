# pautaAPI
 API criada para o desafio da sicredi
  ````
   API criada com Spring Web.
  ````


# Pré-Requisitos
 ### Maven
 
 ### Docker
 
 ### Java 11
 
 
# Executar testes automatizados:

````
mvn test -P dev
````
### Empacotar dependencias
```
mvn package -DskipTests
``` 

# Swagger

http://localhost:8080/swagger-ui/


### Cadastrar Pauta

```
POST http://localhost:8080/pautas

{
  "titulo": "titulo da pauta"
}
``` 

### Abrir sessão de pauta

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

Definido para 1 minuto por default
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

### Consultar resultado da pauta por ID
```
GET http://localhost:8080/resultados/{id}
```
