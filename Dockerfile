FROM amazoncorretto:19-alpine-jdk

MAINTAINER EZEQUIEL

EXPOSE 8080

COPY target/Portfolio-0.0.1-SNAPSHOT.jar ez-portfolio.jar

ENTRYPOINT ["java","-jar","/ez-portfolio.jar"]
