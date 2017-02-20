# Api Documentation

## /api/auth/login      [POST]

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

## /api/me      [GET]

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

## /api/user [POST]

#### header
> **X-Authorization** : Bearer [token]

#### body       
require
> **username** : [username]

> **password** : [password]

optional
> **price** : [price]

> **weeklyWorkingHours** : [weeklyWorkingHours]

#### response
```
{
  "id": 4,
  "username": "gurkan1",
  "password": "test",
  "price": 2400,
  "weeklyWorkingHours": 0,
  "roles": null,
  "tasks": null
}
```
--------

## /api/user [GET]

#### header
> **X-Authorization** : Bearer [token]

#### body       
require
> **username** : [username]


#### response
```
{
  "id": 1,
  "username": "test@gmail.com",
  "password": "$2a$10$bnC26zz//2cavYoSCrlHdecWF8tkGfPodlHcYwlACBBwJvcEf0p2G",
  "price": 0,
  "weeklyWorkingHours": 0,
  "roles": [
    {
      "role": "ADMIN"
    },
    {
      "role": "PREMIUM_MEMBER"
    }
  ],
  "tasks": []
}
```
--------

## /api/user [DELETE]

#### header
> **X-Authorization** : Bearer [token]

#### body       
require
> **username** : [username]


#### response
```
{
  "id": null,
  "username": null,
  "password": null,
  "price": 0,
  "weeklyWorkingHours": 0,
  "roles": null,
  "tasks": null
}
```
--------