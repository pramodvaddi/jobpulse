# 1️⃣ Base image: lightweight Linux with Java 17
FROM eclipse-temurin:24-jdk



# 2️⃣ Set the working directory inside the container
WORKDIR /app

# 3️⃣ Copy the built JAR from your machine into the container
COPY target/jobpulse-0.0.1-SNAPSHOT.jar app.jar

# 4️⃣ Command to run your Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
