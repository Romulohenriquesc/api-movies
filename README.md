# Movies API Rest

# 🖥 what was developed?

An API was created that the [IMDb](https://www.imdb.com/) site that consults its content, these are the features developed:

- User(administrator)
    - Registration
    - Editing
    - Logical Exclusion (deactivation)
    - Listing of active non-admin users
        - Option to bring paged records
        - Return users alphabetically
- User(non-admin)
    - Registration
    - Editing
    - Logical Exclusion (deactivation)
- Movies
    - Registration
    - Evaluation - partial: because I haven't authenticated, I'm sending the user through the body
    - Listing
        - Option of filters by director, name, genre and/or actors
        - Option to get paged records
    - Movie Details by getting all the information about the movie, including average votes

**Obs.:** 
**Because it is not authenticated, the api allows any route to be accessed** 

🖥 Endpoints
base_url : localhost:8080

Actors
- Return all actors
- [GET]     base_url/actors
- Return an actor
- [GET]     base_url/actors/{id}
- Add an actor
- [POST]    base_url/actors
```json
{
    "name": "Leonardo DiCaprio"
}
```
Movies
- Return all movies
- [GET]     base_url/movies
Return a movie
- [GET]     base_url/movies/{id}
- Return all movies sorted by best rating
- [GET]     base_url/movies/rate
- Return the movies with the name, actors, genre and director filters
- [GET]     base_url/movies/search?search=example
- Add a movie
- [POST]    base_url/movies
```json
{
    "name": "A Origem 3",
    "genre": "Ação",
    "director": "Christopher Nolan",
    "description": "Dom Cobb é um ladrão com a rara habilidade de roubar segredos do inconsciente, obtidos durante o estado de sono.",
    "actors": [
      {
        "id": 2,
        "name": "Leonardo DiCaprio"
      }
    ]
}
```
- Update a movie
- [PUT]     base_url/movies/{id}
```json
{
    "name": "A Origem 2",
    "genre": "Ação",
    "director": "Christopher Nolan",
    "description": "Dom Cobb é um ladrão com a rara habilidade de roubar segredos do inconsciente, obtidos durante o estado de sono.",
    "actors": [
      {
        "id": 2,
        "name": "Outro Leonardo DiCaprio"
      }
    ]
}
```
- [DELETE]  base_url/movies/{id}
Users
- Return all users: Pagination and is optional (take, page) and orderName=asc for alphabetical order
- [GET]     base_url/users?orderName=asc&take=10&page=0
- Return an user
- [GET]     base_url/users/{id}
- Add a user
- [POST]    base_url/users
```json
{
	"name": "Romulo",
	"email": "romulo@gmail.com",
	"password": "romulo123",
	"admin": false
}	
```
- Update a user
- [PUT]     base_url/users/{id}
```json
{
	"name": "Romulo 2",
	"email": "romulo@gmail.com",
	"password": "romulo123",
	"admin": true
}	
```
- Delete a user (disable)
- [DELETE]  base_url/users/{id}
Evaluation
- Add an evaluation
- [POST]    base_url/evaluations
```json
{
	"movie": {
    "id": 1,
    "name": "A Origem 1",
    "genre": "Ação",
    "director": "Christopher Nolan",
    "description": "Dom Cobb é um ladrão com a rara habilidade de roubar segredos do inconsciente, obtidos durante o estado de sono.",
    "actors": [
      {
        "id": 2,
        "name": "Leonardo DiCaprio"
      }
    ],
    "evaluation": null
  },
	"user": {
    "id": 1,
    "name": "Romulo",
    "email": "romulocavalcante@gmail.com",
    "admin": false,
    "enabled": true
  },
	"grade": 4
}	
```
- Return all evaluations of a movie (id from movie)
- [GET]     base_url/evaluations/{id}

**Obs.:** 

**Because of time, it was not possible to implement some features or were commented:**
- **Java 8 or higher: OK**
- **Rest Pattern: OK**
- **MySQL: OK**
- **JWT: No**
- **Swagger: No**
- **Spring Data JPA & Hibernate: OK**
- **Flyway: No - You won't be able to run migrations but when running the API, JPA will create the database structure and populate it with information for testing**

**Obs.:** 
- **You need to define in the application.properties file the url, username and password of your MySQL database**
