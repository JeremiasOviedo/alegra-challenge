FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/msvc-warehouse

COPY ./pom.xml /app
COPY ./msvc-warehouse/.mvn ./.mvn
COPY ./msvc-warehouse/mvnw .
COPY ./msvc-warehouse/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./msvc-warehouse/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder app/msvc-warehouse/target/msvc-warehouse-0.0.1-SNAPSHOT.jar .

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "msvc-warehouse-0.0.1-SNAPSHOT.jar"]