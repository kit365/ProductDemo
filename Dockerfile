# Sử dụng Maven với JDK 21
FROM maven:3.9.9-openjdk-21-alpine AS build
COPY . .
RUN mvn clean package -PProductDemo

# Sử dụng OpenJDK 21
FROM openjdk:21-jdk-slim
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
