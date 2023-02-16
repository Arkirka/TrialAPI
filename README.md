# Trial task - Quote API
Java Spring Boot REST API for trial task.  

# Methods description
## GET methods
```
GET /api/quotes
```
returns a list of all quotes as a list of Quote objects


```
GET /api/quotes/top
 ```
returns a list of the best quotes as a list of Quote objects
```
GET /api/quotes/worst
```
returns a list of the worst quotes as a list of Quote objects
```
GET /api/quotes/random
```
returns a random quote as a Quote object
```
GET /api/quotes/{id}
```
returns the quote with the specified ID as a Quote object

## POST methods
```
POST /api/quotes
```
creates a new quote with the specified content and returns its ID
 * Example:
 ```json
{
  "content": "This is a new quote"
}
```
```
POST /api/users
```
creates a new user and returns its ID
 * Example:
 ```json
{
  "id": 1,
  "name": "John",
  "password": "password",
  "email": "john@example.com"
}
```

## PUT methods
```
PUT /api/quotes/{id}
```
updates the content of the quote with the specified id to the specified content
 * Example:
 ```json
 
"This is the updated quote"

```
```
PUT /api/quotes/1/upvote
```
increases the rating by 1 for the quote with the specified id from the specified user
 * Example:
 ```json
{
  "id": 1,
  "name": "John",
  "password": "password",
  "email": "john@example.com"
}
```
```
PUT /api/quotes/1/downvote
```
decrements the rating by 1 for a quote with the specified id from the specified user
 * Example:
 ```json
{
  "id": 1,
  "name": "John",
  "password": "password",
  "email": "john@example.com"
}
```

## DELETE methods
```
DELETE /api/quotes/1
```
removes quote with specified id
