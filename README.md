# 👥 Users

This project is a users rest api 

## Technologies
- Spring Boot
- Maven
- Java

## API
This API base URL is https://users-restfull.herokuapp.com/ and can be used to access the following endpoints :

## User
### Add (POST)
- endpoint -```/api/v1/users/save```
#### json
{
    "id":1,
		"name": "John Cena",
		"username": "Jhon",
		"email": "john.cena@gmail.com",
		"password": "12345",
		"profileId": 1,
		"language": "ENGLISH"
}

### Update (PUT)
- endpoint -```/api/v1/users/update/{id}```
#### json
{
    "id":11,
		"name": "Jim Carry",
		"username": "JC",
		"email": "jim.carry@gmail.com",
		"password": "12345",
		"profileId": 1,
		"language": "ENGLISH"
}

### Delete  (DELETE)
- endpoint -```/api/v1/users/delete/{id}```

### Get (GET)
- endpoint - ```/api/v1/users/find/{id}```
#### json
{
  "id": 21,
  "name": "Daniela Ruah",
	"username": "Daniela",
	"email": "daniela.ruah@gmail.com",
  "profile": {
      "id": 1,
      "description": "Administrador",
      "descriptionEN": "Administrator",
      "active": true
  },
  "language": "PORTUGUESE",
  "active": true
 }

### Search (GET)
- endpoint -```/api/v1/users/search/{name}```
#### json
{
  "id": 21,
  "name": "Daniela Ruah",
	"username": "Daniela",
	"email": "daniela.ruah@gmail.com",
  "profile": {
      "id": 1,
      "description": "Administrador",
      "descriptionEN": "Administrator",
      "active": true
  },
  "language": "PORTUGUESE",
  "active": true
 }

### login (GET)
- endpoint -```/api/v1/users/login?username={{username}}&password={{password}}```

### All (GET)
- endpoint -```/api/v1/users```

#### json
[{
  "id": 1,
  "name": "John Cena",
	"username": "Jhon",
	"email": "john.cena@gmail.com",
  "profile": {
      "id": 1,
      "description": "Administrador",
      "descriptionEN": "Administrator",
      "active": true
  },
  "language": "ENGLISH",
  "active": true
 },
 {
  "id": 11,
  "name": "Jim Carry",
	"username": "JC",
	"email": "jim.carry@gmail.com",
  "profile": {
      "id": 1,
      "description": "Administrador",
      "descriptionEN": "Administrator",
      "active": true
   },
   "language": "ENGLISH",
   "active": true
  },
  {
  "id": 21,
  "name": "Daniela Ruah",
	"username": "Daniela",
	"email": "daniela.ruah@gmail.com",
  "profile": {
      "id": 1,
      "description": "Administrador",
      "descriptionEN": "Administrator",
      "active": true
  },
  "language": "PORTUGUESE",
  "active": true
 }
]

## Profile
### Add (POST)
- endpoint -```/api/v1/profiles/save```
#### json
{
    "id":1,
    "description":"Administrador",
    "descriptionEN":"Administrator",
    "transactionsId":[1, 11, 21]
}

### Update (PUT)
- endpoint -```/api/v1/profiles/update/{id}```
#### json
{
    "id":1,
    "description":"Administrador",
    "descriptionEN":"Administrator",
    "transactionsId":[1, 11, 21]
}


### Delete  (DELETE)
- endpoint -```/api/v1/profiles/delete/{id}```

### Get (GET)
- endpoint - ```/api/v1/profiles/find/{id}```
#### json
{
    "id":1,
    "description":"Administrador",
    "descriptionEN":"Administrator",
    "transactionsId":[1, 11, 21]
}

### Search (GET)
- endpoint -```/api/v1/profiles/search/{name}```
#### json
{
    "id":1,
    "description":"Administrador",
    "descriptionEN":"Administrator",
    "transactionsId":[1, 11, 21]
}

### All (GET)
- endpoint -```/api/v1/profiles```
#### json
[
{
    "id":1,
    "description":"Administrador",
    "descriptionEN":"Administrator",
    "transactionsId":[1, 11, 21]
}
]


## Transactions
### Add (POST)
- endpoint -```/api/v1/transactions/save```
#### json
{   
    "id":1,
    "description":"Ver transações",
    "descriptionEN":"View transactions"
}

### Update (PUT)
- endpoint -```/api/v1/transactions/update/{id}```
#### json
{      
    "id":1,
    "description":"Ver transações",
    "descriptionEN":"View transactions"
}

### Delete  (DELETE)
- endpoint -```/api/v1/transactions/delete/{id}```

### Get (GET)
- endpoint - ```/api/v1/transactions/find/{id}```
#### json
{      
    "id":1,
    "description":"Ver transações",
    "descriptionEN":"View transactions"
}


### Search (GET)
- endpoint -```/api/v1/transactions/search/{name}```
#### json
{      
    "id":1,
    "description":"Ver transações",
    "descriptionEN":"View transactions"
}

### All (GET)
- endpoint -```/api/v1/transactions```
#### json

[{
    "description":"Ver transações",
    "descriptionEN":"View transactions"
},
{
    "description":"Criar transação",
    "descriptionEN":"Create transaction"
},
{
    "description":"Actualizar transação",
    "descriptionEN":"Update transaction"
},
{
    "description":"Ver perfil",
    "descriptionEN":"View profile"
},
{
    "description":"Criar perfil",
    "descriptionEN":"Create profile"
},
{
    "description":"Actualizar perfil",
    "descriptionEN":"Update profile"
},
{
    "description":"Ver utilizador",
    "descriptionEN":"View user"
},
{
    "description":"Criar utilizador",
    "descriptionEN":"Create user"
},
{
    "description":"Actualizar utilizador",
    "descriptionEN":"Update User"
}]

