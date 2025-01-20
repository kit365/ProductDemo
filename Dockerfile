# Sử dụng image Java chính thức
FROM openjdk:17-jdk-slim

# Đặt thư mục làm việc trong container
WORKDIR /app

# Copy file JAR vào container
COPY target/*.jar app.jar

# Expose cổng 8080 (hoặc cổng khác nếu bạn đổi)
EXPOSE 8080

# Command để chạy ứng dụng Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
