# Quote API
Java Spring Boot REST API.  

# Methods description
## GET methods
### Get all quotes
```
GET /api/quotes
```
returns a list of all quotes as a list of Quote objects
### Get top 10 quotes
```
GET /api/quotes/top
 ```
returns a list of the top 10 best quotes as a list of Quote objects
### Get top 10 worst quotes
```
GET /api/quotes/worst
```
returns a list of the top 10 worst quotes as a list of Quote objects
### Get random quote
```
GET /api/quotes/random
```
returns a random quote as a Quote object
### Get quote by id
```
GET /api/quotes/{id}
```
returns the quote with the specified ID as a Quote object

## POST methods
### Create quote
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
### Create user
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
### Update quote
```
PUT /api/quotes/{id}
```
updates the content of the quote with the specified id to the specified content
 * Example:
 ```json
 
"This is the updated quote"

```
### Like quote
```
PUT /api/quotes/{id}/upvote
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
### Dislike quote
```
PUT /api/quotes/{id}/downvote
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
### Delete quote
```
DELETE /api/quotes/1
```
removes quote with specified id
