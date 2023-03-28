FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/msvc-kitchen

COPY ./pom.xml /app
COPY ./msvc-kitchen/.mvn ./.mvn
COPY ./msvc-kitchen/mvnw .
COPY ./msvc-kitchen/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./msvc-kitchen/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder app/msvc-kitchen/target/msvc-kitchen-0.0.1-SNAPSHOT.jar .

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "msvc-kitchen-0.0.1-SNAPSHOT.jar"]