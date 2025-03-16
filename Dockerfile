FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

COPY gradle/ gradle/
COPY gradlew .
COPY build.gradle .
COPY settings.gradle .

RUN ./gradlew --no-daemon dependencies

COPY src src

RUN ./gradlew --no-daemon build -x test


FROM eclipse-temurin:21-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
