FROM maven:3.9-eclipse-temurin-21 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM eclipse-temurin:25.0.2_10-jre-noble
COPY --from=build /home/app/target/ns-1.0.0.jar /usr/local/lib/ns-1.0.0.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/ns-1.0.0.jar"]
