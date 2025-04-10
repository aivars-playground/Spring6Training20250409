Experimenting with Docker Build
====

builds multiple docker images
```shell
docker compose up -d
```

Spring webapp can be started from the source, demo_webapp_service must be stopped
```shell
docker compose stop demo_webapp_service
```

Spring webapp project can be run outside the Docker (using Mongo localhost:27017 running in docker)
```shell
cd webapp
./mvnw spring-boot:run
```

Spring webapp project can be conteinarized to run in docker and use internal network
```shell
cd webapp
docker build -t standalone-webapp .
docker run --network demo-infrastructure_demo-network --publish 8080:8080 -e MONGO_CACHE_URL='mongodb://demo_mongo_cache_service:27017' --name my-standalone-webapp standalone-webapp
```

Spring webapp can be started from IntelliJ runner in docker-compose mode:
* create new run configuration
* select from docker-compose
* select parent docker compose file (select web service)
* environment values will be picked from compose file

Spring webapp can be started from IntelliJ runner in docker mode:
* create new run configuration
* select from docker
* pull openjdk:24-jdk
* run options
* ```--network demo-infrastructure_demo-network --publish 8080:8080 -e MONGO_CACHE_URL=mongodb://demo_mongo_cache_service:27017 --name my-standalone-webapp --rm```