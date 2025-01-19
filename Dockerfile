
FROM maven:3.9.9-amazoncorretto-8-al2023 AS build
COPY . .
RUN mvn clean package -ProductDemo

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
