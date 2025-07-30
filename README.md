# AI Trading Platform Backend

This is a backend-only Spring Boot REST API for a trading platform.  
Today’s build focused on:

- Setting up a Maven Spring Boot project with `spring-boot-starter-web`.
- Creating first REST endpoints (`GET /api/trades`).
- Defining a simple `Trade` data model.
- Adding a service layer to separate business logic.
- Returning hardcoded trade data (no database integration yet).

## Project Structure

- `controller/` - REST controllers handling HTTP requests
- `service/` - Business logic layer
- `model/` - Data models representing trade information

## How to Run

1. Ensure Java 17+ and Maven are installed.
2. Clone the repo: `https://github.com/maheedhargowd/ai-trading-platform.git`
3. Run Spring Boot:  mvn spring-boot:run
4. Test endpoint:  `GET http://localhost:8080/api/trades`  
Should return a JSON array of trades.

## Next Steps

- Add persistence with a database (JPA + H2/PostgreSQL).
- Implement POST endpoints to create new trades.
- Add basic security.
- Plan AI integration for trade signals.

---

_Summary:_ This project is an evolving Spring Boot backend platform for AI-powered trading.


