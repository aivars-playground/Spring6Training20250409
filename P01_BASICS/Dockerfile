FROM openjdk:24-jdk AS build
WORKDIR /app
COPY ./ ./
RUN ./mvnw package

FROM openjdk:24-jdk AS final
WORKDIR /app
COPY --from=build /app/target/base-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-jar", "/app/app.jar"]