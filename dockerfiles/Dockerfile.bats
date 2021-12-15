FROM maven:3.6-jdk-11 AS build
COPY pom.xml /home/app/pom.xml
RUN mvn -f /home/app/pom.xml verify clean --fail-never
COPY src /home/app/src
RUN mvn -f /home/app/pom.xml package -Dmaven.test.skip=true

FROM openjdk:11-jre-slim
VOLUME /tmp 
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
