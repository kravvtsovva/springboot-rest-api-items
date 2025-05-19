# Spring Boot Items API

Простой REST API, созданный с помощью Spring Boot. Проект реализует базовые CRUD-операции (создание, чтение, обновление, удаление) для элементов коллекции "items".

## Функциональность

Приложение предоставляет 8 REST-эндпоинтов:

### GET-запросы
- `GET /api/items` — получить список всех элементов
- `GET /api/items/{id}` — получить элемент по ID

### POST-запросы
- `POST /api/items?id={id}` — добавить новый элемент (имя в теле запроса)
- `POST /api/items/safe?id={id}` — добавить элемент с проверкой имени (не допускает пустые строки)

### PUT-запросы
- `PUT /api/items/{id}` — полностью обновить имя по ID
- `PUT /api/items/{id}/partial` — частично обновить имя (добавляет " (updated)")

### DELETE-запросы
- `DELETE /api/items/{id}` — удалить элемент по ID
- `DELETE /api/items` — удалить все элементы


## Технологии

- Java 17+
- Spring Boot
- Spring Web
- Gradle
- Postman (для тестирования API)
