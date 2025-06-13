# ===== Stage 1: Build the JAR using Maven =====
FROM eclipse-temurin:24-jdk as builder

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

# ===== Stage 2: Run the app =====
FROM eclipse-temurin:24-jdk

WORKDIR /app

COPY --from=builder /app/target/jobpulse-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
