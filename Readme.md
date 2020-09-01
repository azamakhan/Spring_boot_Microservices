# Spring_Boot_Microservices
A simple Spring Boot microservices and Spring Cloud(Eureka Naming Server, Ribbon, Feign, Zuul, Sleuth, Zipkin).

The following has been implemented in this project:

* Established Communication between Microservices, namely - Currency-exchange-service with Currency-conversion-service.
* Centralized Microservice Configuration with Spring Cloud Config Server.
* Simplified communication with other Microservices using Feign REST Client.
* Implemented client side load balancing with Ribbon.
* Implemented dynamic scaling using Eureka Naming Server and Ribbon.
* Implemented API Gateway with Zuul.
* Implemented Distributed tracing with Spring Cloud Sleuth and Zipkin.
* Implemented Fault Tolerance with Zipkin.

***

## How to use:
1. Download the project

2. Run pom.xml for project (mvn clean package)

3. Run *application.java* in following order:
  1. Run NetflixEurekaNamingServerApplication.java
  2. Run NetflixZuulApiGatewayServerApplication.java
  3. CurrencyExchangeServiceApplication.java
  4. CurrencyConversionServiceApplication.java
  
4. Example:
  http://localhost:8100/currency-converter-feign/from/EUR/to/INR/quantity/7500 and
  http://localhost:8765/currency-conversion-service/currency-converter-feign/from/EUR/to/INR/quantity/100

***

## Ports
| Application |Port|
|---|---|
| Netflix Eureka Name Server | 8761 |
| Netflix Zuul API Gateway Server | 8761 |
| Currency Exchange Service | 8000, 8001, ... |
| Currency Conversion Service | 8100, 8101 |
| Zipkin Distributed Tracing Server| 9411 |
| H2 Database | 8000 |

***

## URLs
| Application | URL |
|---|---|
| Netflix Eureka Name Server | http://localhost:8761/ |
| Netflix Zuul API Gateway Server | http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/10 |
| Currency Exchange Service |	http://localhost:8000/currency-exchange/from/EUR/to/INR http://localhost:8001/currency-exchange/from/USD/to/INR |
| Currency Conversion Service | http://localhost:8100/currency-converter-feign/from/EUR/to/INR/quantity/10000 |
| Zipkin Distributed Tracing Server | 	http://localhost:9411/zipkin/ |
| H2 Database | http://localhost:8000/h2 |

***

### Note:
* Zipkin needs to be installed separately.

* Visit Quick Start Page:
  https://zipkin.io/pages/quickstart

* Downloading Zipkin Jar
  https://search.maven.org/remote_content?g=io.zipkin.java&a=zipkin-server&v=LATEST&c=exec

* Command to run:
  RABBIT_URI=amqp://localhost
  java -jar zipkin-server-2.12.9-exec.jar 

* If needed, currency-exchange-service uses data.sql file to load exchange values into H2 database.
Uses the following query to insert the values:
```sql
insert into exchange_value values(101, 75, 'USD', 0, 'INR');

insert into exchange_value values(102, 90, 'EUR', 0, 'INR');

insert into exchange_value values(103, 20, 'INR', 0, 'YEN');
```

---
  