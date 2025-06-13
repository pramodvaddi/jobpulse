# Use Java 24 runtime
FROM eclipse-temurin:24-jdk

# Set working directory
WORKDIR /app

# Copy built JAR to container
COPY target/jobpulse-0.0.1-SNAPSHOT.jar app.jar

# Run Spring Boot JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
