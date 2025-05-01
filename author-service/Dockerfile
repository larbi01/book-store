FROM eclipse-temurin:17-jre
ARG JAR=target/*.jar
COPY ${JAR} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
