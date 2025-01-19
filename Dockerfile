# Sử dụng hình ảnh Java chính thức làm cơ sở
FROM openjdk:17-jdk-slim

# Đặt biến môi trường
ENV SPRING_PROFILES_ACTIVE=prod

# Copy file JAR vào container
COPY target/ProductDemo-0.0.1-SNAPSHOT.jar app.jar

# Expose cổng mà ứng dụng sử dụng
EXPOSE 8080

# Lệnh khởi chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
