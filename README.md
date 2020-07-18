# RESTful API

```
$ curl http://localhost:8080/currency/latest | jq
```

```
$ curl http://localhost:8080/currency/latest?base=EUR | jq
```

```
$ curl http://localhost:8080/currency/2020-07-18?base=EUR | jq
```

```
$ curl http://localhost:8080/currency/100/USD/to/EUR | jq
```

```
$ curl http://localhost:8080/currency/new --header "Content-Type: application/json" --request POST --data '{"base": "USD","date": "2016-09-22","rates": [{"code": "EUR","rate": 0.88857},{"code": "JPY","rate": 102.17},{"code": "MXN","rate": 19.232},{"code": "GBP","rate": 0.75705}]}' | jq
```