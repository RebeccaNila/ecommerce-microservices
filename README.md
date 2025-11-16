# E-Commerce Microservices Platform

E-commerce platform built with Spring Boot microservices architecture.

## 🏗️ Architecture
```
├── API Gateway (Port: 9900)
├── Product Service (Port: 7000)
├── Order Service (Port: 7001)
├── Inventory Service (Port: 7002)
```

## 🛠️ Tech Stack

- **Backend**: Java 21, Spring Boot 3.4, Spring Cloud 2024
- **Database**: MongoDB, MySql
- **Message Queue**: RabbitMQ / Kafka
- **Authentication**: Keycloak / OAuth2
- **API Documentation**: Springdoc OpenAPI
- **Containerization**: Docker, Docker Compose
- **Orchestration**: Kubernetes (optional)

## 📦 Microservices

### 1. API Gateway
- Routes requests to appropriate services
- Authentication & Authorization
- Rate limiting
- **Port**: 9900

### 2. Product Service
- Product CRUD operations
- Product search and filtering
- Category management
- **Port**: 7000

### 3. Order Service
- Order creation and management
- Order history
- Order status tracking
- **Port**: 7001

### 4. Inventory Service
- Stock management
- Inventory updates
- Stock validation
- **Port**: 7002


## 🚀 Getting Started

### Prerequisites
- Java 21+
- Maven 3.8+
- Docker & Docker Compose
- MongoDB and MySql
- Keycloak (for authentication)

### Running Locally

1. **Clone the repository**
```bash
git clone https://github.com/RebeccaNila/ecommerce-microservices.git
cd ecommerce-microservices
```

2. **Start infrastructure services**
```bash
docker-compose up -d 
```

3. **Run each microservice**
```bash
# Terminal 1 - API Gateway
cd api-gateway
mvn spring-boot:run

# Terminal 2 - Product Service
cd product-service
mvn spring-boot:run

# Terminal 3 - Order Service
cd order-service
mvn spring-boot:run

# ... and so on
```

### Running with Docker Compose
```bash
docker-compose up --build
```

## 📚 API Documentation

Once services are running, access Swagger UI:
- **API Gateway**: http://localhost:9900/swagger-ui.html
- **Product Service**: http://localhost:7000/swagger-ui.html
- **Order Service**: http://localhost:7001/swagger-ui.html
- **Inventory Service**: http://localhost:7002/swagger-ui.html

## 🗄️ Database Schema

Each service has its own database (database per service pattern):
- `product_db` - Product Service
- `order_db` - Order Service
- `inventory_db` - Inventory Service


## 🔐 Authentication

Using Keycloak for OAuth2/OpenID Connect:
- **Keycloak Admin**: http://localhost:8000
- **Realm**: `ecommerce-realm`
- **Clients**: `api-gateway`, `product-service`, etc.

## 📊 Architecture Diagram
```
                    ┌─────────────────┐
                    │   API Gateway   │
                    │   (Port: 9900)  │
                    └────────┬────────┘
                             │
          ┌──────────────────┼──────────────────┐
          │                  │                  │
    ┌─────▼─────┐     ┌─────▼─────┐     ┌─────▼─────┐
    │  Product  │     │   Order   │     │ Inventory │
    │  Service  │────▶│  Service  │────▶│  Service  │
    │ (7000)    │     │  (7001)   │     │  (7002)   │
    └───────────┘     └───────────┘     └───────────┘
          │                  │                  │
    ┌─────▼─────┐     ┌─────▼─────┐     ┌─────▼─────┐
    │ Product   │     │  Order    │     │ Inventory │
    │    DB     │     │    DB     │     │    DB     │
    └───────────┘     └───────────┘     └───────────┘
```

## 🧪 Testing

Run tests for all services:
```bash
mvn clean test
```

## 📝 TODO

- [ ] Add Service Discovery (Eureka)
- [ ] Implement Circuit Breaker (Resilience4j)
- [ ] Add Distributed Tracing (Zipkin/Jaeger)
- [ ] Implement Event-Driven Architecture
- [ ] Add Kubernetes deployment files
- [ ] Add monitoring (Prometheus + Grafana)

## 👩‍💻 Author

**Rebecca Nila**
- GitHub: [@RebeccaNila](https://github.com/RebeccaNila)
- LinkedIn: [Nilar Win](https://www.linkedin.com/in/nilar-win-rebecca/)

## 📄 License
