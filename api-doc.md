# Api Documentation

## /api/auth/login

#### header

> **Content-Type** : application/json

> **X-Requested-With** : XMLHttpRequest

#### json data
```
{
    "username": [username],
    "password": [password]
}
```
#### response
```
{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsInNjb3BlcyI6WyJST0xFX0FETUlOIiwiUk9MRV9QUkVNSVVNX01FTUJFUiJdLCJpc3MiOiJodHRwOi8vZ3Vya2FuLmNvbSIsImlhdCI6MTQ4NjY1MDgzNSwiZXhwIjoxNDg2NjUxNzM1fQ.WhmTlFX2HDPMgFZ-Ug2TDYn9NTNPIqTT02q-L42fisCatYl3R4ChhfOti7ap5m-DC8R1HVK8gVQB0KTE4ksAkw",
  "refreshToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsInNjb3BlcyI6WyJST0xFX1JFRlJFU0hfVE9LRU4iXSwiaXNzIjoiaHR0cDovL2d1cmthbi5jb20iLCJqdGkiOiJkZTkxYzk3ZS04NDgwLTQzYjQtYmI4MC1lNmYxNmJiMWExNDUiLCJpYXQiOjE0ODY2NTA4MzUsImV4cCI6MTQ4NjY1NDQzNX0.1WgWVBKc0JAZ68dyLZkES30EOhgXTdOLhUf8DQHPHMjUVw8z3C3Y0vJweaEW9DVON-8pnMHc-kvoon8fSZ-F-Q"
}
```
--------

## /api/me

#### header
> **X-Authorization** : Bearer [token]

#### response
```
{
  "username": "test@gmail.com",
  "authorities": [
    {
      "authority": "ROLE_ADMIN"
    },
    {
      "authority": "ROLE_PREMIUM_MEMBER"
    }
  ]
}
```
------