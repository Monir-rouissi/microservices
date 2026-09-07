# Spring Cloud Microservices

A small Spring Boot and Spring Cloud microservices project with an Order, Product, and Inventory service. Services register with Eureka and are exposed through Spring Cloud Gateway.

## Services

| Service | Port | Purpose |
| --- | ---: | --- |
| Registry | 8761 | Eureka service discovery |
| Config server | 8181 | Optional centralized configuration |
| Gateway | 8080 | API entry point |
| Product service | 8082 | Product catalog |
| Inventory service | 8084 | Inventory availability |
| Order service | 8087 | Order creation |
| Notification service | dynamic | Optional Kafka notification consumer |

## Requirements

- Java 25
- Maven 3.9+
- MySQL running on `localhost:3306` with a database named `order`
- PostgreSQL running on `localhost:5432` with a database named `micro`

The default local credentials are defined in each service's `application.properties`. Update them if your database uses different credentials.

Docker Compose currently starts Kafka and ZooKeeper only. For local development, use the PowerShell commands below to start the Java services and databases individually.

## Build

Open PowerShell in the repository root. On Windows with Java 25, clear `TEMP` and `TMP` for the Maven process to avoid the JDK temporary-directory networking issue:

```powershell
Remove-Item Env:TEMP -ErrorAction SilentlyContinue
Remove-Item Env:TMP -ErrorAction SilentlyContinue
mvn -B -DskipTests package
```

## Run locally

Start the services in this order, each in a separate PowerShell window:

```powershell
Remove-Item Env:TEMP -ErrorAction SilentlyContinue
Remove-Item Env:TMP -ErrorAction SilentlyContinue

cd registry
mvn spring-boot:run
```

```powershell
cd config-server
mvn spring-boot:run
```

```powershell
cd inventoryService
mvn spring-boot:run
```

```powershell
cd product-service
mvn spring-boot:run
```

```powershell
cd order-service
mvn spring-boot:run
```

```powershell
cd gateway/gateway
mvn spring-boot:run
```

Open the Eureka dashboard at [http://localhost:8761](http://localhost:8761). Once the services appear there, use the gateway at `http://localhost:8080`.

## Example requests

Check inventory through the gateway:

```powershell
Invoke-RestMethod 'http://localhost:8080/api/inventory?skuCode=Iphon1'
```

Create an order through the gateway:

```powershell
$body = @{
  orderLines = @(
    @{ skuCode = 'Iphon1'; price = 999.99; quantity = 1 }
  )
} | ConvertTo-Json -Depth 4

Invoke-RestMethod 'http://localhost:8080/api/order' -Method Post -ContentType 'application/json' -Body $body
```

## Kafka notifications

Kafka is optional for normal local development. Notifications are disabled by default so the Order service can run without Kafka. To enable them, start Kafka and set this environment variable before launching Order and Notification services:

```powershell
$env:APP_NOTIFICATIONS_ENABLED = 'true'
```

Run `docker compose up -d` only when you want the optional Kafka notification flow. It does not start the Java services or the databases.

## Notes

- Maven output is ignored through `.gitignore`; do not commit any `target/` directories or JAR files.
- The Config server uses environment-backed Git settings. Set `GIT_URI`, `GIT_USERNAME`, and `GIT_TOKEN` only when you need its external configuration repository.
