# Spring Boot Redis Cache Sample

## Docker Redis 

	*** Pull Image ***
	docker pull redis

	*** Run Image ***
	docker run -it -p 6379:6379 redis

	*** Attach to docker container ***
	docker exec -it <container_id> bash

	*** Commands to connect to redis-cli and monitor the logs ***
	1. redis-cli
	2. MONITOR

## Save Product
	URL: http://localhost:8080/product
	Method: POST
	Sample Payload:
	{
	    "name": "product3",
	    "code": "p3",
	    "quantity": "10",
	    "price": 100.0
	}
	Sample Response:
	{
	    "id": 3,
	    "name": "product3",
	    "code": "p3",
	    "quantity": 10,
	    "price": 100.0
	}

## Retrieve Product by ID
	URL: http://localhost:8080/product/<id>
	Method: GET
	Sample Response:
	{
	    "id": 3,
	    "name": "product3",
	    "code": "p3",
	    "quantity": 10,
	    "price": 100.0
	}

## Update Product
	URL: http://localhost:8080/product
	Method: POST
	Sample Payload:
	{
	    "id": 3,
	    "name": "product3",
	    "code": "p3",
	    "quantity": "15",
	    "price": 10000.0
	}
	Sample Response:
	{
	    "id": 3,
	    "name": "product3",
	    "code": "p3",
	    "quantity": 15,
	    "price": 10000.0
	}

## Delete Product by ID
	URL: http://localhost:8080/product/<id>
	Method: DELETE
	Sample Response: product with id: 3 deletion success.

