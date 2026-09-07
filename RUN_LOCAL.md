# Run locally with Java 25

The project uses Java 25 from `JAVA_HOME`. Before starting a service in PowerShell, remove `TEMP` and `TMP` from that shell. The JDK otherwise fails to create NIO wake-up sockets in this environment.

```powershell
Remove-Item Env:TEMP,Env:TMP
mvn -B -DskipTests package
```

Start each command in its own PowerShell window, in this order:

```powershell
Remove-Item Env:TEMP,Env:TMP; mvn -pl registry spring-boot:run
Remove-Item Env:TEMP,Env:TMP; mvn -pl inventoryService spring-boot:run
Remove-Item Env:TEMP,Env:TMP; mvn -pl product-service spring-boot:run
Remove-Item Env:TEMP,Env:TMP; mvn -pl order-service spring-boot:run
Remove-Item Env:TEMP,Env:TMP; mvn -pl gateway/gateway spring-boot:run
```

MySQL database `order` and PostgreSQL database `micro` must be running. Kafka is optional for this local baseline: notifications are disabled by default. To enable Kafka notifications after starting a Kafka broker on `localhost:29092`, set `APP_NOTIFICATIONS_ENABLED=true` before starting the order and notification services.

Verify the stack through the gateway:

```powershell
Invoke-WebRequest 'http://localhost:8080/api/inventory?skuCode=Iphon1' | Select-Object -Expand Content
```
