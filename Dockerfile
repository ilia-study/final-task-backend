#
# Build stage
#
FROM maven:3.8.6-openjdk-18 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:18.0.2.1-jdk
COPY --from=build /home/app/target/tenders-server-1.0-SNAPSHOT.jar /usr/local/lib/tenders-server.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/tenders-server.jar"]