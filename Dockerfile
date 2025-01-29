# Build stage
FROM maven:3-eclipse-temurin-21 AS build
WORKDIR /app

COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY --from=build /app/target/ProductDemo-0.0.1-SNAPSHOT.jar ProductDemo.jar
EXPOSE 8080 

ENTRYPOINT ["java", "-jar", "ProductDemo.jar"]
