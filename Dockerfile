FROM amazoncorretto:17-alpine-jdk

MAINTAINER EZEQUIEL

COPY /target/Portfolio-0.0.1-SNAPSHOT.jar ez-portfolio.jar

ENTRYPOINT ["java","-jar","/ez-portfolio.jar"]
