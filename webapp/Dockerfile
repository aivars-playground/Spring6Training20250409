FROM openjdk:24-jdk AS build
WORKDIR /app
COPY ./ ./
RUN --mount=type=cache,target=/root/.m2,rw
RUN ./mvnw package

FROM openjdk:24-jdk AS final
WORKDIR /app
COPY --from=build /app/target/webapp-0.0.1-SNAPSHOT.jar /app/webapp.jar
ENTRYPOINT ["java","-jar", "/app/webapp.jar"]