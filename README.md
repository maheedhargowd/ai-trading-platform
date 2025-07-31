# AI Trading Platform Backend

## Overview
Spring Boot REST API with:
- JPA persistence using H2 in-memory DB
- CRUD endpoints for managing trades
- Basic validation and error handling on POST requests

## How to Run
1. Make sure Java 17+ and Maven are installed.
2. Clone repo and run: mvn spring-boot:run
3. Access app at `http://localhost:8080`

## API Endpoints

### GET /api/trades  
Retrieve all trades.

**Response Example:**
[
{"id":1,"symbol":"AAPL","quantity":10},
{"id":2,"symbol":"GOOG","quantity":20}
]

### POST /api/trades  
Create a new trade (JSON body).

**Request Example:**
{
"symbol": "TSLA",
"quantity": 15
}


**Error Responses:**
- 400 Bad Request if `symbol` is empty or `quantity` < 1  
  Example error message: `"symbol: Symbol is mandatory; quantity: Quantity must be at least 1;"`

## Next Steps
- Add PUT and DELETE endpoints
- Persist data in a real DB like PostgreSQL
- Implement authentication/security
- Integrate AI for automated trade signals


