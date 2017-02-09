# EmployeeManagement

Request
-------

```
curl -X POST -H "X-Requested-With: XMLHttpRequest"
     -H "Content-Type: application/json"
     -H "Cache-Control: no-cache"
     -d '{
        "username": "gurkan@gmail.com",
        "password": "test1234"
        }' "http://localhost:9966/api/auth/login"
```

Response
-------

```
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsInNjb3BlcyI6WyJST0xFX0FETUlOIiwiUk9MRV9QUkVNSVVNX01FTUJFUiJdLCJpc3MiOiJodHRwOi8vZ3Vya2FuLmNvbSIsImlhdCI6MTQ4NjY0NzM5MCwiZXhwIjoxNDg2NjQ4MjkwfQ.DK-9stSQKEwgeVM4xQflqz4knyR1sfBsS4ylGqwbLYfPHV3ZtK4cJtvWFHbSKTTjzVuKUFYuGAtX8yzhD7z5xg",
    "refreshToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsInNjb3BlcyI6WyJST0xFX1JFRlJFU0hfVE9LRU4iXSwiaXNzIjoiaHR0cDovL2d1cmthbi5jb20iLCJqdGkiOiIyYTU0YjVkMS1kMWYzLTRkZDItYTY0Yi01MGE2MGY2NjBjMWUiLCJpYXQiOjE0ODY2NDczOTAsImV4cCI6MTQ4NjY1MDk5MH0.sf6-I7vYM_QC74Pm7KACBAEV-9WSv32pUU11d9L4SYUDI_sbIbhiOFmP1nyXfupxZAVw5-M2r4uV-YjMo4VKQg"
}
```

request with token
--------------
```
curl -X GET
     -H "X-Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsInNjb3BlcyI6WyJST0xFX0FETUlOIiwiUk9MRV9QUkVNSVVNX01FTUJFUiJdLCJpc3MiOiJodHRwOi8vZ3Vya2FuLmNvbSIsImlhdCI6MTQ4NjY0NzM5MCwiZXhwIjoxNDg2NjQ4MjkwfQ.DK-9stSQKEwgeVM4xQflqz4knyR1sfBsS4ylGqwbLYfPHV3ZtK4cJtvWFHbSKTTjzVuKUFYuGAtX8yzhD7z5xg"
     -H "Cache-Control: no-cache" "http://localhost:9966/api/me"
```