FROM eclipse-temurin:23-jdk
LABEL authors="chester.kim"
WORKDIR /app
RUN apt update && apt install -y libgomp1
COPY models /app/models
COPY target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]