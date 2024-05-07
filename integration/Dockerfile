FROM maven:3.9.0-amazoncorretto-17 as build

WORKDIR /opt/app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY ./src ./src
RUN mvn clean install -Dmaven.test.skip=true

RUN rm -v $PWD:/src/main/resources openapitools/openapi-generator-cli generate -i /resources/videGames.yaml -g go -o /local/out/go