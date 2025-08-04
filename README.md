
# AI Trading Platform Backend

## Overview
Spring Boot REST API with:
- JPA persistence using **Supabase PostgreSQL** (cloud database)
- CRUD endpoints for managing trades
- Input validation and error handling on requests

## How to Run
1. Make sure Java 17+ and Maven are installed.
2. Clone repo and edit `src/main/resources/application.properties` with your Supabase connection details:
    ```
    spring.datasource.url=jdbc:postgresql://aws-0-ap-south-1.pooler.supabase.com:5432/postgres?user=postgres.hxqybijgpbqkuecmttoe&password=****
    spring.datasource.username=aitradeplatform
    spring.datasource.password=****
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```
3. Run the app:  
   `mvn spring-boot:run`
4. Access app at `http://localhost:8080`

## API Endpoints

### GET /api/trades/getalltrades  
Retrieve all trades.

**Response Example:**
```json
[
  {"id":1,"symbol":"AAPL","quantity":10},
  {"id":2,"symbol":"GOOG","quantity":20}
]
```

### POST /api/trades/savetrade  
Create a new trade (JSON body).

**Request Example:**
```json
{
  "symbol": "TSLA",
  "quantity": 15
}
```

**Success Response:**
- 201 Created  
  Body: `"Trade saved successfully"`

**Error Responses:**
- 400 Bad Request if `symbol` is empty or `quantity` < 1  
  Example: `"symbol: symbol is manditory; quantity: quantity must be atlesst 1;"`
- 409 Conflict if a trade with the same symbol already exists  
  Example: `"trade already exists"`

### PUT /api/trades/updatetrade{id}  
Update details of an existing trade by id.

**Request Example:**
```json
{
  "symbol": "TSLA",
  "quantity": 25
}
```

**Success Response:**  
- 200 OK  
  Body: `"trade updated successfully"`

### DELETE /api/trades/deletetrade{id}  
Delete a trade by id.

**Success Response:**  
- 200 OK  
  Body: `"trade deleted successfully"`

## Database
- Trade data is stored in your Supabase PostgreSQL database.
- Tables are auto-created on first run.
- `symbol` is **not yet enforced as unique**—duplicate symbols can be added (planned improvement).

## Next Steps
- Prevent duplicate trades by symbol (enforce unique constraints)
- Implement authentication/security
- Integrate AI for automated trade signals
