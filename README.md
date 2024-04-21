참고 페이지 : https://changhyunit.tistory.com/107

implementation 'org.keycloak:keycloak-spring-boot-starter:17.0.1'
implementation 'org.keycloak.bom:keycloak-adapter-bom:17.0.1'

두 의존성을 사용하여 spring boot 와 keycloak 연동 합니다.

spring boot : 2.7.1
keycloak : 17.0.0


postman
```
{
	"info": {
		"_postman_id": "89cb5193-5efd-46d1-8789-4db6578e2e40",
		"name": "keycloak",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "11394527"
	},
	"item": [
		{
			"name": "http://localhost:8080/realms/hello-realm/protocol/openid-connect/token",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "urlencoded",
					"urlencoded": [
						{
							"key": "client_id",
							"value": "hello-client",
							"type": "text"
						},
						{
							"key": "client_secret",
							"value": "AD22aVZUgWXipSAT4EsuL1D8Ju3zc0Zp",
							"type": "text"
						},
						{
							"key": "username",
							"value": "user-1",
							"type": "text"
						},
						{
							"key": "password",
							"value": "test",
							"type": "text"
						},
						{
							"key": "grant_type",
							"value": "password",
							"type": "text"
						}
					]
				},
				"url": {
					"raw": "http://localhost:8080/realms/hello-realm/protocol/openid-connect/token",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"realms",
						"hello-realm",
						"protocol",
						"openid-connect",
						"token"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8081/test/admin",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Authorization",
						"value": "bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJQcFdqY1ZkSUpKQ0FwbUxXRVZHZHpBZmNEMm5qajZaYW1FZF9tZ0pkOGFNIn0.eyJleHAiOjE3MTM2Nzk5NzAsImlhdCI6MTcxMzY3OTY3MCwianRpIjoiNmJlODAzZTItZmE1OC00YTEyLWJjZjktMzQyZTg5NzUyODNhIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy9oZWxsby1yZWFsbSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI1ZGQzZjZiOS03NGJkLTQ0YWUtOWY4ZC0xNmFmNDhlZWNmMDciLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJoZWxsby1jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiY2Q2YjlhMTctYTY5YS00YzdiLTllNTEtOTBhZDYyZmQ4YTMwIiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJvZmZsaW5lX2FjY2VzcyIsImRlZmF1bHQtcm9sZXMtaGVsbG8tcmVhbG0iLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImhlbGxvLWNsaWVudCI6eyJyb2xlcyI6WyJVU0VSIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJjZDZiOWExNy1hNjlhLTRjN2ItOWU1MS05MGFkNjJmZDhhMzAiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6InVzZXItMSJ9.C-yz8XBJvhlzXwwUqDuZ4eVd8TzHf_-HLWVoC4Uth8RtmDVc6fbNX-CxIIncgMeSHUR0WiRw8JzQ6Ag2ow0-bw6Osw6S8RjgyVpBjuqMzUDKVUNz6xNnjf5ozc5dhkiFpokD4ti93CgJ_nHXHjPqyWDiZHter4XwuJhnsXELajcJwCODTtZYPaeRP4P7CPv_4lVOrdO81MuRMQHhBaxb4v71lbUbIQfbKBp-pfhVEhfCzr8z2yVpogL6Xnh5WR6B0j-EG3tBgkj1sj8LtGtoy-puuOVr805l27seZApFo7qlPBBjI6W97xmaDqzYy9ZTVplMAIfk5aFaLRTLIlLw-g",
						"type": "text"
					}
				],
				"url": {
					"raw": "http://localhost:8081/test/admin",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8081",
					"path": [
						"test",
						"admin"
					]
				}
			},
			"response": []
		}
	]
}
```
