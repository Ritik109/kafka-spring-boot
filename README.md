# kafka-spring-boot

## Implemented dummy producer and consumer for kafka

```http
GET /produce
```
This endpoint will publish message passed in request body to topic provided in query parameter.

| Parameter | Type | Description |
| :--- | :--- | :--- |
| `topicName` | `string` | **Required**. Your Topic Name to publish message |

## Request
Below is the request body format:

```javascript
{
  "id" : int,
  "name" : string,
  "userName" : string,
  "password" : string
}
```

## Responses

| Status Code | Description |
| :--- | :--- |
| 200 | `OK` |
