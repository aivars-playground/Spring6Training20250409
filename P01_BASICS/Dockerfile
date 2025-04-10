FROM openjdk:24-jdk AS base
WORKDIR /app
EXPOSE 80
EXPOSE 443

FROM base AS build
WORKDIR /app
COPY ./ ./
RUN ./mvnw package

FROM base AS final
WORKDIR /app
COPY --from=build /app/target/base-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-jar", "/app/app.jar"]