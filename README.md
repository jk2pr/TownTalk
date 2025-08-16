# TownTalk

TownTalk is a Kotlin + Spring Boot application that provides a backend service for a town/community discussion platform.

## Features
- Kotlin-first Spring Boot service
- Java 21 runtime via Gradle toolchain
- Ready for containerization and cloud deployment
- Configurable via Spring Profiles and environment variables

## Tech Stack
- Kotlin (JVM)
- Spring Boot
- Java 21
- Build tool: Gradle

## Prerequisites
- Java Development Kit (JDK) 21
- Gradle wrapper (included) or Gradle 8+
- Optional: Docker 24+ (for containerized runs)

## Getting Started

### 1) Clone the repository
```shell script
git clone <your-repo-url>.git
cd <your-project-folder>
```


### 2) Build (Gradle)
```shell script
# Linux/macOS
./gradlew clean build

# Windows (PowerShell/CMD)
gradlew.bat clean build
```


### 3) Run locally (dev)
- Using Gradle:
```shell script
# Linux/macOS
SPRING_PROFILES_ACTIVE=dev ./gradlew bootRun

# Windows (PowerShell)
$env:SPRING_PROFILES_ACTIVE="dev"; ./gradlew bootRun
```


- Or run the packaged JAR (default output name):
```shell script
java -jar build/libs/TownTalk.jar
```


The app starts on the configured server port (default 8080).

## Configuration

### Spring Profiles
Use profiles to switch configurations (e.g., dev, prod).

Activate a profile:
```shell script
# JVM system property
java -Dspring.profiles.active=dev -jar build/libs/TownTalk.jar

# or environment variable
SPRING_PROFILES_ACTIVE=dev ./gradlew bootRun
```


### Common Environment Variables
- SERVER_PORT: HTTP port (default 8080)
- SPRING_PROFILES_ACTIVE: active profile (e.g., dev, prod)
- SPRING_DATASOURCE_URL, SPRING_DATASOURCE_USERNAME, SPRING_DATASOURCE_PASSWORD: database config (if applicable)
- LOGGING_LEVEL_ROOT: logging level (e.g., INFO, DEBUG)

Example:
```shell script
SERVER_PORT=8081 SPRING_PROFILES_ACTIVE=dev ./gradlew bootRun
```


## API
- Base URL: http://localhost:8080
- Health endpoint (if Spring Boot Actuator is enabled): /actuator/health

As you add endpoints, consider:
- OpenAPI/Swagger (springdoc-openapi)
- Postman collections
- README curl examples

## Docker

Build and run with Docker (example workflow):
```shell script
# Build the app JAR first, then:
docker build -t towntalk:latest .
docker run --rm -p 8080:8080 -e SPRING_PROFILES_ACTIVE=prod towntalk:latest
```


## CI/CD
A GitHub Actions workflow can build the project with Gradle and optionally build/push a Docker image on pushes and pull requests to the main branch. Configure required secrets in your repository settings if you plan to push images to a registry.

## Project Structure (typical Spring Boot)
- src/main/kotlin/...: application code
- src/main/resources: configuration (application.yml, static files)
- src/test/kotlin/...: tests (if/when added)

## Observability
- Logging: configurable via application properties
- Actuator (optional): health, metrics, info
  - Enable by adding/confirming the Spring Boot Actuator dependency and exposing desired endpoints

## Development Tips
- Use Spring Profiles for local vs production settings
- Keep secrets in environment variables or a secrets manager
- Add API documentation early (OpenAPI) for maintainability
- Consider enabling Flyway/Liquibase for DB migrations when adding a real database
