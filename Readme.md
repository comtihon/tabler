# Tabler  [![Build Status](https://travis-ci.org/comtihon/tabler.svg?branch=master)](https://travis-ci.org/comtihon/tabler)
Table admin. Service for creation tables.
In future can be extended to group tables by restaurants, set open hours
and other configuration.
Was moved to separate microsrvice to split system API (table creation) and
user API (table reservation).

### In docker

    sudo ./gradlew build docker -x test -x test_integration
    sudo docker run -p 8080:8080 -t tabler/admin

### In OS

    ./gradlew bootRun

## Testing

    ./gradlew check

## Protocol
### Create a table

Endpoint: `/api/v1/table`

#### Request

Method: `POST`

Body:

```
{
  "name": "Table with a view to the mountains"
}
```

#### Response

Body:
```
{
  "id": 0
}
```
