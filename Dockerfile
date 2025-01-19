# Sử dụng Maven phiên bản mới nhất
FROM maven:3.9.9-amazoncorretto-8-al2023 AS build
COPY . .
RUN mvn clean package -PProductDemo

# Sử dụng OpenJDK phiên bản mới nhất
FROM bellsoft/liberica-runtime-container:jdk-17-musl
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
