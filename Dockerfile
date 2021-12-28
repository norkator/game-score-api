FROM gradle:jdk11 AS builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
# -x test will skip test
RUN gradle clean build -x test


FROM openjdk:12-alpine
EXPOSE 8080
WORKDIR /home/application/java
COPY --from=builder /home/gradle/src/build/libs/gamescoreapi-*-SNAPSHOT.jar gamescoreapi.jar
ENTRYPOINT ["java", "-jar", "gamescoreapi.jar"]