# === Stage 1: Build the Spring Boot JAR ===
FROM eclipse-temurin:24-jdk as builder

WORKDIR /app

# Copy everything (pom.xml, src/, mvnw, etc.)
COPY . .

# Grant permission to Maven wrapper
RUN chmod +x mvnw

# Build the JAR (skip tests)
RUN ./mvnw clean package -DskipTests

# === Stage 2: Run the JAR ===
FROM eclipse-temurin:24-jdk

WORKDIR /app

COPY --from=builder /app/target/jobpulse-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
