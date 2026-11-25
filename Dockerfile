# primero compila el jar con maven
FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -q package -DskipTests

# y luego solo se queda con el jar
FROM eclipse-temurin:25-jre
COPY --from=build /app/target/holamundo-0.0.1-SNAPSHOT.jar /usr/share/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/share/app.jar"]
