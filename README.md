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

### Update (PUT)
- endpoint -```/api/v1/users/update/{id}```

### Delete  (DELETE)
- endpoint -```/api/v1/users/delete/{id}```

### Get (GET)
- endpoint - ```/api/v1/users/find/{id}```

### Search (GET)
- endpoint -```/api/v1/users/search/{name}```

### login (GET)
- endpoint -```/api/v1/users/login?username={{username}}&password={{password}}```

### All (GET)
- endpoint -```/api/v1/users```

## Profile
### Add (POST)
- endpoint -```/api/v1/profiles/save```


### Update (PUT)
- endpoint -```/api/v1/profiles/update/{id}```

### Delete  (DELETE)
- endpoint -```/api/v1/profiles/delete/{id}```

### Get (GET)
- endpoint - ```/api/v1/profiles/find/{id}```

### Search (GET)
- endpoint -```/api/v1/profiles/search/{name}```

## Transactions
### Add (POST)
- endpoint -```/api/v1/transactions/save```


### Update (PUT)
- endpoint -```/api/v1/transactions/update/{id}```

### Delete  (DELETE)
- endpoint -```/api/v1/transactions/delete/{id}```

### Get (GET)
- endpoint - ```/api/v1/transactions/find/{id}```

### Search (GET)
- endpoint -```/api/v1/transactions/search/{name}```
