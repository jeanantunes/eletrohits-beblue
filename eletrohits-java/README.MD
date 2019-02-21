**Postman Collection:**

[Download Here](https://www.getpostman.com/collections/9bff005bc9a274782b2b)


Projetos eletrohits-java - Java with Spring Boot, H2 DataBase, Log4fj

**APPLICATION.PROPERTIES**
Altear para o classpath para localização do .json
```
file.list=/home/ubuntu/Documents/eletrohits-java/eletrohits-java/discos.json
```

**Discos**
```
PUT
localhost:8080/discos/save/{dados}
```
```
GET
localhost:8080/discos/list
```
```
POST
localhost:8080/discos/find/1
```
```
DELETE
localhost:8080/discos/delete/1
```

**Projeto eletrohits-node**
```
Acessar eletrohits-node/authorization_code
cd ~/eletrohits-node/authorization_code
node install
node app.js
```
Assim inicializamos o projeto node em http://localhost:8888.
Após acessar via o browser de sua preferência efetue loggin via api Spotify.
Testes de PUT, POST, GET e DELETE via Postman


