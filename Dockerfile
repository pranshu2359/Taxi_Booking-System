FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /workspace
COPY . .
RUN mvn -B clean package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=build /workspace/target/TaxiBooking-0.0.1-SNAPSHOT.war app.war

EXPOSE 10000
ENTRYPOINT ["java", "-jar", "app.war"]
