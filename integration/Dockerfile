FROM maven:3.9.0-amazoncorretto-17 as build

WORKDIR /opt/app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY ./src ./src
RUN mvn clean install -Dmaven.test.skip=true

FROM amazoncorretto:17-alpine3.17
WORKDIR /opt/app
COPY --from=build /opt/app/target/mcaBackend-1.0.jar /opt/app

CMD java -jar target/mcaBackend-1.0.jar